package com.gw.config;

import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.util.ObjectUtils;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.gw.base.resp.ApiResp;
import com.gw.constans.ResCodeContants;
import com.gw.swagger.SwaggerProvider;
import com.gw.util.ThreadLocalUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class SentinelConfig {
	/**
	 * 限流阈值
	 */
	@Value("${spring.cloud.sentinel.count}")
	private int count;
	
	/**
	 * 统计时间
	 */
	@Value("${spring.cloud.sentinel.intervalSec}")
	private int intervalSec;
	
	@Autowired
	private SwaggerProvider swaggerProvider;
	private final List<ViewResolver> viewResolvers;
	private final ServerCodecConfigurer serverCodecConfigurer;

	public SentinelConfig(List<ViewResolver> viewResolvers, ServerCodecConfigurer serverCodecConfigurer) {
		this.viewResolvers = viewResolvers;
		this.serverCodecConfigurer = serverCodecConfigurer;
	}

	// 初始化一个限流的过滤器
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public GlobalFilter sentinelGatewayFilter() {
		return new SentinelGatewayFilter();
	}

	// 配置初始化的限流参数
	@PostConstruct
	public void initGatewayRules() {
		Set<GatewayFlowRule> rules = new HashSet<>();
		// 分别给指定的资源 配置限流
		// GatewayFlowRule 资源名称,对应路由id setCount 限流阈值 setIntervalSec 统计时间窗口，单位是秒，默认是 1 秒
		// 简单来说就是 如果Count=1 IntervalSec=1 那么一秒钟只允许访问一次 (用于测试)
		// 如果Count=5 IntervalSec=2 那么2秒钟只允许访问5次 (用于测试)
		// 如果Count=60 IntervalSec=3 那么3秒钟只允许访问60次 也就是1秒20次 一般用于生产(一般够了)
		// 如果是商城网站那么Count和IntervalSec 这个需要计算平均每天每秒最大的请求量是多少然后在设置
		List<String> routs = swaggerProvider.getRouts();
		int num = 0;
		while (num < 5) {
			if (ObjectUtils.isEmpty(routs) || routs.size() == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				num++;
			} else {
				routs.forEach(vo -> {
					rules.add(new GatewayFlowRule(vo).setCount(count).setIntervalSec(intervalSec));
				});
				break;
			}
		}
		// 设置指定路由的限流
//		rules.add(new GatewayFlowRule("path_route_1").setCount(count).setIntervalSec(intervalSec));
//		rules.add(new GatewayFlowRule("path_route_2").setCount(count).setIntervalSec(intervalSec));

		GatewayRuleManager.loadRules(rules);

	}

	// 配置限流的异常处理器
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler() {
		return new SentinelGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
	}

	// 自定义限流异常页面
	@PostConstruct
	public void initBlockHandlers() {
		BlockRequestHandler blockRequestHandler = new BlockRequestHandler() {
			@Override
			@SuppressWarnings({ "deprecation", "unchecked" })
			public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable throwable) {
				Flux<DataBuffer> flux = ThreadLocalUtil.get();
				AtomicReference<String> requestBody = new AtomicReference<>("");
		        flux.subscribe(buffer -> {
		            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
		            requestBody.set(charBuffer.toString());
		        });
		        ApiResp error = ApiResp.error(ResCodeContants.SYS_ERROR, "请求太频繁，请稍后再试");
				return ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(BodyInserters.fromObject(error));
			}
		};
		GatewayCallbackManager.setBlockHandler(blockRequestHandler);
	}
}

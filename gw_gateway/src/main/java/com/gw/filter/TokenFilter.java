package com.gw.filter;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSON;
import com.gw.base.resp.ApiResp;
import com.gw.config.JWTConfig;
import com.gw.util.RedisUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

/**
 * token拦截器
 * 
 * @author yangxy
 * @version 创建时间：2023年10月24日 上午11:40:37
 */
@Component
public class TokenFilter implements GlobalFilter, Ordered {
	@Autowired
	private RedisUtils redisUtils;

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		
		String tokenHeader = exchange.getRequest().getHeaders().getFirst(JWTConfig.tokenHeader);
		if (StringUtils.isEmpty(tokenHeader)) {
			return chain.filter(exchange);
		}
		if (!tokenHeader.startsWith(JWTConfig.tokenPrefix)) {
			return Mono.defer(() -> {
				exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);// 设置status
				final ServerHttpResponse response = exchange.getResponse();
				ApiResp jwtError = ApiResp.jwtError("无效token");
//		            byte[] bytes = "{\"code\":\"99999\",\"message\":\"非法访问,没有检测到token~~~~~~\"}".getBytes(StandardCharsets.UTF_8);
				DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(JSON.toJSONString(jwtError).getBytes());
				return response.writeWith(Flux.just(buffer));// 设置body
			});
		}
		String token = tokenHeader.replace(JWTConfig.tokenPrefix, "");
		if(redisUtils.hasKey(token)) {
    		if(redisUtils.getExpire(token) <= 30*60) {//过期时间小于等于半小时自动续期
    			redisUtils.expire(token, 2*60*60);
    		}
    		try {
                // 解析JWT
                Claims claims = Jwts.parser()
                        .setSigningKey(JWTConfig.secret)
                        .parseClaimsJws(token)
                        .getBody();
                // 获取用户名
                String userJsonString = claims.getSubject();
                LinkedHashMap<String, String> headerMap = new LinkedHashMap<>();
                headerMap.put("user", userJsonString);
                chainFilterAndSetHeaders(chain, exchange, headerMap);
            } catch (ExpiredJwtException e){
            	return Mono.defer(() -> {
    				exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);// 设置status
    				final ServerHttpResponse response = exchange.getResponse();
    				ApiResp jwtError = ApiResp.jwtError("登录超时");
//    		            byte[] bytes = "{\"code\":\"99999\",\"message\":\"非法访问,没有检测到token~~~~~~\"}".getBytes(StandardCharsets.UTF_8);
    				DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(JSON.toJSONString(jwtError).getBytes());
    				return response.writeWith(Flux.just(buffer));// 设置body
    			});
            } catch (Exception e) {
            	return Mono.defer(() -> {
    				exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);// 设置status
    				final ServerHttpResponse response = exchange.getResponse();
    				ApiResp jwtError = ApiResp.jwtError("无效token");
//    		            byte[] bytes = "{\"code\":\"99999\",\"message\":\"非法访问,没有检测到token~~~~~~\"}".getBytes(StandardCharsets.UTF_8);
    				DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(JSON.toJSONString(jwtError).getBytes());
    				return response.writeWith(Flux.just(buffer));// 设置body
    			});
            }
    	}
		
		
		return chain.filter(exchange);
	}
	
	/**
     * 设置向后传递的header
     *
     * @param chain
     * @param exchange
     * @param headerMap
     */
    private Mono<Void> chainFilterAndSetHeaders(GatewayFilterChain chain, ServerWebExchange exchange, LinkedHashMap<String, String> headerMap) {
        // 添加header
        Consumer<HttpHeaders> httpHeaders = httpHeader -> {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                // 遍历Map设置header，向后传递
                httpHeader.set(entry.getKey(), entry.getValue());
            }
        };

        ServerHttpRequest newRequest = exchange.getRequest().mutate().headers(httpHeaders).build();
        ServerWebExchange build = exchange.mutate().request(newRequest).build();
        //将现在的request 变成 exchange对象
        return chain.filter(build);
    }

}

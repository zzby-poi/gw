package com.gw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/** 
* @author yangxy
* @version 创建时间：2023年10月25日 上午11:35:40 
*/
@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfig {
	@Bean
    SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) throws Exception {
 
        http.authorizeExchange()
                .anyExchange()
                .permitAll();
 
        // 一些配置
        http
                .csrf().disable()
                .httpBasic().disable()
                .logout().disable()
                .formLogin().disable();
        return http.build();
    }
}

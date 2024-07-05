package com.example.soloProject.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 내 서버가 응답을 할때 json을 자바스크립트에서 처리 가능?
        config.addAllowedOrigin("*"); // 모든 ip 응답을 허용?
        config.addAllowedHeader("*"); // 모든 header의 응답을 허용?
        config.addAllowedMethod("*"); // 모든 post, get, put, path의 요청을 허용?
        source.registerCorsConfiguration("/api/**", config);

        return new CorsFilter(source);
    }
}

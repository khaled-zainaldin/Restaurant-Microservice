//package com.cloud_gateway.cloud_gateway.gateway_config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GatewayConfig {
//
//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder) {
//        return builder.routes()
//
//                .route("menuitem-service", r -> r.path("/menu/**")
//                        .uri("lb://MENUITEM-SERVICE"))
//
//                .route("order-service", r -> r.path("/orders/**")
//                        .uri("lb://ORDER-SERVICE"))
//
//                .route("payment-service", r -> r.path("/payments/**")
//                        .uri("lb://PAYMENT-SERVICE"))
//
//                .build();
//    }
//}
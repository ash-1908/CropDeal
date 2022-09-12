package com.demo.cropdeal.gateway.config;

import com.demo.cropdeal.gateway.model.MyResponseModel;
import org.apache.http.HttpHeaders;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {
	
	public AuthFilter() {
		super(Config.class);
	}
	
	@Override
	public GatewayFilter apply(AuthFilter.Config config) {
		return (exchange, chain) -> {
			if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
				throw new RuntimeException("Unauthorized!");
			}
			 
			String[] header = exchange.getRequest().getHeaders()
				.get(HttpHeaders.AUTHORIZATION).get(0).split(" ");
			
			if (header.length != 2 || !header[0].startsWith("Bearer")) {
				throw new RuntimeException("Invalid authorization.");
			}
			
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForObject("http://localhost:8090/auth/validate-token?token=" + header[1], null,
				MyResponseModel.class);
			
			return chain.filter(exchange);
		};
	}
	
	public static class Config {
	}
}
package com.pinelabs.billing_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
public class BillingOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingOrderApplication.class, args);
	}

	@Bean
	public WebClient getWebClient() {
		return WebClient.builder()
				.baseUrl("http://localhost:8082/api/v1/store/")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
}

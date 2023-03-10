package com.oldsteel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class OldSteelOtoApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder
//				.setConnectTimeout(Duration.ofMillis(3000))
//				.setReadTimeout(Duration.ofMillis(3000))
//				.build();
		final RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);

		return restTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(OldSteelOtoApplication.class, args);
	}

}

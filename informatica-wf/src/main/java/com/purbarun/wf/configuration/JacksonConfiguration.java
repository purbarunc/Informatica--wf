package com.purbarun.wf.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfiguration {

	@Bean
	@Scope("singleton")
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}

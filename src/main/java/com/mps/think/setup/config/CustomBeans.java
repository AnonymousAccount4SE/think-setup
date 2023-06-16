package com.mps.think.setup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomBeans {
	
	@Bean
	public ObjectMapper createMapper() {
		return new ObjectMapper();
	}

}

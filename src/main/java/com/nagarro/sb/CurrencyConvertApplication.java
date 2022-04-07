package com.nagarro.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Currency convert API", version = "1.0", description = "Converts currency based on available records in database"))
public class CurrencyConvertApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConvertApplication.class, args);
	}

}

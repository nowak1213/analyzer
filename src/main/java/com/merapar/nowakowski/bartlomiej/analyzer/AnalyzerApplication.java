package com.merapar.nowakowski.bartlomiej.analyzer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnalyzerApplication {

	@Value("${server.port}")

	public static void main(String[] args) {
		SpringApplication.run(AnalyzerApplication.class, args);
	}

}

package com.melon.sm;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableBatchProcessing
@EnableJpaRepositories(basePackages = "com.melon.sm")
@EnableTransactionManagement
@EnableAutoConfiguration
public class MelonApplication {

	public static void main(String[] args) {

		for (String arg : args) {
			System.out.println(arg);
		}

		SpringApplication app = new SpringApplication(MelonApplication.class);

		app.run(args);
	}
}

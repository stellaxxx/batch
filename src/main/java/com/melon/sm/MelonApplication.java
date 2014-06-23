package com.melon.sm;

import java.util.Iterator;

import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.base.Preconditions;
import com.melon.sm.batch.sample.Person;
import com.melon.sm.batch.sample.PersonRepository;

@Configuration
@ComponentScan
@EnableBatchProcessing
@EnableJpaRepositories(basePackages = "com.melon.sm")
@EnableTransactionManagement
@EnableAutoConfiguration
@Slf4j
public class MelonApplication {

	public static void main(String[] args) {

		for (String arg : args) {
			log.debug("arg : {}", arg);
		}

		SpringApplication app = new SpringApplication(MelonApplication.class);

		ConfigurableApplicationContext context = app.run(args);

		PersonRepository personRepository = context.getBean(PersonRepository.class);

		Preconditions.checkNotNull(personRepository);

		Iterable<Person> ite = personRepository.findAll();

		Iterator<Person> all = ite.iterator();
		while (all.hasNext()) {
			log.info("{}",all.next());
		}
	}
}

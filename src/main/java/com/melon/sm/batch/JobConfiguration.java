package com.melon.sm.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.melon.sm.batch.sample.Person;

@Configuration
public class JobConfiguration {
	@Autowired
	private JobBuilderFactory jobs;
	@Autowired
	private StepBuilderFactory steps;


	@Bean
	public Job myJob(Step myStep) {

		return jobs.get("myJob").incrementer(new RunIdIncrementer()).flow(myStep).end().build();
	}

	@Bean
	public Step myStep(ItemReader<Person> reader, ItemWriter<Person> writer, ItemProcessor<Person, Person> processor) {

		return steps.get("myStep").<Person, Person> chunk(10).reader(reader).processor(processor).writer(writer).build();
	}

	@Bean
	public Job mySecondJob(Step mySecondStep) {
		return jobs.get("mySecondJob").incrementer(new RunIdIncrementer()).flow(mySecondStep).end().build();
	}

	@Bean
	public Step mySecondStep(ItemReader<Person> reader, ItemWriter<Person> writer, ItemProcessor<Person, Person> processor) {
		return steps.get("mySecondStep").<Person, Person> chunk(5).reader(reader).processor(processor).writer(writer).build();
	}
}

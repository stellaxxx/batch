package com.melon.sm.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.melon.sm.batch.sample.Person;
import com.melon.sm.batch.sample.SampleItemProcessor;
import com.melon.sm.batch.sample.SampleItemReader;
import com.melon.sm.batch.sample.SampleItemWriter;
import com.melon.sm.batch.sample.SamplePartitioner;

@Configuration
// @ImportResource("classpath*:batch-config.xml")
public class JobConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public TaskExecutor taskExecutor() {
		return new SimpleAsyncTaskExecutor("sample");

	}

	@Bean
	public Step slaveStep() {
		return stepBuilderFactory.get("slaveStep").<Person, Person> chunk(1).reader(sampleItemReader()).writer(sampleItemWriter()).processor(sampleItemProcessor()).build();
	}

	@Bean
	public ItemReader<Person> sampleItemReader() {
		return new SampleItemReader();
	}

	@Bean
	public ItemProcessor<Person, Person> sampleItemProcessor() {
		return new SampleItemProcessor();
	}

	@Bean
	public ItemWriter<Person> sampleItemWriter() {
		return new SampleItemWriter();
	}

	@Bean
	public Step masterStep() {
		return stepBuilderFactory.get("masterStep")
				.partitioner(slaveStep())
				.partitioner("slaveStep", samplePartitioner())
				.gridSize(10)
				.taskExecutor(taskExecutor())
				.build();
	}

	@Bean
	public Partitioner samplePartitioner() {
		return new SamplePartitioner();
	}

	@Bean
	public Job myJob() {

		return jobBuilderFactory.get("myJob").start(masterStep()).build();
	}

}

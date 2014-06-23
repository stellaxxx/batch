package com.melon.sm.batch.sample;

import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

import com.melon.sm.batch.common.annotation.BatchProcessor;

@BatchProcessor
@StepScope
@Slf4j
public class SampleItemProcessor implements ItemProcessor<Person, Person> {

	@Value("#{stepExecutionContext[name]}")
	private String threadId;

	@Override
	public Person process(Person paramI) throws Exception {

		log.info("processor thread [{}] : person : {} ", threadId, paramI);

		return paramI;
	}

}

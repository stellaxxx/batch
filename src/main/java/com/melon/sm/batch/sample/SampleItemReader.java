package com.melon.sm.batch.sample;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Value;

import com.melon.sm.batch.common.annotation.BatchReader;

@BatchReader
@StepScope
@Slf4j
public class SampleItemReader implements ItemReader<Person> {

	@Value("#{stepExecutionContext[start]}")
	private int startIdx;

	@Value("#{stepExecutionContext[end]}")
	private int endIdx;

	private int idx;

	@PostConstruct
	private void afterInit() {
		idx = startIdx;
	}

	@Override
	public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		log.info("start : {}, end :{}  ==> person idx : {}", startIdx, endIdx, idx);

		while (idx != (endIdx + 1)) {
			Person p = new Person(idx++);
			p.setName("Test_" + idx);
			p.setEmail("test_" + idx + "@gmail.com");
			return p;
		}

		return null; // end
	}
}
package com.melon.sm.batch.sample;

import org.springframework.batch.item.ItemProcessor;

import com.melon.sm.batch.common.annotation.BatchProcessor;

@BatchProcessor
public class SampleItemProcessor implements ItemProcessor<Person, Person> {

	@Override
	public Person process(Person paramI) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

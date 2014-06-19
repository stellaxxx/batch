package com.melon.sm.batch.sample;

import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Value;

import com.melon.sm.batch.common.annotation.BatchReader;

@BatchReader
@Slf4j
public class SampleItemReader implements ItemReader<Person> {

	@Value("${date}")
	private String date;

	@Override
	public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		log.warn("param : date = {}", date);
		return null;
	}

}
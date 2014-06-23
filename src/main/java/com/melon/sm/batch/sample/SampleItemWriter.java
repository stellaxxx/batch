package com.melon.sm.batch.sample;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.melon.sm.batch.common.annotation.BatchWriter;

@BatchWriter
@Slf4j
public class SampleItemWriter implements ItemWriter<Person> {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public void write(List<? extends Person> paramList) throws Exception {
		for (Person p : paramList) {
			log.info("writer : {}", p);
			personRepository.save(p);
		}
	}

}

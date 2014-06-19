package com.melon.sm.batch.sample;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.melon.sm.batch.common.annotation.BatchWriter;

@BatchWriter
public class SampleItemWriter implements ItemWriter<Person> {

	@Override
	public void write(List<? extends Person> paramList) throws Exception {
		// TODO Auto-generated method stub

	}

}

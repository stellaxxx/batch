package com.melon.sm.batch.sample;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;

//@Component
// @StepScope
@Slf4j
public class SamplePartitioner implements Partitioner {

	@Override
	public Map<String, ExecutionContext> partition(int gripSize) {

		Map<String, ExecutionContext> result = Maps.newHashMap();

		int range = 5;
		for (int i = 0; i < gripSize; i++) {
			String name = "Thread_" + i;
			int start = (range * i);
			int end = (range * i) + range - 1;
			ExecutionContext executionContext = new ExecutionContext();

			executionContext.putString("name", name);
			executionContext.putInt("start", start);
			executionContext.putInt("end", end);
			result.put("partition_" + i, executionContext);

			log.info("thread name [{}] : start = {}  / end = {} ", name, start, end);
		}

		return result;

	}
}

package com.melon.sm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MelonApplication.class)
public class MelonApplicationTest {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Test
	public void test_contextLoads() {
		log.debug("load");
	}

}

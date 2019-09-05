package com.example.spel;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @project: spel-demo
 * @packageName: com.example.spel
 * @author: Administrator
 * @date: 2019/9/5 10:54
 * @description：TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemPropertiesTest {

	@Autowired
	private Message message;

	@Test
	public void readSystemProperties() {
		String lang = message.getLang();
		Assert.assertNotNull(lang);
		Assert.assertEquals("zh", lang);
	}
}

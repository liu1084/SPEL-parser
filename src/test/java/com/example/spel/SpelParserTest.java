package com.example.spel;

import com.example.spel.config.XmlConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @project: spel-demo
 * @packageName: com.example.spel
 * @author: Administrator
 * @date: 2019/9/5 11:13
 * @description：https://blog.csdn.net/ya_1249463314/article/details/68484422
 */

@Import(value = {XmlConfig.class})
public class SpelParserTest {
	private ExpressionParser expressionParser;

	@Before
	public void init() {
		expressionParser = new SpelExpressionParser();
	}

	@Test
	public void testParser() {
		//使用解析器输出纯文本
		Expression expression = expressionParser.parseExpression("'systemProperties'");
		String result = expression.getValue(String.class);
		Assert.assertNotNull(result);
	}

	@Test
	public void testParserWithXML() {
		//使用解析器解析xml中的el表达式
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:app.xml");
		Message myMessage = (Message) context.getBean("message");
		Assert.assertNotEquals(null, myMessage.getLang());
	}

	@Test
	public void testParserWithConstructMethod() {
		Expression expression = expressionParser.parseExpression("new Double(3.1415926)");
		double pi = expression.getValue(Double.class);
		double epsilon = 0.001;
		Assert.assertEquals(3.142, pi, epsilon);
	}

	@Test
	public void testParserWithStaticMethod() {
		Expression expression = expressionParser.parseExpression("T(java.lang.Math).abs(-1)");
		double result = expression.getValue(Double.class);
		Assert.assertEquals(1, result, 0e-15);
	}
}

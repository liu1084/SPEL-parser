package com.example.spel.config;

import com.example.spel.Message;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @project: spel-demo
 * @packageName: com.example.spel.config
 * @author: Administrator
 * @date: 2019/9/5 11:32
 * @description：TODO
 */
@ImportResource({"classpath:app.xml"})
@Getter
@Setter
@Configuration
public class XmlConfig {
	@Bean(name = "message2")
	public Message getMessage() {
		Message message = new Message();
		message.setLang("zh_TW");
		return message;
	}
}
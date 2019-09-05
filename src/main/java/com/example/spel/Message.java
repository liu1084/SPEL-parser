package com.example.spel;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @project: spel-demo
 * @packageName: com.example.spel
 * @author: Administrator
 * @date: 2019/9/5 10:52
 * @description：TODO
 */

@Component
@Getter
@Setter
public class Message {
	@Value("#{systemProperties['user.language']}")
	private String lang;
}

package com.controller;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class TestMail {
	public static void main(String[] args) {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setUsername("547122965@qq.com");
		sender.setPassword("llc772332");
		sender.setDefaultEncoding("utf-8");
		sender.setHost("smtp.qq.com");
		sender.setPort(587);
	
		SimpleMailMessage msg =new SimpleMailMessage();
		msg.setFrom("547122965@qq.com");
		msg.setTo("157449192@qq.com");
		msg.setText("你好 这是一份测试邮件");
		msg.setSubject("阿克斯科技有限公司");
		msg.setCc("547122965@qq.com");
		sender.send(msg);
	}
}

package com.controller;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class TestMail {
	public static void main(String[] args) {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setUsername("dingmm@vvaccess.com");
		sender.setPassword("7876574dmm!");
		sender.setDefaultEncoding("utf-8");
		sender.setHost("smtp.exmail.qq.com");
		sender.setPort(465);
		Properties pro = new Properties();
		pro.setProperty("mail.smtp.timeout", "10000");
		sender.setJavaMailProperties(pro);
		SimpleMailMessage msg =new SimpleMailMessage();
		msg.setFrom("dingmm@vvaccess.com");
		msg.setTo("547122965@qq.com");
		msg.setText("你好 这是一份测试邮件");
		msg.setSubject("阿克斯科技有限公司");
		msg.setCc("157449192@qq.com");
		
		sender.send(msg);
	}
}

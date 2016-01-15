package com.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailUtil {
  @Autowired
  private JavaMailSenderImpl sender;
  private String senderAddress;

  public void sendSimpleMessage(String to, String subject, String text) {
    SimpleMailMessage mail = new SimpleMailMessage();
    mail.setFrom(senderAddress);
    mail.setTo(to);
//    mail.setCc();
    mail.setSubject(subject);
    mail.setText(text);
    sender.send(mail);
  }

  public JavaMailSenderImpl getSender() {
    return sender;
  }

  public void setSender(JavaMailSenderImpl sender) {
    this.sender = sender;
  }

  public String getSenderAddress() {
    return senderAddress;
  }

  public void setSenderAddress(String senderAddress) {
    this.senderAddress = senderAddress;
  }
  
  
  
}

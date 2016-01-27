package com.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailUtil {
	@Autowired
	private JavaMailSenderImpl sender;
	private String senderAddress;
	private String attachmentFile;

	public void sendSimpleMessage(String to, String subject, String text,String path) {
		try {
			MimeMessage mail = new MimeMessage(sender.getSession());
			InternetAddress from = new InternetAddress(senderAddress);
			InternetAddress toAddr = new InternetAddress(to);
			mail.setRecipient(Message.RecipientType.TO, toAddr);
			mail.setFrom(from);
			mail.setSubject(subject);

			Multipart multipart = new MimeMultipart();
			BodyPart content = new MimeBodyPart();
			content.setContent(text, "text/html;charset=UTF-8");
			multipart.addBodyPart(content);
			
			File attachment = new File(path+attachmentFile);
			// ��Ӹ���������
			if (attachment != null) {
				BodyPart attachmentBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(attachment);
				attachmentBodyPart.setDataHandler(new DataHandler(source));
				// ���������Ľ���ļ�������ķ�������ʵ��MimeUtility.encodeWord�Ϳ��Ժܷ���ĸ㶨
				// �������Ҫ��ͨ�������Base64�����ת�����Ա�֤������ĸ����������ڷ���ʱ����������
				// sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
				// messageBodyPart.setFileName("=?GBK?B?" +
				// enc.encode(attachment.getName().getBytes()) + "?=");

				// MimeUtility.encodeWord���Ա����ļ�������
				attachmentBodyPart.setFileName(MimeUtility.encodeWord(attachment.getName()));
				multipart.addBodyPart(attachmentBodyPart);
			}
			mail.setContent(multipart);
			sender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public String getAttachmentFile() {
		return attachmentFile;
	}

	public void setAttachmentFile(String attachmentFile) {
		this.attachmentFile = attachmentFile;
	}

}

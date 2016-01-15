package com.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.domain.register.RegisterInfo;

import com.service.RegsiterInfoService;
import com.utils.MailUtil;
import com.utils.RegisterMailTemplate;

@Controller
public class RegisterCtrl {

	@Autowired
	private RegsiterInfoService registerService;
	@Autowired
	private MailUtil mailUtil;
	@Autowired
	private RegisterMailTemplate mailTemplate;
	
	private Logger logger = LoggerFactory.getLogger(RegisterCtrl.class);
	@RequestMapping("/regist")
	public String register(RegisterInfo info, @RequestParam("pic") MultipartFile[] images, HttpServletRequest request,
			HttpSession session) {
		if (info.canUsed()) {
			info.setPass(false);

			try {
				
				File file = new File(request.getServletContext().getRealPath("/") + "image");
				if (file.exists() == false) {
					file.mkdir();
				}
				
				for (MultipartFile pic1 : images) {
					if (!pic1.isEmpty()) {
						File image = new File(file.getAbsolutePath() + File.separator + info.getName() + "_"+ info.getOrg() + "." + getExt(pic1.getOriginalFilename()));
						pic1.transferTo(image);
						info.setPicLoc(image.getAbsolutePath());
					}
				}
				
				registerService.saveRegister(info);
//				System.out.println(mailTemplate.getMail(info.getName(),info.getProInstroduction()));
				mailUtil.sendSimpleMessage(info.getEmail(), mailTemplate.getTitle(), mailTemplate.getMail(info.getName(),info.getProInstroduction()));
				session.setAttribute("result", "success");
				return "redirect:result";

			} catch (MailSendException e) {
				logger.error("can  not send email to "+info.getEmail()+",user name:"+info.getName());
				return "redirect:result";
			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:fail";
			}
			
		} else {
			session.setAttribute("result", "fail");
			return "redirect:fail";
		}

	}

	@RequestMapping("/registerInfo")
	public String personalInfo() {
		return "registerInfo";
	}

	@RequestMapping("/fail")
	public String fail() {
		return "fail";
	}

	private String getExt(String originalFilename) {
		String temp = originalFilename.substring(originalFilename.lastIndexOf(File.separator) + 1);
		return temp.substring(temp.lastIndexOf(".") + 1);
	}

	@RequestMapping("/result")
	public String result() {
		return "result";
	}
}

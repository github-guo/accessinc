package com.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.domain.register.RegisterInfo;

import com.service.RegsiterInfoService;

@Controller
public class RegisterCtrl {
	
	@Autowired
	private RegsiterInfoService registerService;

	@RequestMapping("/regist")
	public String register(RegisterInfo info,@RequestParam("pic")MultipartFile images,HttpServletRequest request,HttpSession session) {
		if(info.canUsed()){
			info.setPass(false);
			
			try {
				File file = new File(request.getServletContext().getRealPath("/")+"image");
				if(file.exists()==false){
					file.mkdir();
				}
				if(!images.isEmpty()){
					File image = new File(file.getAbsolutePath()+File.separator+info.getName()+"_"+info.getOrg()+"."+getExt(images.getOriginalFilename()));
					images.transferTo(image);
					info.setPicLoc(image.getAbsolutePath());
				}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			registerService.saveRegister(info);
			session.setAttribute("result", "success");
			return "redirect:result";
		}else{
			session.setAttribute("result", "fail");
			return "redirect:fail";
		}
		
	}
	
	@RequestMapping("/registerInfo")
	public String personalInfo(){
		return "registerInfo";
	}
	@RequestMapping("/fail")
	public String fail(){
		return "fail";
	}
	
	
	private String getExt(String originalFilename) {
		String temp= originalFilename.substring(originalFilename.lastIndexOf(File.separator)+1);
		return temp.substring(temp.lastIndexOf(".")+1);
	}
	@RequestMapping("/result")
	public String result(){
		return "result";
	}
}

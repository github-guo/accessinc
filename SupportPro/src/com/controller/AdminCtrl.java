package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.domain.register.RegisterInfo;
import com.service.RegsiterInfoService;


@Controller
public class AdminCtrl {
	@Autowired
	private RegsiterInfoService registerService;
	@RequestMapping("/admin")
	public String admin(){
		return "admin";
	}
	
	@ResponseBody
	@RequestMapping("/admin/getAllPro")
	public List<RegisterInfo> getAllPro(){
		return registerService.findAll();
	}
	
	
	@ResponseBody
	@RequestMapping("/admin/getWaiting")
	public List<RegisterInfo> getWaiting(){
		return registerService.findWaiting();
	}
	
	@RequestMapping("/admin/getPassed")
	@ResponseBody
	public List<RegisterInfo> getPassed(){
		return registerService.findPassed();
	}
}

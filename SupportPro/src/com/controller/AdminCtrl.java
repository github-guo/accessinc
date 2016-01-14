package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.domain.register.RegisterInfo;
import com.domain.register.User;
import com.service.RegsiterInfoService;
import com.service.UserService;

@Controller
public class AdminCtrl {
	@Autowired
	private RegsiterInfoService registerService;
	@Autowired
	private UserService userService;

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}

	@ResponseBody
	@RequestMapping("/admin/getAllPro")
	public List<RegisterInfo> getAllPro() {
		return registerService.findAll();
	}

	@ResponseBody
	@RequestMapping("/admin/getWaiting")
	public List<RegisterInfo> getWaiting() {
		return registerService.findWaiting();
	}

	@RequestMapping("/admin/getPassed")
	@ResponseBody
	public List<RegisterInfo> getPassed() {
		return registerService.findPassed();
	}

	@ResponseBody
	@RequestMapping("/admin/getDetail/{id}")
	public RegisterInfo getDetail(@PathVariable("id") Long id) {
		System.out.println(id);
		return registerService.findByID(id);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getloginPage() {
		return "login";
	}

	@ResponseBody
	@RequestMapping(value = "/loginAs", method = RequestMethod.POST)
	public Map<String, String> loginByUserNameAndPassword(@RequestParam("name")String name,@RequestParam("password") String password,HttpSession session) {
		Map<String, String> respMap = new HashMap<>();
		User user = userService.login(name, password);
		if (user == null) {
			respMap.put("tips", "fail");
		} else {
			respMap.put("tips", "success");
			session.setAttribute("admin", user.getName());
		}
		return respMap;
	}
}

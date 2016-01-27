package com.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import com.utils.AdminJudgNoticeMailTemplate;
import com.utils.MailUtil;

@Controller
public class AdminCtrl {
	@Autowired
	private RegsiterInfoService registerService;
	@Autowired
	private UserService userService;
	@Autowired
	private MailUtil mailUtil;
	@Autowired
	private AdminJudgNoticeMailTemplate template;
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
	
	@ResponseBody
	@RequestMapping("/updateRegInfo")
	public Map<String, String> updateRegisterInfo(@RequestParam("id") Long id,@RequestParam("pass") String result,HttpServletRequest request ){
		Map<String, String> paraMap=new HashMap<>();
		String basicpath=request.getSession().getServletContext().getRealPath("/");
		System.out.println(basicpath);
		String path=basicpath+File.separator+"config"+File.separator+"template"+File.separator;
		RegisterInfo info = new RegisterInfo();
		boolean passed;
		if("passed".equals(result)){
			passed=registerService.setResult(id,true,info);
		}else{
			passed=registerService.setResult(id,false,info);
			
		}
		
		mailUtil.sendSimpleMessage(info.getEmail(), template.getTitle(), template.getMail(info.getName(),info.getProInstroduction(),(info.isPass()==true?"通过审核":"被否决")),path);
		
		System.out.println(template.getMail());
		
		if(passed){
			paraMap.put("result","success");
		}else {
			paraMap.put("result", "fail");
		}
		paraMap.put("selected", result);
		return paraMap;
	}
}

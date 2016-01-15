package com.controller.wechat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.utils.SignUtil;

@Controller
public class CoreController {

	@ResponseBody
	@RequestMapping("/wechat/verify")
	public String doVerfiy(String signature,String timestamp ,String nonce,String echostr){
		
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			return echostr;
		}
		return "";
	}
}

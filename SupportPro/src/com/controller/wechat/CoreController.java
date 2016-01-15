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
		
		// ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			return echostr;
		}
		return "";
	}
}

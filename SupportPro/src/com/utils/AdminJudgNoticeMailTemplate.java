package com.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class AdminJudgNoticeMailTemplate {

	private static ResourceLoader resourceLoader = new DefaultResourceLoader();
	private String templatePath;
	private String encode;
	private String title;

	public String getMail(String... args) {
		try {
			Resource resource = resourceLoader.getResource(templatePath);
			InputStream is = resource.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, encode));
			StringBuffer sb = new StringBuffer();
			String str = "";
			while ((str = reader.readLine()) != null) {
				sb.append(str).append("\n");
			}
			String result = sb.toString();

			for (int i = 0; i < args.length; i++) {
				result = result.replaceAll("\\{" + i + "\\}", args[i]);
			}

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

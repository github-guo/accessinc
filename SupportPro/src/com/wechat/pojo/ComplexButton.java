package com.wechat.pojo;
/**
 * 一级菜单按钮  即微信 3*5  菜单中的3 菜单
 * @author DINGFR
 *
 */
public class ComplexButton extends Button {
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
}
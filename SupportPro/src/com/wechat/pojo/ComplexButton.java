package com.wechat.pojo;
/**
 * һ���˵���ť  ��΢�� 3*5  �˵��е�3 �˵�
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
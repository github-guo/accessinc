package com.vo;

public class CheckedResult {
	private boolean result;
	private Object returnObject;
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public Object getReturnObject() {
		return returnObject;
	}
	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}
	
	
	public CheckedResult() {
		
	}
	public CheckedResult(boolean result, Object returnObject) {
		this.result = result;
		this.returnObject = returnObject;
	}
	
}

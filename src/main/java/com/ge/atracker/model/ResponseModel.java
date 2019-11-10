package com.ge.atracker.model;

public class ResponseModel {
	private String status;
	private String code;
	private String responseDetail;
	private Object data;

	public String getStatus() {
		return status;
	}

	public String getcode() {
		return code;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getResponseDetail() {
		return responseDetail;
	}

	public void setResponseDetail(String respoonseDetail) {
		this.responseDetail = respoonseDetail;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
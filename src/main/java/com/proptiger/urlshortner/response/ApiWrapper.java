package com.proptiger.urlshortner.response;


public class ApiWrapper {
	private String StatusCode;
	private Object object;
	ApiWrapper(){
		this.StatusCode = "2xx";
		this.object = null;
	}
	public ApiWrapper(Object o){
		this.object = o;
		this.StatusCode = "2xx";
	}
	public ApiWrapper(Object o, String statusCode){
		this.object = o;
		this.StatusCode = statusCode;
	}
	public String getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
}

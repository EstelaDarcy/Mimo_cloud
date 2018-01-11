package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;

public class Error
{
	private String msg;
	private String code;
		
	public Error(String code, String msg) { //constructor
		super();
		
		this.code = code;
		this.msg = msg;
	}
	
	public JsonNode toJson() {
		return Json.toJson(this);
	}
	
	public String getMsg() {
		return msg;
	}	
	public String getCode() {
		return code;
	}	
}

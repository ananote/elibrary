package com.impetus.elibrary.controller.json;

import org.codehaus.jackson.annotate.JsonProperty;

public class JSONResponse<T> {

	private String Result;

	private T Records;

	private String Message;

	public JSONResponse() {
	}

	public JSONResponse(String Result) {
		this.Result = Result;
	}

	public JSONResponse(String Result, T Records) {
		this.Result = Result;
		this.Records = Records;
	}

	public JSONResponse(String Result, String Message) {
		this.Result = Result;
		this.Message = Message;
	}

	@JsonProperty("Result")
	public String getResult() {
		return Result;
	}

	public void setResult(String Result) {
		this.Result = Result;
	}

	@JsonProperty("Record")
	public T getRecords() {
		return Records;
	}

	public void setRecords(T Records) {
		this.Records = Records;
	}

	@JsonProperty("Message")
	public String getMessage() {
		return Message;
	}

	public void setMessage(String Message) {
		this.Message = Message;
	}

}

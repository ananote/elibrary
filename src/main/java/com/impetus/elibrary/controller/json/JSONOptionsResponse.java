package com.impetus.elibrary.controller.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class JSONOptionsResponse {

	private String Result;

	private List<JSONOptionsBean> Options;

	private String Message;

	public JSONOptionsResponse(String Result, List<JSONOptionsBean> Options) {
		this.Result = Result;
		this.Options = Options;
	}

	public JSONOptionsResponse(String Result, String Message) {
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

	@JsonProperty("Options")
	public List<JSONOptionsBean> getOptions() {
		return Options;
	}

	public void setOptions(List<JSONOptionsBean> Options) {
		this.Options = Options;
	}

	@JsonProperty("Message")
	public String getMessage() {
		return Message;
	}

	public void setMessage(String Message) {
		this.Message = Message;
	}
}

package com.impetus.elibrary.controller.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class JSONListResponse<T> {

	private String Result;

	private List<T> Records;

	private int TotalRecordCount;

	private String Message;

	public JSONListResponse(String Result, List<T> Records, int TotalRecordCount) {
		this.Result = Result;
		this.Records = Records;
		this.TotalRecordCount = TotalRecordCount;
	}

	public JSONListResponse(String Result, String Message) {
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

	@JsonProperty("Records")
	public List<T> getRecords() {
		return Records;
	}

	public void setRecords(List<T> Records) {
		this.Records = Records;
	}

	@JsonProperty("TotalRecordCount")
	public int getTotalRecordCount() {
		return TotalRecordCount;
	}

	public void setTotalRecordCount(int TotalRecordCount) {
		this.TotalRecordCount = TotalRecordCount;
	}

	@JsonProperty("Message")
	public String getMessage() {
		return Message;
	}

	public void setMessage(String Message) {
		this.Message = Message;
	}

}

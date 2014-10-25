package com.impetus.elibrary.controller.json;

import org.codehaus.jackson.annotate.JsonProperty;

public class JSONOptionsBean {

	private String DisplayText;

	private String Value;

	public JSONOptionsBean(String DisplayText, String Value) {
		this.DisplayText = DisplayText;
		this.Value = Value;
	}

	@JsonProperty("DisplayText")
	public String getDisplayText() {
		return DisplayText;
	}

	public void setDisplayText(String DisplayText) {
		this.DisplayText = DisplayText;
	}

	@JsonProperty("Value")
	public String getValue() {
		return Value;
	}

	public void setValue(String Value) {
		this.Value = Value;
	}
}

package com.parkinglot.service.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "registrationNumber", "color", "type" })
public class ParkRequest {
	@JsonProperty("registrationNumber")
	private String registrationNumber;
	@JsonProperty("color")
	private String color;
	@JsonProperty("type")
	private String type;

	@JsonProperty("registrationNumber")
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	@JsonProperty("registrationNumber")
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	@JsonProperty("color")
	public String getColor() {
		return color;
	}

	@JsonProperty("color")
	public void setColor(String color) {
		this.color = color;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

}
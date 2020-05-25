package com.parkinglot.service.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "level", "slot" })
public class ParkingRequest {

	@JsonProperty("level")
	private String level;
	@JsonProperty("slot")
	private Slot slot;

	@JsonProperty("level")
	public String getLevel() {
		return level;
	}

	@JsonProperty("level")
	public void setLevel(String level) {
		this.level = level;
	}

	@JsonProperty("slot")
	public Slot getSlot() {
		return slot;
	}

	@JsonProperty("slot")
	public void setSlot(Slot slot) {
		this.slot = slot;
	}

}
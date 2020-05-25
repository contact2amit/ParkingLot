package com.parkinglot.service.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Bike", "Truck", "ElectricCar", "Car" })
public class Slot {

	@JsonProperty("Bike")
	private String bike;
	@JsonProperty("Truck")
	private String truck;
	@JsonProperty("ElectricCar")
	private String electricCar;
	@JsonProperty("Car")
	private String car;

	@JsonProperty("Bike")
	public String getBike() {
		return bike;
	}

	@JsonProperty("Bike")
	public void setBike(String bike) {
		this.bike = bike;
	}

	@JsonProperty("Truck")
	public String getTruck() {
		return truck;
	}

	@JsonProperty("Truck")
	public void setTruck(String truck) {
		this.truck = truck;
	}

	@JsonProperty("ElectricCar")
	public String getElectricCar() {
		return electricCar;
	}

	@JsonProperty("ElectricCar")
	public void setElectricCar(String electricCar) {
		this.electricCar = electricCar;
	}

	@JsonProperty("Car")
	public String getCar() {
		return car;
	}

	@JsonProperty("Car")
	public void setCar(String car) {
		this.car = car;
	}

}
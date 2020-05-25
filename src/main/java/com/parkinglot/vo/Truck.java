package com.parkinglot.vo;

import com.parkinglot.types.Colour;
import com.parkinglot.types.VehicleType;

public class Truck extends Vehicle {

	public Truck(String registrationNumber, Colour color) {
		super(registrationNumber, color);
	}
	
	public Truck(String registrationNumber, Colour color, VehicleType type) {
		super(registrationNumber, color, type);
	}
	
}

package com.parkinglot.vo;

import com.parkinglot.types.Colour;
import com.parkinglot.types.VehicleType;

public class Car extends Vehicle {

	public Car(String registrationNumber, Colour color) {
		super(registrationNumber, color);
	}
	
	public Car(String registrationNumber, Colour color, VehicleType type) {
		super(registrationNumber, color, type);
	}
	
}

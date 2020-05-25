package com.parkinglot.vo;

import com.parkinglot.types.Colour;
import com.parkinglot.types.VehicleType;

public class ElectricCar extends Vehicle {

	public ElectricCar(String registrationNumber, Colour color) {
		super(registrationNumber, color);
	}
	
	public ElectricCar(String registrationNumber, Colour color, VehicleType type) {
		super(registrationNumber, color, type);
	}
	
}

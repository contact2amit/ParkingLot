package com.parkinglot.vo;

import com.parkinglot.types.Colour;
import com.parkinglot.types.VehicleType;

public abstract class Vehicle {
	private String registrationNumber;
	private Colour color;
	VehicleType type;
	
	public Vehicle(String registrationNumber, Colour color) {
		super();
		this.registrationNumber = registrationNumber;
		this.color = color;
	}
	
	public Vehicle(String registrationNumber, Colour color, VehicleType type) {
		super();
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.type = type;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Colour getColor() {
		return color;
	}

	public void setColor(Colour color) {
		this.color = color;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((registrationNumber == null) ? 0 : registrationNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (color != other.color)
			return false;
		if (registrationNumber == null) {
			if (other.registrationNumber != null)
				return false;
		} else if (!registrationNumber.equals(other.registrationNumber))
			return false;
		return true;
	}



	
	
}

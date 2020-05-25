package com.parkinglot.vo;

import java.util.Date;

public class Ticket {
	Date parkTime;
	Vehicle vehicle;
	ParkingSlot slot;

	public Ticket(Vehicle vehicle, ParkingSlot slot) {
		super();
		this.parkTime = new Date();
		this.vehicle = vehicle;
		this.slot = slot;
	}
	public Ticket() {
		super();
		this.parkTime = new Date();
	}
	public Date getParkTime() {
		return parkTime;
	}

	public void setParkTime(Date parkTime) {
		this.parkTime = parkTime;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSlot getSlot() {
		return slot;
	}

	public void setSlot(ParkingSlot slot) {
		this.slot = slot;
	}

}

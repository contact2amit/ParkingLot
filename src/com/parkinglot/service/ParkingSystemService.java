package com.parkinglot.service;

import java.util.List;

import com.parkinglot.Colour;
import com.parkinglot.vo.Car;
import com.parkinglot.vo.ParkingSlot;

public interface ParkingSystemService {

	public boolean createParkingLot(int capacity);
	public ParkingSlot asignParking(Car car);
	public boolean vacateParkingSlot(ParkingSlot id);
	
	void addLevel();
	void displayAvailability();
	void displayAvailability(int level);
	
	//Regulation
	public List<Car> getCarsByColor(Colour clr);
	public ParkingSlot getParkingSlotByRegistration(String registrationNumber);
	public List<ParkingSlot> getSlotByCarColor(Colour clr);
	public ParkingSlot getSlotById(int parseInt);
	public List<Car> getAllCars();
}

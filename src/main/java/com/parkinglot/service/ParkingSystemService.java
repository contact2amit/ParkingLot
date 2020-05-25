package com.parkinglot.service;

import java.util.List;
import java.util.Map;

import com.parkinglot.service.request.ParkingRequest;
import com.parkinglot.types.Colour;
import com.parkinglot.types.SlotType;
import com.parkinglot.vo.Car;
import com.parkinglot.vo.ParkingSlot;
import com.parkinglot.vo.Vehicle;

public interface ParkingSystemService {

	public boolean createParkingLot(List<ParkingRequest> parkingRequest);
	public ParkingSlot asignParking(Vehicle vehicle);
	public boolean vacateParkingSlot(ParkingSlot id);
	
	void addLevel();
	Map<String, Map<SlotType, Integer>> displayAvailability();
	Map<SlotType, Integer> displayAvailability(String levelId);
	
	//Regulation
	public List<Vehicle> getCarsByColor(Colour clr);
	public ParkingSlot getParkingSlotByRegistration(String registrationNumber);
	public List<ParkingSlot> getSlotByCarColor(Colour clr);
	//public ParkingSlot getSlotById(int parseInt);
	public List<Vehicle> getAllCars();
}

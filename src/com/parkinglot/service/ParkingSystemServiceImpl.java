package com.parkinglot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.parkinglot.Colour;
import com.parkinglot.vo.Car;
import com.parkinglot.vo.ParkingLot;
import com.parkinglot.vo.ParkingSlot;

public class ParkingSystemServiceImpl implements ParkingSystemService{
	private ParkingLot parkingLot = null;
	Map<Colour, List<Car>> carsByColorMap = new HashMap<Colour, List<Car>>();
	Map<String, ParkingSlot> parkingSlotByRegistrationMap = new HashMap<String, ParkingSlot>();
	Map<Colour, List<ParkingSlot>> slotByCarColorMap = new HashMap<Colour, List<ParkingSlot>>();
	Map<ParkingSlot, Car> carBySlotMap = new HashMap<ParkingSlot, Car>();
	
	@Override
	public List<Car> getCarsByColor(Colour colour) {
		return carsByColorMap.getOrDefault(colour, null);
	}

	@Override
	public ParkingSlot getParkingSlotByRegistration(String registration) {
		return parkingSlotByRegistrationMap.getOrDefault(registration, null);
	}

	@Override
	public List<ParkingSlot> getSlotByCarColor(Colour colour) {
		// TODO Auto-generated method stub
		return slotByCarColorMap.getOrDefault(colour, null);
	}

	@Override
	public boolean createParkingLot(int capacity) {
		if(parkingLot == null) {
			parkingLot = new ParkingLot(capacity);
			return true;
		}
		return false;
	}

	@Override
	public ParkingSlot asignParking(Car car) {
		
		ParkingSlot slot = parkingLot.getAvailableSlot();
		if(slot==null) {
			return slot;
		}
		
		if(!carsByColorMap.containsKey(car.getColor())) {
			List<Car> cars = new ArrayList<Car>();
			carsByColorMap.put(car.getColor(), cars);
		}

		if(!slotByCarColorMap.containsKey(car.getColor())) {
			List<ParkingSlot> slotList = new ArrayList<ParkingSlot>();
			slotByCarColorMap.put(car.getColor(), slotList);
		}
		carBySlotMap.put(slot, car);
		carsByColorMap.get(car.getColor()).add(car);
		parkingSlotByRegistrationMap.put(car.getRegistrationNumber(), slot);
		slotByCarColorMap.get(car.getColor()).add(slot);
		slot.setOccupied(true);
		return slot;
	}

	@Override
	public boolean vacateParkingSlot(ParkingSlot slot) {
		
		Car car = carBySlotMap.get(slot);
		if(car==null) {
			return false;
		}
		carBySlotMap.remove(slot);
		carsByColorMap.get(car.getColor()).remove(car);
		parkingSlotByRegistrationMap.remove(car.getRegistrationNumber());
		slotByCarColorMap.get(car.getColor()).remove(slot);
		parkingLot.freeSlot(slot);
		slot.setOccupied(false);
		return true;
	}

	@Override
	public ParkingSlot getSlotById(int slotId) {
		return parkingLot.getSlotByIdMap().get(slotId);
	}

	@Override
	public List<Car> getAllCars() {
		List<Car> cars = new ArrayList<Car>(); 
		for(Object c: carBySlotMap.values().toArray()) {
			cars.add((Car) c);
		}
		return cars;
	}
	
	
	
	

}

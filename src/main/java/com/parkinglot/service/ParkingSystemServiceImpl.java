package com.parkinglot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parkinglot.service.request.ParkingRequest;
import com.parkinglot.types.Colour;
import com.parkinglot.types.SlotType;
import com.parkinglot.vo.Car;
import com.parkinglot.vo.ParkingLot;
import com.parkinglot.vo.ParkingSlot;
import com.parkinglot.vo.Vehicle;

@Component
public class ParkingSystemServiceImpl implements ParkingSystemService{
	@Autowired
	private ParkingLot parkingLot;
	Map<Colour, List<Vehicle>> carsByColorMap = new HashMap<Colour, List<Vehicle>>();
	Map<String, ParkingSlot> parkingSlotByRegistrationMap = new HashMap<String, ParkingSlot>();
	Map<Colour, List<ParkingSlot>> slotByCarColorMap = new HashMap<Colour, List<ParkingSlot>>();
	Map<ParkingSlot, Vehicle> carBySlotMap = new HashMap<ParkingSlot, Vehicle>();
	
	@Override
	public List<Vehicle> getCarsByColor(Colour colour) {
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
	public ParkingSlot asignParking(Vehicle vehicle) {
		
		ParkingSlot slot = parkingLot.getAvailableSlot(SlotType.BIKE_SLOT);
		if(slot==null) {
			return slot;
		}
		
		if(!carsByColorMap.containsKey(vehicle.getColor())) {
			List<Vehicle> cars = new ArrayList<Vehicle>();
			carsByColorMap.put(vehicle.getColor(), cars);
		}

		if(!slotByCarColorMap.containsKey(vehicle.getColor())) {
			List<ParkingSlot> slotList = new ArrayList<ParkingSlot>();
			slotByCarColorMap.put(vehicle.getColor(), slotList);
		}
		carBySlotMap.put(slot, vehicle);
		carsByColorMap.get(vehicle.getColor()).add(vehicle);
		parkingSlotByRegistrationMap.put(vehicle.getRegistrationNumber(), slot);
		slotByCarColorMap.get(vehicle.getColor()).add(slot);
		slot.setOccupied(true);
		return slot;
	}

	@Override
	public boolean vacateParkingSlot(ParkingSlot slot) {
		
		Vehicle car = carBySlotMap.get(slot);
		if(car==null) {
			return false;
		}
		carBySlotMap.remove(slot);
		carsByColorMap.get(car.getColor()).remove(car);
		parkingSlotByRegistrationMap.remove(car.getRegistrationNumber());
		slotByCarColorMap.get(car.getColor()).remove(slot);
		parkingLot.releaseSlot(slot.getSlotid());
		slot.setOccupied(false);
		return true;
	}



	@Override
	public List<Vehicle> getAllCars() {
		List<Vehicle> cars = new ArrayList<Vehicle>(); 
		for(Object c: carBySlotMap.values().toArray()) {
			cars.add((Car) c);
		}
		return cars;
	}

	@Override
	public void addLevel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Map<SlotType, Integer>> displayAvailability() {
		return parkingLot.getLevelAvailability();
		
	}

	@Override
	public Map<SlotType, Integer> displayAvailability(String levelId) {
		return parkingLot.getLevelAvailability(levelId);
		
	}

	@Override
	public boolean createParkingLot(List<ParkingRequest> parkingRequest) {
		for(ParkingRequest req: parkingRequest) {
			parkingLot.createLevel(req.getLevel());
			int bikeSlot = (null != req.getSlot().getBike())?Integer.parseInt(req.getSlot().getBike()):0;
			int carSlot = (null != req.getSlot().getBike())?Integer.parseInt(req.getSlot().getBike()):0;
			int electricCarSlot = (null != req.getSlot().getBike())?Integer.parseInt(req.getSlot().getBike()):0;
			int truckSlot = (null != req.getSlot().getBike())?Integer.parseInt(req.getSlot().getBike()):0;
			
			parkingLot.addSlotOnLevel(req.getLevel(), SlotType.BIKE_SLOT, bikeSlot);
			parkingLot.addSlotOnLevel(req.getLevel(), SlotType.CAR_SLOT, carSlot);
			parkingLot.addSlotOnLevel(req.getLevel(), SlotType.ELECTRIC_CAR_SLOT, electricCarSlot);
			parkingLot.addSlotOnLevel(req.getLevel(), SlotType.TRUCK_SLOT, truckSlot);
		}
		return true;
	}
	
	
	
	

}

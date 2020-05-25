package com.parkinglot.vo;

import java.util.*;

import com.parkinglot.types.SlotType;

public class Level {
	String levelId;
	Map<SlotType, List<ParkingSlot>> availableSlots = new HashMap<SlotType, List<ParkingSlot>>();
	Map<SlotType, List<ParkingSlot>> reservedSlots  = new HashMap<SlotType, List<ParkingSlot>>();
	Map<SlotType, Integer> displayBoardMap = new HashMap<SlotType, Integer>();
	Map<String, ParkingSlot> slotById  = new HashMap<String, ParkingSlot>();
	
	public Level(String levelId) {
		this.levelId = levelId;
	}


	public boolean initFloorSlots(SlotType type, int count) {
		
		for(int i=0; i< count; i++) {
			String slotId = levelId+"-"+type+"-"+i;
			ParkingSlot slot = new ParkingSlot(slotId, type);
			if(!availableSlots.containsKey(type)) {
				availableSlots.put(type, new LinkedList<ParkingSlot>());
			}
			availableSlots.get(type).add(slot);
			displayBoardMap.put(type, displayBoardMap.getOrDefault(type, 0)+1);
			slotById.put(slotId, slot);
		}
		
		return true;
	}
	
	
	public ParkingSlot getSlot(SlotType type) {

		if (availableSlots.containsKey(type) && availableSlots.get(type).size() > 0) {
			return availableSlots.get(type).get(0);
		}
		return null;
	}

	public ParkingSlot reserveSlot(SlotType type) {
		ParkingSlot slot = null;
		if (availableSlots.containsKey(type) && availableSlots.get(type).size() > 0) {
			slot = availableSlots.get(type).remove(0);
		}
		if (slot != null) {
			if (!reservedSlots.containsKey(type)) {
				List<ParkingSlot> slotList = new LinkedList<ParkingSlot>();
				reservedSlots.put(type, slotList);
			}
			reservedSlots.get(type).add(slot);
			displayBoardMap.put(type, displayBoardMap.getOrDefault(type, 0)-1);
		}
		return slot;
	}
	
	
	public boolean releaseSlot(ParkingSlot slot) {
		//ParkingSlot slot = null;
		availableSlots.get(slot.type).add(slot);
		reservedSlots.get(slot.type).remove(slot);
		displayBoardMap.put(slot.type, displayBoardMap.get(slot.type)-1);
		slot.setOccupied(false);
		
		return true;
	}
	
	public Map<SlotType, Integer> getDisplayBoard(){
		return displayBoardMap;
	}
	
	public ParkingSlot getBikeSlot() {
		return getSlot(SlotType.BIKE_SLOT);
	}
	
	public ParkingSlot getCarSlot() {
		return getSlot(SlotType.CAR_SLOT);
	}
	public ParkingSlot getElectricCarSlot() {
		return getSlot(SlotType.ELECTRIC_CAR_SLOT);
		
	}
	
	public ParkingSlot getTruckSlot(){
		return getSlot(SlotType.TRUCK_SLOT);
		
	}


	public void releaseSlot(String slotId) {
		releaseSlot(slotById.get(slotId));
		
	}


	public String getLevelId() {
		return levelId;
	}


	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}
	
}

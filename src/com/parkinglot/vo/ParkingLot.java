package com.parkinglot.vo;

import java.util.*;;

public class ParkingLot {
	
	int maxSize = 0;
	List<ParkingSlot> slots;
	Map<Integer, ParkingSlot> slotByIdMap;
	
	public ParkingLot(int maxSize) {
		super();
		this.maxSize = maxSize;
		slots = new ArrayList<ParkingSlot>(maxSize);
		slotByIdMap = new HashMap<Integer, ParkingSlot>();
		for(int i=0; i< maxSize; i++) {
			ParkingSlot slot = new ParkingSlot(i+1);
			slot.setOccupied(false);
			slots.add(slot);
			slotByIdMap.put(i+1, slot);
		}
	}
	
	public ParkingLot(int maxSize, List<ParkingSlot> slots) {
		super();
		this.maxSize = maxSize;
		this.slots = slots;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public List<ParkingSlot> getSlots() {
		return slots;
	}

	public void setSlots(List<ParkingSlot> slots) {
		this.slots = slots;
	}


	public ParkingSlot getAvailableSlot() {
		
		ParkingSlot avlSlot = null;
		
		for(ParkingSlot slot: slots) {
			if(!slot.isOccupied) {
				avlSlot = slot;
				break;
			}
		}
		return avlSlot;
	}
	
	public void freeSlot(ParkingSlot slot) {
	slots.add(slot.slotNumber-1, slot);
	}

	public Map<Integer, ParkingSlot> getSlotByIdMap() {
		return slotByIdMap;
	}

	public void setSlotByIdMap(Map<Integer, ParkingSlot> slotByIdMap) {
		this.slotByIdMap = slotByIdMap;
	}
		
}

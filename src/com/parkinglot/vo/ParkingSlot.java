package com.parkinglot.vo;

import com.parkinglot.SlotType;

public class ParkingSlot {
	
	String slotid;
	boolean isOccupied;
	SlotType type;
	


	public ParkingSlot(String slotid, SlotType type) {
		super();
		this.slotid = slotid;
		this.type = type;
		this.isOccupied=false;
	}



	public String getSlotid() {
		return slotid;
	}



	public void setSlotid(String slotid) {
		this.slotid = slotid;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public SlotType getType() {
		return type;
	}

	public void setType(SlotType type) {
		this.type = type;
	}

	
}

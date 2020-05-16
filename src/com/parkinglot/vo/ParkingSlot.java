package com.parkinglot.vo;

public class ParkingSlot {
	
	int slotNumber;
	boolean isOccupied;
	
	public ParkingSlot(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	private void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
}

package com.parkinglot.vo;

import java.util.*;

import com.parkinglot.SlotType;;

public class ParkingLot {
	String parlingLotIt;
	int floorCount = 0;
	Address address;
	
	List<Level> parkinLevel;
	
	Map<Integer, ParkingSlot> slotByIdMap;
	


	public ParkingLot(int parkinLevelCount) {
		super();
		this.floorCount = parkinLevelCount;
		parkinLevel = new ArrayList<Level>(parkinLevelCount);
		for(int i=0; i< parkinLevelCount; i++) {
			Level parkingLvl = new Level(parlingLotIt+"-L-"+i);
			parkinLevel.add(parkingLvl);
		}
	}
	



	public ParkingSlot getAvailableSlot(SlotType type) {
		
		ParkingSlot avlSlot = null;
		
		for(Level level: parkinLevel) {
			if(level.getSlot(type)!=null) {
				avlSlot = level.getSlot(type);
				break;
			}
		}
		return avlSlot;
	}
	
	public void releaseSlot(String slotId) {
		String[] ids = slotId.split("-");
		Level level = parkinLevel.get(Integer.parseInt(ids[1]));
		level.releaseSlot(slotId);
	}

	public Map<Integer, ParkingSlot> getSlotByIdMap() {
		return slotByIdMap;
	}

	public void setSlotByIdMap(Map<Integer, ParkingSlot> slotByIdMap) {
		this.slotByIdMap = slotByIdMap;
	}
		
}

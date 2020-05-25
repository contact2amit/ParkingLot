package com.parkinglot.vo;

import java.util.*;

import org.springframework.stereotype.Component;

import com.parkinglot.types.SlotType;;

@Component
public class ParkingLot {
	String parlingLotIt;
	int floorCount = 0;
	Address address;
	
	List<Level> parkinLevel;
	Map<String, Level> levelByIdMap;
	


public ParkingLot() {
		super();
		parkinLevel = new ArrayList<Level>();
		levelByIdMap = new HashMap<String, Level>();
	}




public String createLevel(String levelId) {
	Level l = new Level(levelId);
	parkinLevel.add(l);
	levelByIdMap.put(levelId, l);
	return levelId;
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

	public void addSlotOnLevel(String levelId, SlotType type, int count) {
		
		Level l =  levelByIdMap.get(levelId);
		l.initFloorSlots(type, count);
	}




	public Map<SlotType, Integer> getLevelAvailability(String levelId) {
		return levelByIdMap.get(levelId).displayBoardMap;
		
	}
	
	public Map<String, Map<SlotType, Integer>> getLevelAvailability() {
		Map<String, Map<SlotType, Integer>> avlMap = new HashMap<String, Map<SlotType, Integer>>();
		for(Level l: parkinLevel){
			avlMap.put(l.levelId, l.getDisplayBoard());
		}
		return avlMap;
		
	}
}

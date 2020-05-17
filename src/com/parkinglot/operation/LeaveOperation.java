package com.parkinglot.operation;

import java.util.Map;

import com.parkinglot.ParkingCommand;
import com.parkinglot.service.ParkingSystemService;
import com.parkinglot.vo.ParkingSlot;

public class LeaveOperation implements ParkingLotOperation {
	 
    
    // constructors
     
    @Override
    public void execute(ParkingSystemService parkingSrevice, ParkingCommand cmd, Map extraParam) {
    	
    	Integer slotId = (Integer)extraParam.get("slotId");
    	ParkingSlot slot = parkingSrevice.getSlotById(slotId);
    	boolean isRemoved = parkingSrevice.vacateParkingSlot(slot);
		if(isRemoved) {
			System.out.println("Slot number "+ slotId +" is free");
		}else {
			System.out.println("Not found");
		}
    }
}
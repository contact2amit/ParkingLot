package com.parkinglot.operation;

import java.util.Map;

import com.parkinglot.InputParamEnum;
import com.parkinglot.OperationParam;
import com.parkinglot.ParkingCommand;
import com.parkinglot.service.ParkingSystemService;
import com.parkinglot.vo.ParkingSlot;

public class LeaveOperation implements ParkingLotOperation {
	 
    
    // constructors
     
    @Override
    public void execute(ParkingSystemService parkingSrevice, ParkingCommand cmd, OperationParam operationParam) {
    	
    	Integer slotId = (Integer)operationParam.getParam(InputParamEnum.SLOT_ID);
    	ParkingSlot slot = parkingSrevice.getSlotById(slotId);
    	boolean isRemoved = parkingSrevice.vacateParkingSlot(slot);
		if(isRemoved) {
			System.out.println("Slot number "+ slotId +" is free");
		}else {
			System.out.println("Not found");
		}
    }
}
package com.parkinglot.operation;

import java.util.Map;

import com.parkinglot.OperationParam;
import com.parkinglot.service.ParkingSystemService;
import com.parkinglot.types.InputParamEnum;
import com.parkinglot.types.ParkingCommand;
import com.parkinglot.vo.ParkingSlot;

public class LeaveOperation implements ParkingLotOperation {
	 
    
    // constructors
     
    @Override
    public void execute(ParkingSystemService parkingSrevice, ParkingCommand cmd, OperationParam operationParam) {
   /* 	
    	Integer slotId = (Integer)operationParam.getParam(InputParamEnum.SLOT_ID);
    	ParkingSlot slot = parkingSrevice.getSlotById(slotId);
    	boolean isRemoved = parkingSrevice.vacateParkingSlot(slot);
		if(isRemoved) {
			System.out.println("Slot number "+ slotId +" is free");
		}else {
			System.out.println("Not found");
		}*/
    }
}
package com.parkinglot.operation;

import java.util.Map;

import com.parkinglot.Colour;
import com.parkinglot.InputParamEnum;
import com.parkinglot.OperationParam;
import com.parkinglot.ParkingCommand;
import com.parkinglot.service.ParkingSystemService;
import com.parkinglot.vo.ParkingSlot;

public class SlotNumberForRegistrationNumberOperation implements ParkingLotOperation {
	 
    
    // constructors
     
    @Override
    public void execute(ParkingSystemService parkingSrevice, ParkingCommand cmd, OperationParam operationParam) {
    	String registrationNumber = (String)operationParam.getParam(InputParamEnum.REGISTRATION_NUMBER);

		ParkingSlot slot = parkingSrevice.getParkingSlotByRegistration(registrationNumber);
		if(slot==null) {
			System.out.println("Not found");
		}else {
			System.out.println(slot.getSlotNumber());
		}
    }
}
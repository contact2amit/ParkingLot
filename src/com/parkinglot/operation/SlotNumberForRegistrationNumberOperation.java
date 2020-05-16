package com.parkinglot.operation;

import java.util.Map;

import com.parkinglot.Colour;
import com.parkinglot.ParkingCommand;
import com.parkinglot.service.ParkingSystemService;
import com.parkinglot.vo.ParkingSlot;

public class SlotNumberForRegistrationNumberOperation implements ParkingLotOperation {
	 
    
    // constructors
     
    @Override
    public void execute(ParkingSystemService parkingSrevice, ParkingCommand cmd, Map extraParam) {
    	String registrationNumber = (String)extraParam.get("registrationNum");

		ParkingSlot slot = parkingSrevice.getParkingSlotByRegistration(registrationNumber);
		if(slot==null) {
			System.out.println("Not found");
		}else {
			System.out.println(slot.getSlotNumber());
		}
    }
}
package com.parkinglot.operation;

import java.util.List;
import java.util.Map;

import com.parkinglot.Colour;
import com.parkinglot.ParkingCommand;
import com.parkinglot.service.ParkingSystemService;
import com.parkinglot.vo.ParkingSlot;

public class SlotNumbersForCarsWithColourOperation implements ParkingLotOperation {
	 
    
    // constructors
     
    @Override
    public void execute(ParkingSystemService parkingSrevice, ParkingCommand cmd, Map extraParam) {
        
    	Colour clr = (Colour)extraParam.get("colour");
		

		List<ParkingSlot> slots = parkingSrevice.getSlotByCarColor(clr);
		for(ParkingSlot slot: slots) {
			System.out.print(slot.getSlotNumber()+", ");
		}
    }
}
package com.parkinglot.operation;

import java.util.List;
import java.util.Map;

import com.parkinglot.Colour;
import com.parkinglot.ParkingCommand;
import com.parkinglot.service.ParkingSystemService;
import com.parkinglot.vo.Car;
import com.parkinglot.vo.ParkingSlot;

public class SlotNumbersForCarsWithColourOperation implements ParkingLotOperation {
	 
    
    // constructors
     
    @Override
    public void execute(ParkingSystemService parkingSrevice, ParkingCommand cmd, Map extraParam) {
        
    	Colour clr = (Colour)extraParam.get("colour");
		

		List<ParkingSlot> slots = parkingSrevice.getSlotByCarColor(clr);

		StringBuilder status = new StringBuilder();
		
		for(ParkingSlot slot: slots) {
			status.append(slot.getSlotNumber()).append(", ");
		}
		System.out.println(status.delete(status.length()-2, status.length()-1));
    }
}
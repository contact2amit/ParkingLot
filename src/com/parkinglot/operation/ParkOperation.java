package com.parkinglot.operation;

import java.util.Map;

import com.parkinglot.ParkingCommand;
import com.parkinglot.service.ParkingSystemService;
import com.parkinglot.vo.Car;
import com.parkinglot.vo.ParkingSlot;

public class ParkOperation implements ParkingLotOperation {
	 
     
    // constructors
     
    @Override
    public void execute(ParkingSystemService parkingSrevice, ParkingCommand cmd, Map extraParam) {
        //return parkingSrevice.asignParking(car);
    	Car car = (Car)extraParam.get("car");
    	ParkingSlot slot = parkingSrevice.asignParking(car);
		if(slot==null) {
			System.out.println("Sorry, parking lot os full");
		}else {
			System.out.println("Alocated Slot number: "+slot.getSlotNumber());
		}
    }
}
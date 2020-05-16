package com.parkinglot.operation;

import java.util.List;
import java.util.Map;

import com.parkinglot.Colour;
import com.parkinglot.ParkingCommand;
import com.parkinglot.service.ParkingSystemService;
import com.parkinglot.vo.Car;

public class RegistrationNumbersForCarsWithColourOperation implements ParkingLotOperation {
	 
    
    // constructors
     
    @Override
    public void execute(ParkingSystemService parkingSrevice, ParkingCommand cmd, Map extraParam) {
        
    	Colour clr = (Colour)extraParam.get("colour");
		
		List<Car> cars = parkingSrevice.getCarsByColor(clr);
		for(Car car: cars) {
			System.out.print(car.getRegistrationNumber()+", ");
		}
    }
}
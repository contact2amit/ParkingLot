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

		StringBuilder status = new StringBuilder();
		for(Car car: cars) {
			status.append(car.getRegistrationNumber()).append(", ");
		}
		System.out.println(status.delete(status.length()-2, status.length()-1));
    }
}
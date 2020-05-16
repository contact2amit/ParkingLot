package com.parkinglot.operation;

import java.util.List;
import java.util.Map;

import com.parkinglot.ParkingCommand;
import com.parkinglot.service.ParkingSystemService;
import com.parkinglot.vo.Car;

public class StatusOperation implements ParkingLotOperation {
	 
    
    // constructors
     
    @Override
    public void execute(ParkingSystemService parkingSrevice, ParkingCommand cmd, Map extraParam) {

		List<Car> cars = parkingSrevice.getAllCars();
		for(Car car: cars) {
			System.out.print(car.getRegistrationNumber()+", ");
		}
    }
}
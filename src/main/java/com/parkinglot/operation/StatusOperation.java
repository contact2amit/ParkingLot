package com.parkinglot.operation;

import java.util.List;
import java.util.Map;

import com.parkinglot.OperationParam;
import com.parkinglot.service.ParkingSystemService;
import com.parkinglot.types.ParkingCommand;
import com.parkinglot.vo.Car;

public class StatusOperation implements ParkingLotOperation {
	 
    
    // constructors
     
    @Override
    public void execute(ParkingSystemService parkingSrevice, ParkingCommand cmd, OperationParam operationParam) {

	/*	List<Car> cars = parkingSrevice.getAllCars();
		StringBuilder status = new StringBuilder();
		for(Car car: cars) {
			status.append(car.getRegistrationNumber()).append(", ");
		}
		System.out.println(status.delete(status.length()-2, status.length()-1));
    }*/
    }
}
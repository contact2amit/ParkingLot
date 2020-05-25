package com.parkinglot.operation;

import java.util.List;
import java.util.Map;

import com.parkinglot.OperationParam;
import com.parkinglot.service.ParkingSystemService;
import com.parkinglot.types.Colour;
import com.parkinglot.types.InputParamEnum;
import com.parkinglot.types.ParkingCommand;
import com.parkinglot.vo.Car;

public class RegistrationNumbersForCarsWithColourOperation implements ParkingLotOperation {
	 
    
    // constructors
     
    @Override
    public void execute(ParkingSystemService parkingSrevice, ParkingCommand cmd, OperationParam operationParam) {
        
 /*   	Colour clr = (Colour)operationParam.getParam(InputParamEnum.COLOUR);
		
		List<Car> cars = parkingSrevice.getCarsByColor(clr);

		StringBuilder status = new StringBuilder();
		for(Car car: cars) {
			status.append(car.getRegistrationNumber()).append(", ");
		}
		System.out.println(status.delete(status.length()-2, status.length()-1));
    }*/
    }
}
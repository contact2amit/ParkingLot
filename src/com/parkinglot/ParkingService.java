package com.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.parkinglot.operation.LeaveOperation;
import com.parkinglot.operation.ParkOperation;
import com.parkinglot.operation.ParkingLotOperation;
import com.parkinglot.operation.RegistrationNumbersForCarsWithColourOperation;
import com.parkinglot.operation.SlotNumberForRegistrationNumberOperation;
import com.parkinglot.operation.SlotNumbersForCarsWithColourOperation;
import com.parkinglot.operation.StatusOperation;
import com.parkinglot.service.ParkingSystemService;
import com.parkinglot.service.ParkingSystemServiceImpl;
import com.parkinglot.vo.*;

public class ParkingService {
	private static final Scanner scanner = new Scanner(System.in);
	private static ParkingSystemService parkingSrevice = new ParkingSystemServiceImpl();
	public static void main(String[] args) {
		
		while(true) {
			String command = scanner.nextLine();
			processCommand(command.toUpperCase());

		}
	}
	private static void processCommand(String command) {
		String[] cmd = command.split(" ");
		ParkingLotOperation operation = null;
		Map extraParam = new HashMap();
		
		switch (ParkingCommand.valueOf(cmd[0].trim().toUpperCase())){
		case CREATE_PARKING_LOT:{
				parkingSrevice.createParkingLot(Integer.parseInt(cmd[1].trim()));
				System.out.println("Created a Parking Lot with size of "+cmd[1].trim());
				break;
			}
		case PARK:{
			Car car = new Car(cmd[1].trim(), Colour.valueOf(cmd[2].trim()));
			operation = new ParkOperation();
			extraParam.put("car", car);
			
			break;
		}
		case LEAVE:{
			operation = new LeaveOperation();
			extraParam.put("slotId", Integer.parseInt(cmd[1].trim()));
			
			break;
		}
		case STATUS:{
			operation = new StatusOperation();
			break;
		}
		case REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR:{
			operation = new RegistrationNumbersForCarsWithColourOperation();
			extraParam.put("colour", Colour.valueOf(cmd[1].trim()));
			
			break;
		}
		case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:{
			operation = new SlotNumbersForCarsWithColourOperation();
			extraParam.put("colour", Colour.valueOf(cmd[1].trim()));
			
			break;
		}
		case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:{
			operation = new SlotNumberForRegistrationNumberOperation();
			extraParam.put("registrationNum", cmd[1].trim());
			
			break;
		}
		default:{
			System.out.print("In valid Input");
			break;
		}
		}
		if(operation!=null) {
			operation.execute(parkingSrevice, ParkingCommand.valueOf(cmd[0].trim()), extraParam);
		}
	}

}

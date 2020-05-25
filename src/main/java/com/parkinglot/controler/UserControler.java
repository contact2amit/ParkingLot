package com.parkinglot.controler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.parkinglot.service.ParkingSystemService;
import com.parkinglot.service.request.ParkRequest;
import com.parkinglot.service.request.ParkingRequest;
import com.parkinglot.service.request.Slot;
import com.parkinglot.types.Colour;
import com.parkinglot.types.VehicleType;
import com.parkinglot.vo.Bike;
import com.parkinglot.vo.Car;
import com.parkinglot.vo.ElectricCar;
import com.parkinglot.vo.ParkingSlot;
import com.parkinglot.vo.PaynentRecipt;
import com.parkinglot.vo.Ticket;
import com.parkinglot.vo.Truck;
import com.parkinglot.vo.Vehicle;

@RestController
@RequestMapping(path = "/api/user")
public class UserControler {
	private static final Logger logger = LoggerFactory.getLogger(UserControler.class);
	@Autowired
	ParkingSystemService service;
	
	@PostMapping(value = "/park", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Ticket> park(@RequestBody ParkRequest request) {
		Vehicle v = null;
		if(VehicleType.BIKE.name().equals(request.getType()))
			v = new Bike(request.getRegistrationNumber(), Colour.valueOf(request.getColor()));

		if(VehicleType.CAR.name().equals(request.getType()))
			v = new Car(request.getRegistrationNumber(), Colour.valueOf(request.getColor()));
		

		if(VehicleType.ELECTRIC_CAR.name().equals(request.getType()))
			v = new ElectricCar(request.getRegistrationNumber(), Colour.valueOf(request.getColor()));
		

		if(VehicleType.TRUCK.name().equals(request.getType()))
			v = new Truck(request.getRegistrationNumber(), Colour.valueOf(request.getColor()));
		
		ParkingSlot slot  = service.asignParking(v);
		Ticket  response = new Ticket(v, slot);
		
	return ResponseEntity.ok().body(response);
	}
	
	
	@PostMapping(value = "/unpark", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<PaynentRecipt> unPark(@RequestBody Ticket ticket) {
		PaynentRecipt response = new PaynentRecipt();
		//response.setCreated(true);
	return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Slot>> statuOfParkingLevel(@RequestParam String levelId) {
		List<Slot>  response = new ArrayList<Slot>();
		//response.setCreated(true);
	return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value = "/status/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Slot>> statuOfParkinglot() {
		List<Slot>  response = new ArrayList<Slot>();
		//response.setCreated(true);
	return ResponseEntity.ok().body(response);
	}
	
}

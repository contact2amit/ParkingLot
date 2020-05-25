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
import com.parkinglot.service.request.ParkingRequest;
import com.parkinglot.service.request.Slot;
import com.parkinglot.service.response.ParkinglotCreated;
import com.parkinglot.types.Colour;
import com.parkinglot.vo.Car;
import com.parkinglot.vo.PaynentRecipt;
import com.parkinglot.vo.Ticket;

@RestController
@RequestMapping(path = "/api")
public class AuthorityControler {
	private static final Logger logger = LoggerFactory.getLogger(AuthorityControler.class);

	@Autowired
	ParkingSystemService service;
	
	@GetMapping(value = "/carsByColour", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Car>> carsByColour(@RequestParam Colour colour) {
		List<Car>  response = new ArrayList<Car>();
		//response.setCreated(true);
	return ResponseEntity.ok().body(response);
	}
	
	
	@GetMapping(value = "/slotByCar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Slot>> slotByCar(@RequestParam String registrationNo) {
		List<Slot>  response = new ArrayList<Slot>();
		//response.setCreated(true);
	return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value = "/slotByCarColour", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Slot>> slotByCarColour(@RequestParam Colour colour) {
		List<Slot>  response = new ArrayList<Slot>();
		//response.setCreated(true);
	return ResponseEntity.ok().body(response);
	}
	
}
/*
#Administrative services 

GET api/status/
GET api/status/{levelId}
*/
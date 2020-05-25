package com.parkinglot.controler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping(path = "/api/admin")
public class AdminControler {
	private static final Logger logger = LoggerFactory.getLogger(AdminControler.class);
	
	@Autowired
	ParkingSystemService service;

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ParkinglotCreated> create(@RequestBody List<ParkingRequest> parkingRequest) {
		ParkinglotCreated response = new ParkinglotCreated();
		service.createParkingLot(parkingRequest);
		response.setCreated(true);
	return ResponseEntity.ok().body(response);
	}
	
	
	@PostMapping(value = "/add/level", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addLevel(@RequestBody ParkingRequest parkingRequest) {
		ParkinglotCreated response = new ParkinglotCreated();
		response.setCreated(true);
	return ResponseEntity.ok().body("levelId");
	}
	
	@PostMapping(value = "/remove/level", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> removeLevel(@RequestParam String levelId) {
		//ParkinglotCreated response = new ParkinglotCreated();
		//response.setCreated(true);
	return ResponseEntity.ok().body("removed");
	}
	
	@PostMapping(value = "/add/slot", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> removeSlot(@RequestBody Slot slot) {
		//ParkinglotCreated response = new ParkinglotCreated();
		//response.setCreated(true);
	return ResponseEntity.ok().body("created");
	}
	
	@PostMapping(value = "/remove/slot", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addSlot(@RequestParam String slotId) {
		//ParkinglotCreated response = new ParkinglotCreated();
		//response.setCreated(true);
	return ResponseEntity.ok().body("removed");
	}
	
}
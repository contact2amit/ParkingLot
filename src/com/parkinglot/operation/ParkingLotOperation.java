package com.parkinglot.operation;

import java.util.Map;

import com.parkinglot.ParkingCommand;
import com.parkinglot.service.ParkingSystemService;

@FunctionalInterface
public interface ParkingLotOperation {
    void execute(ParkingSystemService parkingSrevice, ParkingCommand cmd, Map extraParam);
}
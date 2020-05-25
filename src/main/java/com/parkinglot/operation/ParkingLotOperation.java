package com.parkinglot.operation;

import java.util.Map;

import com.parkinglot.OperationParam;
import com.parkinglot.service.ParkingSystemService;
import com.parkinglot.types.ParkingCommand;

@FunctionalInterface
public interface ParkingLotOperation {
    void execute(ParkingSystemService parkingSrevice, ParkingCommand cmd, OperationParam operationParam);
}
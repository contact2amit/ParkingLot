package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

import com.parkinglot.types.InputParamEnum;

public class OperationParam {
	private Map operationParam = new HashMap();

	public void addParam(InputParamEnum key, Object value) {
		getOperationParam().put(key, value);
	}
	public Map getOperationParam() {
		return operationParam;
	}

	public Object getParam(InputParamEnum key) {
		return getOperationParam().get(key);
	}
	
}

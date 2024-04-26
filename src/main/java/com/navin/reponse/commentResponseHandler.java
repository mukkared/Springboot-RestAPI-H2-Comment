package com.navin.reponse;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class commentResponseHandler {

	public static ResponseEntity<Object> commentReponseBuilder(String message, HttpStatus httpStatus, Object responseObject) {
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("message", message);
		responseMap.put("HttpStatus", httpStatus);
		responseMap.put("data", responseObject);

		return new ResponseEntity<>(responseMap, httpStatus);
	}
}

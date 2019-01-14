package com.nousuapi.forms.testconnection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/forms")
public class ConnectionTestEndpoint {
	
	@GetMapping("/testconnection")
	public ResponseEntity<Object> connTest() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

package com.nousuapi.forms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.model.ActionFormModel;

@RestController
@RequestMapping("/api/forms")
public class FormsController {

	@RequestMapping("/actionForm")
	public ResponseEntity<Object> createForm(@RequestBody ActionFormModel actionform) {
		System.out.println(actionform.getPractises());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}

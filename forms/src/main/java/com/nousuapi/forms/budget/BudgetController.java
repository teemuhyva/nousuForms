package com.nousuapi.forms.budget;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.budget.model.BudgetResource;
import com.nousuapi.forms.service.ExcelService;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {

	@Autowired
	private ExcelService excelService;
	
	@PostMapping(value = "/createbudget")
	public ResponseEntity<?> createBudget(@RequestBody BudgetResource budgetResource) {
		
		try {
			excelService.createBudgetExcel(budgetResource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}

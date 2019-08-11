package com.nousuapi.forms.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.nousuapi.forms.budget.model.BudgetResource;
import com.nousuapi.forms.excelutil.BudgetExcel;

@Service
public class ExcelServiceImpl implements ExcelService {

	@Override
	public void createBudgetExcel(BudgetResource budget) throws IOException {
		BudgetExcel.createBudget(budget);
	}

}

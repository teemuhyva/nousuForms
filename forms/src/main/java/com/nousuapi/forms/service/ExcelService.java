package com.nousuapi.forms.service;

import java.io.IOException;

import com.nousuapi.forms.budget.model.BudgetResource;

public interface ExcelService {

	void createBudgetExcel(BudgetResource budget) throws IOException;
}

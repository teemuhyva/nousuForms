package com.nousuapi.forms.excelutil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.nousuapi.forms.budget.model.BudgetResource;
import com.nousuapi.forms.excelutil.generatesheet.RowSheetValidator;

public class BudgetExcel {

	public static void createBudget(BudgetResource budget) throws IOException {
		
		InputStream inp = new FileInputStream("src//main//resources//Talousarvio.xls");
    	HSSFWorkbook wb = new HSSFWorkbook(inp);
    	
		RowSheetValidator validator = new RowSheetValidator();
		validator.createBudgetExcel(budget, wb.getSheetAt(0));
		
    	OutputStream fileOut = new FileOutputStream("src//main//resources//Uusitalousarvio.xls");
        wb.write(fileOut);
        wb.close();
        fileOut.close();
	}
}

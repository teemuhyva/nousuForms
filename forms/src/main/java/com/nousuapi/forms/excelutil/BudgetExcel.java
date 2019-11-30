package com.nousuapi.forms.excelutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.nousuapi.forms.emailutil.EmailUtil;
import com.nousuapi.forms.excelutil.generatesheet.RowSheetValidator;
import com.nousuapi.forms.model.BudgetModelResource;

public class BudgetExcel {
	
	public static void createBudgetExcel(BudgetModelResource budget) throws IOException {
			
		InputStream inp = new FileInputStream("Talousarvio.xls");
    	HSSFWorkbook wb = new HSSFWorkbook(inp);
    	
    	
		RowSheetValidator validator = new RowSheetValidator();
		validator.updateBudgetExcel(budget, wb.getSheetAt(0));
    	
    	OutputStream fileOut = new FileOutputStream("TalousarvioTaytetty.xls");
        wb.write(fileOut);
        wb.close();
        fileOut.close();

        sendViaEmail();
        
	}
	
	public static void sendViaEmail() {
		EmailUtil send = new EmailUtil();
		File file = new File("TalousarvioTaytetty.xls");
		try {
			send.budgetExcelEmail(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

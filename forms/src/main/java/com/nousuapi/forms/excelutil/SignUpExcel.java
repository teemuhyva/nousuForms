package com.nousuapi.forms.excelutil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.nousuapi.forms.excelutil.generatesheet.RowSheetValidator;
import com.nousuapi.forms.signup.model.SignupResource;

public class SignUpExcel {

	public void generateForSignedUsers(List<SignupResource> userList) throws IOException {
		
		InputStream inp = new FileInputStream("Ilmoittautuneet.xls");
    	HSSFWorkbook wb = new HSSFWorkbook(inp);
    	
    	int rowCount = 2;
    	
    	for(SignupResource sign : userList) {
    		RowSheetValidator validator = new RowSheetValidator();
    		validator.updateSignedUserExcel(rowCount, 1, sign, wb.getSheetAt(0));
    		rowCount++;
    	}
    	
    	OutputStream fileOut = new FileOutputStream("uudetIlmoittautuneet.xls");
        wb.write(fileOut);
        wb.close();
        fileOut.close();
	}
}

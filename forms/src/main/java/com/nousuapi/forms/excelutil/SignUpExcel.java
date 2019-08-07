package com.nousuapi.forms.excelutil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.nousuapi.forms.excelutil.generatesheet.RowSheetValidator;
import com.nousuapi.forms.exceptions.ErrorLogging;
import com.nousuapi.forms.signup.model.SignupResource;

public class SignUpExcel {
	
	ErrorLogging log = new ErrorLogging();

	public void generateForSignedUsers(HttpServletResponse response, List<SignupResource> userList) throws IOException {
		
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

        byte[] fileByte = fileOut.toString().getBytes();
        log.setError1("file to bytes ::: " + fileByte);
    	downloadFile(fileByte, response);
	}
	
	public void downloadFile(byte[] byteFile, HttpServletResponse response) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ByteArrayInputStream bais = null;
		byte[] buffer = new byte[1024];
		int len;
		bais = new ByteArrayInputStream(byteFile);
		
		while((len = bais.read(buffer)) > 0) {
			baos.write(buffer, 0, len);
		}
		
		bais.close();
		
		ServletOutputStream sos = response.getOutputStream();
		response.setContentType("application/vnd.ms-sheet");
		response.setHeader("Content-Disposition", "attachment; filename=ilmoittautuneet.xml ");
		sos.write(baos.toByteArray());
		sos.flush();
		baos.close();
		log.setError1("was able to go trough downloadfile");
	}
	
	
}

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

import com.nousuapi.forms.emailutil.EmailUtil;
import com.nousuapi.forms.excelutil.generatesheet.RowSheetValidator;
import com.nousuapi.forms.exceptions.ErrorLogging;
import com.nousuapi.forms.signup.model.SignupResource;

public class SignUpExcel {
	
	ErrorLogging log = new ErrorLogging();

	public void generateForSignedUsers(HttpServletResponse response, List<SignupResource> userList) throws IOException {
		
		InputStream inp = new FileInputStream("Ilmoittautuneet.xls");
    	HSSFWorkbook wb = new HSSFWorkbook(inp);
    	
    	int firstSheet = 2;
    	int secondSheet = 2;
    	int thirdSheet = 2;
    	int fourthSheet = 2;
    	int fifthSheet = 2;
    	int sixthSeet = 2;
    	int seventhSheet = 2;
    	
    	for(SignupResource sign : userList) {
    		RowSheetValidator validator = new RowSheetValidator();
    		
    		switch (sign.getAgeClass()) {
			case "Lapset 2015/2016 -syntyneet (Keljonkangas)":
				validator.updateSignedUserExcel(firstSheet, 1, sign, wb.getSheetAt(0));
				firstSheet++;
				break;
			case "Lapset 2015 -syntyneet (Halssila)":
				validator.updateSignedUserExcel(secondSheet, 1, sign, wb.getSheetAt(1));
				secondSheet++;
				break;
			case "Lapset 2014 -syntyneet (Halssila)":
				validator.updateSignedUserExcel(thirdSheet, 1, sign, wb.getSheetAt(2));
				thirdSheet++;
				break;
			case "Lapset 2014 -syntyneet (Keljonkangas)":
				validator.updateSignedUserExcel(fourthSheet, 1, sign, wb.getSheetAt(3));
				fourthSheet++;
				break;
			case "Pojat 2013 -syntyneet (Halssila)":
				validator.updateSignedUserExcel(fifthSheet, 1, sign, wb.getSheetAt(4));
				fifthSheet++;
				break;
			case "Pojat 2011/2012 -syntyneet (Halssila)":
				validator.updateSignedUserExcel(sixthSeet, 1, sign, wb.getSheetAt(5));
				sixthSeet++;
				break;
			case "Tytöt 2012/2013 -syntyneet (Halssila)":
				validator.updateSignedUserExcel(seventhSheet, 1, sign, wb.getSheetAt(6));
				seventhSheet++;
				break;
			default:
				break;
			}
    	}
    	
    	OutputStream fileOut = null;
    	if(userList.get(0).getSignedUpFor().equals("kerho")) {
    		fileOut = new FileOutputStream("uudetKerhoIlmoittautuneet.xls");
    	} else {
    		fileOut = new FileOutputStream("uudetJoukkueIlmoittautuneet.xls");
    	}
    	
        wb.write(fileOut);
        wb.close();
        fileOut.close();

        sendViaEmail();
        
        //TODO webdownload, doesn't work yet 8.8.2019
        downloadFile(fileToByte("uudetIlmoittautuneet.xls"), response);
	}
	
	public void downloadFile(byte[] fileByte, HttpServletResponse response) throws IOException {
		
		String fileName = "uudetIlmoittautuneet.xls";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ByteArrayInputStream bais = null;
		byte[] buffer = new byte[1024];
		int len;
		bais = new ByteArrayInputStream(fileByte);
		
		while((len = bais.read(buffer)) > 0) {
			baos.write(buffer, 0, len);
		}
		
		bais.close();
		
		ServletOutputStream sos = response.getOutputStream();
		response.addHeader("Access-Control-Expose-Headers", "Content-Disposition");
		response.setContentType("application/vnd.ms-sheet");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		sos.write(baos.toByteArray());
		sos.flush();
		baos.close();
	}
	
	public byte[] fileToByte(String path) {
		FileInputStream fileInput = null;
		byte[] bytesArray = null;
		
		try {

            File file = new File(path);
            bytesArray = new byte[(int) file.length()];

            //read file into bytes[]
            fileInput = new FileInputStream(file);
            fileInput.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInput != null) {
                try {
                	fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return bytesArray;
	}
	
	public void sendViaEmail() {
		EmailUtil send = new EmailUtil();
		File file = new File("uudetIlmoittautuneet.xls");
		try {
			send.signUppedEmail(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

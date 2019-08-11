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

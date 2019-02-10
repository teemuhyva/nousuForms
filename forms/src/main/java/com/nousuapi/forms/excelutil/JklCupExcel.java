package com.nousuapi.forms.excelutil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.excelutil.generatesheet.RowSheetValidator;
import com.nousuapi.forms.helpers.DateHelper;

import lombok.val;

public class JklCupExcel {

	DateHelper helper = new DateHelper();
	
	public void JklExcelCreation(List<UserPurpose> userList) throws EncryptedDocumentException, IOException {
    	InputStream inp = new FileInputStream("src\\main\\resources\\jklcup.xls");
    
    	HSSFWorkbook wb = new HSSFWorkbook(inp);
        
        for(UserPurpose up : userList) {
        	RowSheetValidator validator = new RowSheetValidator();
        	
        	switch(up.getLocation()) {
	        	case "vehkahalli": {
	        		if(helper.getDayOfWeek(up.getDayOnsite()) == 6) {
	        			if(up.getUserRole().contains("kenttävastaava")) {
	        				validator.updateSheetVehkaHalli(9, 2, wb.getSheetAt(0), up);
	        			} else if(up.getUserRole().contains("päällikkö")){
	        				validator.updateSheetVehkaHalli(11, 2, wb.getSheetAt(0), up);
	        			}
	        			
	        		} else {
	        			if(up.getUserRole().contains("kenttävastaava")) {
	        				validator.updateSheetVehkaHalli(9, 8, wb.getSheetAt(0), up);
	        			} else if(up.getUserRole().contains("kenttäpäällikkö")) {
	        				validator.updateSheetVehkaHalli(11, 8, wb.getSheetAt(0), up);
	        			}
	        		}
	        		break;
	        	}
	        	case "vehkalampi": {
	        		if(helper.getDayOfWeek(up.getDayOnsite()) == 6) {
	        			if(up.getUserRole().contains("kenttävastaava")) {
	        				validator.updateSheetVehkaHalli(22, 2, wb.getSheetAt(0), up);
	        			} else if(up.getUserRole().contains("kenttäpäällikkö")) {
	        				validator.updateSheetVehkaHalli(29, 2, wb.getSheetAt(0), up);
	        			}
	        			
	        		} else {
	        			if(up.getUserRole().contains("kenttävastaava")) {
	        				validator.updateSheetVehkaHalli(22, 8, wb.getSheetAt(0), up);
	        			} else if(up.getUserRole().contains("kenttäpäällikkö")){
	        				validator.updateSheetVehkaHalli(29, 8, wb.getSheetAt(0), up);
	        			}
	        		}
	        		break;
	        	}
	        	case "huhtasuo": {
	        		if(helper.getDayOfWeek(up.getDayOnsite()) == 6) {
	        			if(up.getUserRole().contains("kenttävastaava")) {
	        				validator.updateSheetVehkaHalli(9, 2, wb.getSheetAt(1), up);
	        			} else if(up.getUserRole().contains("kenttäpäällikkö")){
	        				validator.updateSheetVehkaHalli(24, 2, wb.getSheetAt(1), up);
	        			}
	        			
	        			if(up.getUserRole().contains("liikenteenohjaus")) {
	        				validator.updateSheetVehkaHalli(33,  2, wb.getSheetAt(1), up);
	        			}
	        			
	        			if(up.getUserRole().contains("kioskinpito")) {
	        				validator.updateSheetVehkaHalli(43, 2,  wb.getSheetAt(1), up);
	        			}
	        			
	        		} else {
	        			if(up.getUserRole().contains("kenttävastaava")) {
	        				validator.updateSheetVehkaHalli(9, 8, wb.getSheetAt(1), up);
	        			} else if(up.getUserRole().contains("kenttäpäällikkö")){
	        				validator.updateSheetVehkaHalli(24, 8, wb.getSheetAt(1), up);
	        			}
	        			
	        			if(up.getUserRole().contains("palkintojenjako")) {
	        				validator.updateSheetVehkaHalli(33,  8, wb.getSheetAt(1), up);
	        			}
	        			
	        			if(up.getUserRole().contains("kioskinpito")) {
	        				validator.updateSheetVehkaHalli(43, 8,  wb.getSheetAt(1), up);
	        			}
	        		}
	        		break;
	        	}
	        	case "palokka": {
	        		if(helper.getDayOfWeek(up.getDayOnsite()) == 6) {
	        			if(up.getUserRole().contains("kenttävastaava")) {
	        				validator.updateSheetVehkaHalli(9, 2, wb.getSheetAt(2), up);
	        			} else if(up.getUserRole().contains("kenttäpäällikkö")){
	        				validator.updateSheetVehkaHalli(20, 2, wb.getSheetAt(2), up);
	        			}
	        			
	        			if(up.getUserRole().contains("liikenteenohjaus")) {
	        				validator.updateSheetVehkaHalli(29,  2, wb.getSheetAt(2), up);
	        			}
	        			
	        			if(up.getUserRole().contains("kioskinpito")) {
	        				validator.updateSheetVehkaHalli(39, 2,  wb.getSheetAt(2), up);
	        			}
	        			
	        		} else {
	        			if(up.getUserRole().contains("kenttävastaava")) {
	        				validator.updateSheetVehkaHalli(9, 8, wb.getSheetAt(2), up);
	        			} else if(up.getUserRole().contains("kenttäpäällikkö")){
	        				validator.updateSheetVehkaHalli(20, 8, wb.getSheetAt(2), up);
	        			}
	        			
	        			if(up.getUserRole().contains("palkintojenjako")) {
	        				validator.updateSheetVehkaHalli(29,  8, wb.getSheetAt(2), up);
	        			}
	        			
	        			if(up.getUserRole().contains("kioskinpito")) {
	        				validator.updateSheetVehkaHalli(39, 8,  wb.getSheetAt(2), up);
	        			}
	        		}
	        		break;
	        	}
	        	case "palokka koulu": {
	        		if(helper.getDayOfWeek(up.getDayOnsite()) == 5) {
        				validator.updateSheetVehkaHalli(10, 2, wb.getSheetAt(3), up);
	        		} else if(helper.getDayOfWeek(up.getDayOnsite()) == 6) {
	        			validator.updateSheetVehkaHalli(17, 2, wb.getSheetAt(3), up);
	        		} else {
	        			validator.updateSheetVehkaHalli(17, 8, wb.getSheetAt(3), up);
	        		}	        			        		
	        		break;
	        	}
	        	case "other": {
	        		if(up.getUserRole().contains("yövalvonta")) {
	        			if(helper.getDayOfWeek(up.getDayOnsite()) == 5) {
	        				validator.updateSheetVehkaHalli(10, 2, wb.getSheetAt(4), up);
	        			} else {
	        				validator.updateSheetVehkaHalli(10, 8, wb.getSheetAt(4), up);
	        			}
	        		}
	        		
	        		if(up.getUserRole().contains("järjestely")) {
	        			if(helper.getDayOfWeek(up.getDayOnsite()) == 5) {
	        				validator.updateSheetVehkaHalli(23, 2, wb.getSheetAt(4), up);
	        			} else {
	        				validator.updateSheetVehkaHalli(23, 8, wb.getSheetAt(4), up);
	        			}
	        		}
	        		break;
	        	}
	        	case "teamPayments": {
	        		break;
	        	}
        	} 
		}   
        
        OutputStream fileOut = new FileOutputStream("src\\main\\resources\\jklcup.xls");
        wb.write(fileOut);
        fileOut.close();
	}
	
}

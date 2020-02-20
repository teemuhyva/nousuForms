package com.nousuapi.forms.excelutil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.nousuapi.forms.admin.model.UserPurpose;
import com.nousuapi.forms.enums.OnsiteDay;
import com.nousuapi.forms.enums.UserRole;
import com.nousuapi.forms.excelutil.generatesheet.RowSheetValidator;
import com.nousuapi.forms.helpers.DateHelper;

public class JklCupExcel {

	DateHelper helper = new DateHelper();
	
	public void JklExcelCreation(List<UserPurpose> userList) throws EncryptedDocumentException, IOException {
    	InputStream inp = new FileInputStream("jklcup.xls");
    
    	HSSFWorkbook wb = new HSSFWorkbook(inp);
        
        for(UserPurpose up : userList) {
        	RowSheetValidator validator = new RowSheetValidator();
        	
        	switch(up.getLocation()) {
	        	case "Vehkahalli": {
	        		if(up.getWeekDay().equals(OnsiteDay.Lauantai)) {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheetVehkaHalli(9, 2, wb.getSheetAt(0), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö){
	        				validator.updateSheetVehkaHalli(11, 2, wb.getSheetAt(0), up);
	        			}
	        			
	        		} else {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheetVehkaHalli(9, 8, wb.getSheetAt(0), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö) {
	        				validator.updateSheetVehkaHalli(11, 8, wb.getSheetAt(0), up);
	        			}
	        		}
	        		break;
	        	}
	        	case "Vehkalampi": {
	        		if(up.getWeekDay().equals(OnsiteDay.Lauantai)) {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheetVehkaHalli(22, 2, wb.getSheetAt(0), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö) {
	        				validator.updateSheetVehkaHalli(29, 2, wb.getSheetAt(0), up);
	        			}
	        			
	        		} else {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheetVehkaHalli(22, 8, wb.getSheetAt(0), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö){
	        				validator.updateSheetVehkaHalli(29, 8, wb.getSheetAt(0), up);
	        			}
	        		}
	        		break;
	        	}
	        	case "Huhtasuo": {
	        		if(up.getWeekDay().equals(OnsiteDay.Lauantai)) {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheetVehkaHalli(9, 2, wb.getSheetAt(1), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö){
	        				validator.updateSheetVehkaHalli(24, 2, wb.getSheetAt(1), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Liikenteenohjaus) {
	        				validator.updateSheetVehkaHalli(33,  2, wb.getSheetAt(1), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Kioski) {
	        				validator.updateSheetVehkaHalli(43, 2,  wb.getSheetAt(1), up);
	        			}
	        			
	        		} else {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheetVehkaHalli(9, 8, wb.getSheetAt(1), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö){
	        				validator.updateSheetVehkaHalli(24, 8, wb.getSheetAt(1), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Palkintojenjako) {
	        				validator.updateSheetVehkaHalli(33,  8, wb.getSheetAt(1), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Kioski) {
	        				validator.updateSheetVehkaHalli(43, 8,  wb.getSheetAt(1), up);
	        			}
	        		}
	        		break;
	        	}
	        	case "Palokankenttä": {
	        		if(up.getWeekDay().equals(OnsiteDay.Lauantai)) {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheetVehkaHalli(9, 2, wb.getSheetAt(2), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö){
	        				validator.updateSheetVehkaHalli(20, 2, wb.getSheetAt(2), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Liikenteenohjaus) {
	        				validator.updateSheetVehkaHalli(29,  2, wb.getSheetAt(2), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Kioski) {
	        				validator.updateSheetVehkaHalli(39, 2,  wb.getSheetAt(2), up);
	        			}
	        			
	        		} else {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheetVehkaHalli(9, 8, wb.getSheetAt(2), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö){
	        				validator.updateSheetVehkaHalli(20, 8, wb.getSheetAt(2), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Palkintojenjako) {
	        				validator.updateSheetVehkaHalli(29,  8, wb.getSheetAt(2), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Kioski) {
	        				validator.updateSheetVehkaHalli(39, 8,  wb.getSheetAt(2), up);
	        			}
	        		}
	        		break;
	        	}
	        	case "Palokankoulu": {
	        		if(up.getWeekDay().equals(OnsiteDay.Perjantai)) {
        				validator.updateSheetVehkaHalli(10, 2, wb.getSheetAt(3), up);
	        		} else if(up.getWeekDay().equals(OnsiteDay.Lauantai)) {
	        			validator.updateSheetVehkaHalli(17, 2, wb.getSheetAt(3), up);
	        		} else {
	        			validator.updateSheetVehkaHalli(17, 8, wb.getSheetAt(3), up);
	        		}	        			        		
	        		break;
	        	}
	        	case "Muut": {
	        		if(up.getUserRole() == UserRole.Yövalvonta) {
	        			if(up.getWeekDay().equals(OnsiteDay.Perjantai)) {
	        				validator.updateSheetVehkaHalli(10, 2, wb.getSheetAt(4), up);
	        			} else {
	        				validator.updateSheetVehkaHalli(10, 8, wb.getSheetAt(4), up);
	        			}
	        		}
	        		
	        		if(up.getUserRole() == UserRole.Yövalvonta) {
	        			if(up.getWeekDay().equals(OnsiteDay.Perjantai)) {
	        				validator.updateSheetVehkaHalli(23, 2, wb.getSheetAt(4), up);
	        			} else {
	        				validator.updateSheetVehkaHalli(23, 8, wb.getSheetAt(4), up);
	        			}
	        		}
	        		break;
	        	}
        	} 
		}   
        
        OutputStream fileOut = new FileOutputStream("jklcup.xls");
        wb.write(fileOut);
        wb.close();
        fileOut.close();
	}
	
}

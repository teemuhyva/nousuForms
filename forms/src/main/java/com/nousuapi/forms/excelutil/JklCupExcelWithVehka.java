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

import com.nousuapi.forms.entity.UserPurposeInfo;
import com.nousuapi.forms.enums.IlGroup;
import com.nousuapi.forms.enums.OnsiteDay;
import com.nousuapi.forms.enums.UserRole;
import com.nousuapi.forms.excelutil.generatesheet.RowSheetValidator;
import com.nousuapi.forms.helpers.DateHelper;

import lombok.val;

public class JklCupExcelWithVehka {

	DateHelper helper = new DateHelper();
	
	public void JklExcelCreation(List<UserPurposeInfo> userList) throws EncryptedDocumentException, IOException {
    	InputStream jklcupNormal = new FileInputStream("src\\main\\resources\\JKLCup2020-tyotehtavat.xls");
    	//InputStream jklcupNormalSuper = new FileInputStream("src\\main\\resources\\jklcup.xls");
    	HSSFWorkbook wb = new HSSFWorkbook(jklcupNormal);
        
        for(UserPurposeInfo up : userList) {
        	RowSheetValidator validator = new RowSheetValidator();
        	
        	/*
        	 * NOTE MEMO. There are one tournament that contains vehkahalli and vehkalampi. Other tournament doesn't contain these.
        	 * Ask from admin who is hosting tournament that which tournament will be in progress. 
        	 * Then comment / uncommment
        	 * InputStream jklcupNormal = new FileInputStream("src\\main\\resources\\jklcup.xls"); -> without vehkalampi
        	 * InputStream jklcupNormal = new FileInputStream("src\\main\\resources\\jklcup.xls"); -> with vehkalampi
        	 * */
        	switch(up.getLocation()) {
	        	case Vehkahalli: {
	        		if(up.getWeekDay().equals(OnsiteDay.Lauantai)) {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheet(9, 2, wb.getSheetAt(0), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö){
	        				validator.updateSheet(11, 2, wb.getSheetAt(0), up);
	        			}
	        			
	        		} else {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheet(9, 8, wb.getSheetAt(0), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö) {
	        				validator.updateSheet(11, 8, wb.getSheetAt(0), up);
	        			}
	        		}
	        		break;
	        	}
	        	case Vehkalampi: {
	        		if(up.getWeekDay().equals(OnsiteDay.Lauantai)) {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheet(22, 2, wb.getSheetAt(0), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö) {
	        				validator.updateSheet(29, 2, wb.getSheetAt(0), up);
	        			}
	        			
	        		} else {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheet(22, 8, wb.getSheetAt(0), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö){
	        				validator.updateSheet(29, 8, wb.getSheetAt(0), up);
	        			}
	        		}
	        		break;
	        	}
	        	case Huhtasuo: {
	        		if(up.getWeekDay().equals(OnsiteDay.Lauantai)) {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheet(9, 2, wb.getSheetAt(1), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö){
	        				validator.updateSheet(24, 2, wb.getSheetAt(1), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Liikenteenohjaus) {
	        				validator.updateSheet(33,  2, wb.getSheetAt(1), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Kioski) {
	        				validator.updateSheet(43, 2,  wb.getSheetAt(1), up);
	        			}
	        			
	        		} else {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheet(9, 8, wb.getSheetAt(1), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö){
	        				validator.updateSheet(24, 8, wb.getSheetAt(1), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Palkintojenjako) {
	        				validator.updateSheet(33,  8, wb.getSheetAt(1), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Kioski) {
	        				validator.updateSheet(43, 8,  wb.getSheetAt(1), up);
	        			}
	        		}
	        		break;
	        	}
	        	case Palokankenttä: {
	        		if(up.getWeekDay().equals(OnsiteDay.Lauantai)) {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheet(9, 2, wb.getSheetAt(2), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö){
	        				validator.updateSheet(20, 2, wb.getSheetAt(2), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Liikenteenohjaus) {
	        				validator.updateSheet(29,  2, wb.getSheetAt(2), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Kioski) {
	        				validator.updateSheet(39, 2,  wb.getSheetAt(2), up);
	        			}
	        			
	        		} else {
	        			if(up.getUserRole() == UserRole.Kenttävastaava) {
	        				validator.updateSheet(9, 8, wb.getSheetAt(2), up);
	        			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö){
	        				validator.updateSheet(20, 8, wb.getSheetAt(2), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Palkintojenjako) {
	        				validator.updateSheet(29,  8, wb.getSheetAt(2), up);
	        			}
	        			
	        			if(up.getUserRole() == UserRole.Kioski) {
	        				validator.updateSheet(39, 8,  wb.getSheetAt(2), up);
	        			}
	        		}
	        		break;
	        	}
	        	case Palokankoulu: {
	        		if(up.getWeekDay().equals(OnsiteDay.Perjantai)) {
        				validator.updateSheet(10, 2, wb.getSheetAt(3), up);
	        		} else if(up.getWeekDay().equals(OnsiteDay.Lauantai)) {
	        			validator.updateSheet(17, 2, wb.getSheetAt(3), up);
	        		} else {
	        			validator.updateSheet(17, 8, wb.getSheetAt(3), up);
	        		}	        			        		
	        		break;
	        	}
	        	case Muut: {
	        		if(up.getUserRole() == UserRole.Yövalvonta) {
	        			if(up.getWeekDay().equals(OnsiteDay.Perjantai)) {
	        				validator.updateSheet(10, 2, wb.getSheetAt(4), up);
	        			} else {
	        				validator.updateSheet(10, 8, wb.getSheetAt(4), up);
	        			}
	        		}
	        		
	        		if(up.getUserRole() == UserRole.Yövalvonta) {
	        			if(up.getWeekDay().equals(OnsiteDay.Perjantai)) {
	        				validator.updateSheet(23, 2, wb.getSheetAt(4), up);
	        			} else {
	        				validator.updateSheet(23, 8, wb.getSheetAt(4), up);
	        			}
	        		}
	        		break;
	        	}
        	} 
		}   
        
        OutputStream fileOut = new FileOutputStream("src\\main\\resources\\JKLCup2020-tyotehtavat-taytetty.xls");
        wb.write(fileOut);
        wb.close();
        fileOut.close();
	}
	
}

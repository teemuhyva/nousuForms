package com.nousuapi.forms.excelutil.generatesheet;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.helpers.DateHelper;
import com.nousuapi.forms.signup.model.SignupResource;

public class RowSheetValidator {

	public void updateSheetVehkaHalli(int rowIndex, int columnIndex, HSSFSheet sheet, UserPurpose up) {
		updateCellValuesBySheet(rowIndex, columnIndex, up, sheet);
	}
	
	public void updateSignedUserExcel(int rowIndex, int cellIndex, SignupResource signed, HSSFSheet sheet) {
		writeSignedUsersExcel(rowIndex, cellIndex, signed, sheet);
	}
	
	private void updateCellValuesBySheet(int rowIndex, int cellIndex, UserPurpose up, HSSFSheet sheet) {
		DateHelper helper = new DateHelper();
		Row row = sheet.getRow(rowIndex);
		row.getCell(cellIndex).setCellValue(up.getPersonName());
		row.getCell(cellIndex + 1).setCellValue(up.getIlGroup().toString());
		row.getCell(cellIndex + 2).setCellValue(up.getPhoneNumber());
		row.getCell(cellIndex + 3).setCellValue(helper.startEndTime(up.getStartTime(), up.getEndTime()));	
	}
	
	private void writeSignedUsersExcel(int rowIndex, int cellIndex, SignupResource signed, HSSFSheet sheet) {
		Row row = sheet.getRow(rowIndex);
		row.getCell(cellIndex).setCellValue(signed.getChildName());
		row.getCell(cellIndex + 1).setCellValue(signed.getDateOfBirth());
		row.getCell(cellIndex + 2).setCellValue(signed.getAddress());
		row.getCell(cellIndex + 3).setCellValue(signed.getPostNum());
		row.getCell(cellIndex + 4).setCellValue(signed.getPostOffice());
		row.getCell(cellIndex + 5).setCellValue(signed.getPhone());
		row.getCell(cellIndex + 6).setCellValue(signed.getEmail());
		row.getCell(cellIndex + 7).setCellValue(signed.getParentName());
		
		if(signed.getPayment() != null) {
			row.getCell(cellIndex + 8).setCellValue(signed.getPayment());	
		}
		if(signed.getOther() != null) {
			row.getCell(cellIndex + 9).setCellValue(signed.getOther());	
		}		
	}
}

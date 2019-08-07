package com.nousuapi.forms.excelutil.generatesheet;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.exceptions.ErrorLogging;
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
		
		if(row.getCell(cellIndex) != null) {
			row.getCell(cellIndex).setCellValue(signed.getChildName());
		} else if(row.getCell(cellIndex + 1) != null) {
			row.getCell(cellIndex + 1).setCellValue(signed.getDateOfBirth());
		} else if(row.getCell(cellIndex + 2) != null) {
			row.getCell(cellIndex + 2).setCellValue(signed.getAddress());
		} else if(row.getCell(cellIndex + 3) != null) {
			row.getCell(cellIndex + 3).setCellValue(signed.getPostNum());
		} else if(row.getCell(cellIndex + 4) != null) {
			row.getCell(cellIndex + 4).setCellValue(signed.getPostOffice());
		} else if(row.getCell(cellIndex + 5) != null) {
			row.getCell(cellIndex + 5).setCellValue(signed.getPhone());
		} else if(row.getCell(cellIndex + 6) != null) {
			row.getCell(cellIndex + 6).setCellValue(signed.getEmail());
		} else if(row.getCell(cellIndex + 7) != null) {
			row.getCell(cellIndex + 7).setCellValue(signed.getParentName());
		} else if(signed.getPayment() != null && row.getCell(cellIndex + 8) != null) {
			row.getCell(cellIndex + 8).setCellValue(signed.getPayment());
		} else if(signed.getOther() != null && row.getCell(cellIndex + 9) != null) {
			row.getCell(cellIndex + 9).setCellValue(signed.getOther());
		}			
	}
}

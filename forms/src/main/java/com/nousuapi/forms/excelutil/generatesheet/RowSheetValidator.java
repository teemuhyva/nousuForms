package com.nousuapi.forms.excelutil.generatesheet;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.helpers.DateHelper;

public class RowSheetValidator {

	public void updateSheetVehkaHalli(int rowIndex, int columnIndex, HSSFSheet sheet, UserPurpose up) {
		updateCellValuesBySheet(rowIndex, columnIndex, up, sheet);
	}
	
	private void updateCellValuesBySheet(int rowIndex, int cellIndex, UserPurpose up, HSSFSheet sheet) {
		DateHelper helper = new DateHelper();
		Row row = sheet.getRow(rowIndex);
		row.getCell(cellIndex).setCellValue(up.getPersonName());
		row.getCell(cellIndex + 1).setCellValue(up.getIlGroup().toString());
		row.getCell(cellIndex + 2).setCellValue(up.getPhoneNumber());
		row.getCell(cellIndex + 3).setCellValue(helper.startEndTime(up.getStartTime(), up.getEndTime()));	
	}
}

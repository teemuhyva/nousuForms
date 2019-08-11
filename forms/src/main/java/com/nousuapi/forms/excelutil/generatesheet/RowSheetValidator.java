package com.nousuapi.forms.excelutil.generatesheet;

import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.jayway.jsonpath.ParseContext;
import com.nousuapi.forms.budget.model.BudgetResource;
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
		
		row.getCell(cellIndex).setCellValue(signed.getChildName());
		row.getCell(cellIndex + 1).setCellValue(signed.getDateOfBirth());
		row.getCell(cellIndex + 2).setCellValue(signed.getAddress());
		row.getCell(cellIndex + 3).setCellValue(signed.getPostNum());
		row.getCell(cellIndex + 4).setCellValue(signed.getPostOffice());
		row.getCell(cellIndex + 5).setCellValue(signed.getPhone());
		row.getCell(cellIndex + 6).setCellValue(signed.getEmail());
		row.getCell(cellIndex + 7).setCellValue(signed.getParentName());		
		if(signed.getPayment() != null) row.getCell(cellIndex + 8).setCellValue(signed.getPayment());		
		if(signed.getOther() != null) row.getCell(cellIndex + 9).setCellValue(signed.getOther());		
	}
	
	public void createBudgetExcel(BudgetResource budget, HSSFSheet sheet) {
		//costs
		getRow(sheet, 4).getCell(3).setCellValue(budget.getParticipantPament());
		getRow(sheet, 5).getCell(3).setCellValue(budget.getLicencePayment());
		getRow(sheet, 6).getCell(3).setCellValue(budget.getArenaPayment());
		getRow(sheet, 7).getCell(3).setCellValue(budget.getRefPayment());
		getRow(sheet, 8).getCell(3).setCellValue(budget.getEventPayment());
		getRow(sheet, 9).getCell(3).setCellValue(budget.getUnionEventPayment());
		getRow(sheet, 10).getCell(3).setCellValue(budget.getHallTimesPayment());
		getRow(sheet, 11).getCell(3).setCellValue(budget.getMembershipPayment());
		getRow(sheet, 12).getCell(3).setCellValue(budget.getMaterialPayment());
		getRow(sheet, 13).getCell(3).setCellValue(budget.getGameClothesPayment());
		getRow(sheet, 14).getCell(3).setCellValue(budget.getAdditionalEventPayment());
		getRow(sheet, 15).getCell(3).setCellValue(budget.getTournamentParticipantPayment());
		getRow(sheet, 16).getCell(3).setCellValue(budget.getTournamentAdditionalPayment());
		getRow(sheet, 17).getCell(3).setCellValue(budget.getCoatchEducationPayment());
		getRow(sheet, 18).getCell(3).setCellValue(budget.getOtherpayment());
		getRow(sheet, 19).getCell(3).setCellValue(budget.getTotalCost());
		
		//income
		getRow(sheet, 23).getCell(3).setCellValue(budget.getActionPayment());
		getRow(sheet, 24).getCell(3).setCellValue(budget.getEventAdditionPayment());
		getRow(sheet, 25).getCell(3).setCellValue(budget.getSellingMiscellaneous());
		getRow(sheet, 26).getCell(3).setCellValue(budget.getSupporter());
		getRow(sheet, 27).getCell(3).setCellValue(budget.getOtherpayment());
		getRow(sheet, 31).getCell(3).setCellValue(budget.getTotalIncome());
		
		//additional info text
		getRow(sheet, 35).getCell(1).setCellValue(budget.getAdditionalinfoText());
		getRow(sheet, 38).getCell(1).setCellValue(DateHelper.getCurrentTime() + " Jyväskylä");
		getRow(sheet, 38).getCell(2).setCellValue(budget.getMoneyManager());
		getRow(sheet, 38).getCell(3).setCellValue(budget.getTeamLeader());
	}
	
	public Row getRow(HSSFSheet sheet, int rowId) {
		 Row row = sheet.getRow(rowId);
		 return row;
	}
}

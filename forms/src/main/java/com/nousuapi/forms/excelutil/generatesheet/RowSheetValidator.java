package com.nousuapi.forms.excelutil.generatesheet;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.exceptions.ErrorLogging;
import com.nousuapi.forms.helpers.DateHelper;
import com.nousuapi.forms.model.BudgetModelResource;
import com.nousuapi.forms.signup.model.SignupResource;

public class RowSheetValidator {

	public void updateSheetVehkaHalli(int rowIndex, int columnIndex, HSSFSheet sheet, UserPurpose up) {
		updateCellValuesBySheet(rowIndex, columnIndex, up, sheet);
	}
	
	public void updateSignedUserExcel(int rowIndex, int cellIndex, SignupResource signed, HSSFSheet sheet) {
		writeSignedUsersExcel(rowIndex, cellIndex, signed, sheet);
	}
	
	public void updateBudgetExcel(BudgetModelResource budget, HSSFSheet sheet) {
		writeBudgetExcel(budget, sheet);
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
	
	private void writeBudgetExcel(BudgetModelResource budget, HSSFSheet sheet) {
		
		for(int i = 2; i < 39; i++) {
			if(sheet.getRow(i) != null) {
				Row row = sheet.getRow(i);
			
				if(row.getRowNum() == 2) row.getCell(3).setCellValue(budget.getAgeClass());
				if(row.getRowNum() == 4) row.getCell(3).setCellValue(budget.getOsallistumisMaksut());
				if(row.getRowNum() == 5) row.getCell(3).setCellValue(budget.getLisenssiMaksut());
				if(row.getRowNum() == 6) row.getCell(3).setCellValue(budget.getKenttamaksut());
				if(row.getRowNum() == 7) row.getCell(3).setCellValue(budget.getErotuomariMaksut());
				if(row.getRowNum() == 8) row.getCell(3).setCellValue(budget.getPiiriJoukkueTapahtumat());
				if(row.getRowNum() == 9) row.getCell(3).setCellValue(budget.getTapatumaOsallistumiset());
				if(row.getRowNum() == 10) row.getCell(3).setCellValue(budget.getKenttaVuorot());
				if(row.getRowNum() == 11) row.getCell(3).setCellValue(budget.getJasenMaksut());
				if(row.getRowNum() == 12) row.getCell(3).setCellValue(budget.getTarvikkeet());
				if(row.getRowNum() == 13) row.getCell(3).setCellValue(budget.getEdustusAsut());
				if(row.getRowNum() == 14) row.getCell(3).setCellValue(budget.getOheisHarjoitteet());
				if(row.getRowNum() == 15) row.getCell(3).setCellValue(budget.getTurnausosallistumisMaksut());
				if(row.getRowNum() == 16) row.getCell(3).setCellValue(budget.getMatkat());
				if(row.getRowNum() == 17) row.getCell(3).setCellValue(budget.getKoulutusMaksut());
				if(row.getRowNum() == 18) row.getCell(3).setCellValue(budget.getEssentials());
				if(budget.getOther1Reason() != null && row.getRowNum() == 19) {
					if(row.getRowNum() == 19) row.getCell(2).setCellValue(budget.getOther1Reason());
					if(row.getRowNum() == 19) row.getCell(3).setCellValue(budget.getOther1());
				}
				
				if(row.getRowNum() == 20) row.getCell(3).setCellValue(budget.getMenotTotal());
				if(row.getRowNum() == 23) row.getCell(3).setCellValue(budget.getTulotToimintaMaksut());
				if(row.getRowNum() == 24) row.getCell(3).setCellValue(budget.getTulotTilaisuudet());
				if(row.getRowNum() == 25) row.getCell(3).setCellValue(budget.getTulotTuotemyynnit());
				if(row.getRowNum() == 26) row.getCell(3).setCellValue(budget.getTulotTukijat());
				if(row.getRowNum() == 27) row.getCell(3).setCellValue(budget.getTulotOther());
				if(budget.getOtherReason2() != null && row.getRowNum() == 28) {
					if(row.getRowNum() == 28) row.getCell(2).setCellValue(budget.getOtherReason2());
					if(row.getRowNum() == 28) row.getCell(3).setCellValue(budget.getTulotOther2());
				}
				if(budget.getOtherReason3() != null && row.getRowNum() == 29) {
					if(row.getRowNum() == 29) row.getCell(2).setCellValue(budget.getOtherReason3());
					if(row.getRowNum() == 29) row.getCell(3).setCellValue(budget.getTulotOther3());
				}
				if(budget.getOtherReason4() != null && row.getRowNum() == 30) {
					if(row.getRowNum() == 30) row.getCell(2).setCellValue(budget.getOtherReason4());
					if(row.getRowNum() == 30) row.getCell(3).setCellValue(budget.getTulotOther4());
				}
				
				if(row.getRowNum() == 31) row.getCell(3).setCellValue(budget.getTulotTotal());
				if(row.getRowNum() == 35) row.getCell(1).setCellValue(budget.getExtraFieldForNeededInfo());
				if(row.getRowNum() == 38) row.getCell(1).setCellValue(budget.getDate() + " " + budget.getPlace());				
				if(row.getRowNum() == 38) row.getCell(2).setCellValue(budget.getMoneyManager());
				if(row.getRowNum() == 38) row.getCell(3).setCellValue(budget.getTeamLeader());
			}
		}
		
	}
}

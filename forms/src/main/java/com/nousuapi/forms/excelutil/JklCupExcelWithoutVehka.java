package com.nousuapi.forms.excelutil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.nousuapi.forms.entity.UserPurposeInfo;
import com.nousuapi.forms.enums.Location;
import com.nousuapi.forms.enums.OnsiteDay;
import com.nousuapi.forms.enums.UserRole;
import com.nousuapi.forms.excelutil.generatesheet.RowSheetValidator;

public class JklCupExcelWithoutVehka {
	
	public void JklExcelCreation(List<UserPurposeInfo> userList) throws EncryptedDocumentException, IOException {
    	InputStream jklcupNormal = new FileInputStream("src\\main\\resources\\JKLCup2020-tyotehtavat.xls");
    	//InputStream jklcupNormalSuper = new FileInputStream("src\\main\\resources\\jklcup.xls");
    	HSSFWorkbook wb = new HSSFWorkbook(jklcupNormal);
        
        List<UserPurposeInfo> huhtasuo = new ArrayList<UserPurposeInfo>();
        List<UserPurposeInfo> palokankoulu = new ArrayList<UserPurposeInfo>();
        List<UserPurposeInfo> palokankentta = new ArrayList<UserPurposeInfo>();
        List<UserPurposeInfo> muut = new ArrayList<UserPurposeInfo>();
                
        for(UserPurposeInfo up : userList) {
        	if(up.getLocation().equals(Location.Huhtasuo)) {
        		huhtasuo.add(up);
        	} else if(up.getLocation().equals(Location.Palokankenttä)) {
        		palokankentta.add(up);
        	} else if(up.getLocation().equals(Location.Palokankoulu)) {
        		palokankoulu.add(up);
        	} else if(up.getLocation().equals(Location.Muut)){
        		muut.add(up);
        	}
        }
        
        parseHuhtasuo(huhtasuo, wb);
        parsePalokanKoulu(palokankoulu, wb);
        parsePalokanKentta(palokankentta, wb);
        parseMuut(muut, wb);
        
        /*
    	for(UserPurposeInfo up : userList) {
        	RowSheetValidator validator = new RowSheetValidator();
        	*/
        	/*
        	 * NOTE MEMO. There are one tournament that contains vehkahalli and vehkalampi. Other tournament doesn't contain these.
        	 * Ask from admin who is hosting tournament that which tournament will be in progress. 
        	 * Then comment / uncommment
        	 * InputStream jklcupNormal = new FileInputStream("src\\main\\resources\\jklcup.xls"); -> without vehkalampi
        	 * InputStream jklcupNormal = new FileInputStream("src\\main\\resources\\jklcup.xls"); -> with vehkalampi
        	 * */

    	OutputStream fileOut = new FileOutputStream("src\\main\\resources\\JKLCup2020-tyotehtavat-taytetty.xls");
        wb.write(fileOut);
        wb.close();
        fileOut.close();
	}
		
	private void parseHuhtasuo(List<UserPurposeInfo> huhtasuo, HSSFWorkbook wb) {
		RowSheetValidator validator = new RowSheetValidator();
		int rowCounter = 0;
		for (UserPurposeInfo up : huhtasuo) {
			if(up.getUserRole().equals(UserRole.Kenttävastaava) && up.getWeekDay().equals(OnsiteDay.Lauantai)) {
				if(up.getStartTime().equals("08:10") && rowCounter == 0) {
					validator.updateSheet(9, 2, wb.getSheetAt(2), up);
					rowCounter++;
				} else if(up.getStartTime().equals("08:10")	&& rowCounter == 1) {
					validator.updateSheet(11, 2, wb.getSheetAt(2), up);
					rowCounter++;
				} else if(up.getStartTime().equals("13:30") && rowCounter == 2) {
					validator.updateSheet(16, 2, wb.getSheetAt(2), up);
					rowCounter++;
				} else if(up.getStartTime().equals("13:30") && rowCounter == 3) {
					validator.updateSheet(18, 2, wb.getSheetAt(2), up);
					rowCounter++;
				}
				
			} else if(up.getUserRole().equals(UserRole.Kenttävastaava) && up.getWeekDay().equals(OnsiteDay.Sunnuntai)) {
				if(up.getStartTime().equals("08:00") && rowCounter == 4) {
					validator.updateSheet(9, 8, wb.getSheetAt(2), up);
					rowCounter++;
				} else if(up.getStartTime().equals("07:20")	&& rowCounter == 5) {
					validator.updateSheet(11, 8, wb.getSheetAt(2), up);
					rowCounter++;
				} else if(up.getStartTime().equals("12:00") && rowCounter == 6) {
					validator.updateSheet(16, 8, wb.getSheetAt(2), up);
					rowCounter++;
				} else if(up.getStartTime().equals("12:00") && rowCounter == 7) {
					validator.updateSheet(18, 8, wb.getSheetAt(2), up);
					rowCounter++;
				}
				
			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö && up.getWeekDay().equals(OnsiteDay.Lauantai)) {
				validator.updateSheet(22, 2, wb.getSheetAt(2), up);
			
			} else if(up.getUserRole() == UserRole.Kenttäpäällikkö && up.getWeekDay().equals(OnsiteDay.Sunnuntai)) {
				validator.updateSheet(22, 8, wb.getSheetAt(2), up);
				
			} else if(up.getUserRole() == UserRole.Liikenteenohjaus) {
				validator.updateSheet(31,  2, wb.getSheetAt(2), up);
				
			} else if(up.getUserRole() == UserRole.Palkintojenjako) {
				if(up.getStartTime().equals("14:20") && rowCounter == 8) {
					validator.updateSheet(31,  8, wb.getSheetAt(2), up);
					rowCounter++;
				} else if(up.getStartTime().equals("14:20") && rowCounter == 9) {
					validator.updateSheet(32,  8, wb.getSheetAt(2), up);
					rowCounter++;
				} else if(up.getStartTime().equals("12:45") && rowCounter == 10){
					validator.updateSheet(33,  8, wb.getSheetAt(2), up);
					rowCounter++;
				}
			} else if(up.getUserRole() == UserRole.Kioski && up.getWeekDay() == OnsiteDay.Lauantai) {
				if(up.getPersonInCharge().equals("Ei") && up.getStartTime().equals("08:10") && rowCounter == 11) {
					validator.updateSheet(42, 2,  wb.getSheetAt(2), up);
					rowCounter++;
				} else if(up.getPersonInCharge().equals("Ei") && up.getStartTime().equals("08:10") && rowCounter == 12) {
					validator.updateSheet(43, 2,  wb.getSheetAt(2), up);
					rowCounter++;
				} else if(up.getPersonInCharge().equals("Ei") && up.getStartTime().equals("13:30") && rowCounter == 13) {
					validator.updateSheet(45, 2,  wb.getSheetAt(2), up);
					rowCounter++;
				} else if(up.getPersonInCharge().equals("Ei") && up.getStartTime().equals("13:30") && rowCounter == 14) {
					validator.updateSheet(46, 2,  wb.getSheetAt(2), up);
					rowCounter++;
				} else if(up.getPersonInCharge().equals("Kyllä") && up.getStartTime().equals("08:10")) {
					validator.updateSheet(48, 2,  wb.getSheetAt(2), up);        							
				} else if(up.getPersonInCharge().equals("Kyllä") && up.getStartTime().equals("13:30")) {
					validator.updateSheet(49, 2,  wb.getSheetAt(2), up);
				}
								
			} else if(up.getUserRole() == UserRole.Kioski && up.getWeekDay() == OnsiteDay.Sunnuntai) {
				if(up.getPersonInCharge().equals("Ei") && up.getStartTime().equals("07:20") && rowCounter == 15) {
					validator.updateSheet(42, 8,  wb.getSheetAt(2), up);
					rowCounter++;
				} else if(up.getPersonInCharge().equals("Ei") && up.getStartTime().equals("07:20") && rowCounter == 16) {
					validator.updateSheet(43, 8,  wb.getSheetAt(2), up);
					rowCounter++;					
				} else if(up.getPersonInCharge().equals("Ei") && up.getStartTime().equals("12:00") && rowCounter == 17) {
					validator.updateSheet(45, 8,  wb.getSheetAt(2), up);
					rowCounter++;
				} else if(up.getPersonInCharge().equals("Ei") && up.getStartTime().equals("12:00") && rowCounter == 18) {
					validator.updateSheet(46, 8,  wb.getSheetAt(2), up);
					rowCounter++;
				} else if(up.getPersonInCharge().equals("Kyllä") && up.getStartTime().equals("07:20")) {
					validator.updateSheet(48, 8,  wb.getSheetAt(2), up);        							
				} else if(up.getPersonInCharge().equals("Kyllä") && up.getStartTime().equals("12:00")) {
					validator.updateSheet(49, 8,  wb.getSheetAt(2), up);
				}
			}
		}
    }
	
	private void parsePalokanKoulu(List<UserPurposeInfo> palokankoulu, HSSFWorkbook wb) {
		RowSheetValidator validator = new RowSheetValidator();
		int rowCounter = 0;
		
		for (UserPurposeInfo up : palokankoulu) {
			if(up.getWeekDay().equals(OnsiteDay.Perjantai) && up.getStartTime().equals("17:00")) {
    			if(rowCounter == 0) {
    				validator.updateSheet(10, 2, wb.getSheetAt(0), up);
    				rowCounter++;
    				
    			} else if(rowCounter == 1) {
    				validator.updateSheet(11, 2, wb.getSheetAt(0), up);
    				rowCounter++;
    			}
    		}
    		
    		if(up.getWeekDay().equals(OnsiteDay.Lauantai) && up.getPersonInCharge().equals("Ei")) {
    			if(up.getStartTime().equals("06:00") && rowCounter == 2) {
    				validator.updateSheet(17, 2, wb.getSheetAt(0), up);	
    				rowCounter++;
    			}
    			
    			if(up.getStartTime().equals("06:00") && rowCounter == 3) {
    				validator.updateSheet(18, 2, wb.getSheetAt(0), up);
    				rowCounter++;
    			}
    			
    			if(up.getStartTime().equals("11:00") && rowCounter == 4) {
    				validator.updateSheet(19, 2, wb.getSheetAt(0), up);
    				rowCounter++;
    			}
    			
    			if(up.getStartTime().equals("14:00") && rowCounter == 5) {
    				validator.updateSheet(21, 2, wb.getSheetAt(0), up);
    				rowCounter++;
    			}
    			
    			if(up.getStartTime().equals("14:00") && rowCounter == 6) {
    				validator.updateSheet(22, 2, wb.getSheetAt(0), up);
    				rowCounter++;
    			}
    			
    			if(up.getStartTime().equals("15:00") && rowCounter == 7) {
    				validator.updateSheet(23, 2, wb.getSheetAt(0), up);
    				rowCounter++;
    			}
    		}
    		
    		if(up.getWeekDay().equals(OnsiteDay.Lauantai) && up.getPersonInCharge().equals("Kyllä")) {
    			if(up.getStartTime().equals("06:00") && rowCounter == 8) {
    				validator.updateSheet(25, 2, wb.getSheetAt(0), up);	
    				rowCounter++;
    			}
    			
    			if(up.getStartTime().equals("14:00") && rowCounter == 9) {
    				validator.updateSheet(26, 2, wb.getSheetAt(0), up);
    				rowCounter++;
    			}
    		}
    		
    		if(up.getWeekDay().equals(OnsiteDay.Sunnuntai) && up.getPersonInCharge().equals("Ei")) {
    			if(up.getStartTime().equals("06:00") && rowCounter == 10) {
    				validator.updateSheet(17, 9, wb.getSheetAt(0), up);
    				rowCounter++;
    			}
    			
    			if(up.getStartTime().equals("06:00") && rowCounter == 11) {
    				validator.updateSheet(18, 9, wb.getSheetAt(0), up);
    				rowCounter++;
    			}
    			
    			if(up.getStartTime().equals("12:00") && rowCounter == 12) {
    				validator.updateSheet(21, 9, wb.getSheetAt(0), up);
    				rowCounter++;
    			}
    			
    			if(up.getStartTime().equals("12:00") && rowCounter == 13) {
    				validator.updateSheet(22, 9, wb.getSheetAt(0), up);
    				rowCounter++;
    			}
    		}
    		
    		if(up.getWeekDay().equals(OnsiteDay.Sunnuntai) && up.getPersonInCharge().equals("Kyllä")) {
    			if(up.getStartTime().equals("06:00") && rowCounter == 14) {
    				validator.updateSheet(25, 9, wb.getSheetAt(0), up);	
    				rowCounter++;
    			}
    			
    			if(up.getStartTime().equals("12:00") && rowCounter == 15) {
    				validator.updateSheet(26, 9, wb.getSheetAt(0), up);
    				rowCounter++;
    			}
    		}
		}
    }

	private void parsePalokanKentta(List<UserPurposeInfo> palokankentta, HSSFWorkbook wb) {

		RowSheetValidator validator = new RowSheetValidator();		
		int rowCounter = 0;
		
		for (UserPurposeInfo up : palokankentta) {
			if(up.getWeekDay().equals(OnsiteDay.Lauantai) && up.getUserRole() == UserRole.Kenttävastaava) {
    			if(up.getStartTime().equals("08:15")) {
					validator.updateSheet(9, 2, wb.getSheetAt(1), up);
					
    			} else if(up.getStartTime().equals("07:40")) {
					validator.updateSheet(11, 2, wb.getSheetAt(1), up);
					
    			} else if(up.getStartTime().equals("13:45") && rowCounter == 0) {
					validator.updateSheet(14, 2, wb.getSheetAt(1), up);
					rowCounter++;
    			} else if(up.getStartTime().equals("13:45") && rowCounter == 1) {
					validator.updateSheet(16, 2, wb.getSheetAt(1), up);
					rowCounter++;
    			}
    		}
    		
    		if(up.getUserRole() == UserRole.Kenttäpäällikkö && up.getWeekDay().equals(OnsiteDay.Lauantai)){
    			validator.updateSheet(20, 2, wb.getSheetAt(1), up);
    		}
    		
			if(up.getWeekDay().equals(OnsiteDay.Sunnuntai) && up.getUserRole() == UserRole.Kenttävastaava) {
    			if(up.getStartTime().equals("08:00")) {
    				validator.updateSheet(9, 8, wb.getSheetAt(1), up);
    				
    			} else if(up.getStartTime().equals("07:30")) {
    				validator.updateSheet(11, 8, wb.getSheetAt(1), up);
    				
    			} else if(up.getStartTime().equals("13:15") && rowCounter == 2) {
					validator.updateSheet(14, 8, wb.getSheetAt(1), up);
					rowCounter++;
					
    			} else if(up.getStartTime().equals("13:15") && rowCounter == 3) {
					validator.updateSheet(16, 8, wb.getSheetAt(1), up);
					rowCounter++;
    			}
			}
			
			if(up.getUserRole() == UserRole.Kenttäpäällikkö && up.getWeekDay().equals(OnsiteDay.Sunnuntai)){
				validator.updateSheet(20, 8, wb.getSheetAt(1), up);
			}
		
			if(up.getUserRole() == UserRole.Liikenteenohjaus) {
				validator.updateSheet(29,  2, wb.getSheetAt(1), up);
			}
			
			if(up.getUserRole() == UserRole.Palkintojenjako) {
				if(up.getStartTime().equals("17:15") && rowCounter == 4) {
					validator.updateSheet(29, 8, wb.getSheetAt(1), up);
					rowCounter++;
				} else if(up.getStartTime().equals("17:15") && rowCounter == 5) {
					validator.updateSheet(30, 8, wb.getSheetAt(1), up);
					rowCounter++;
				} 
			}
			
			if(up.getUserRole() == UserRole.Kioski && up.getWeekDay() == OnsiteDay.Lauantai) {
				if(up.getPersonInCharge().equals("Ei") && up.getStartTime().equals("07:40")) {
					if(rowCounter == 6) {
						validator.updateSheet(39, 2,  wb.getSheetAt(1), up);
						rowCounter++;
					} else if(rowCounter == 7) {
						validator.updateSheet(40, 2,  wb.getSheetAt(1), up);
						rowCounter++;
					}        					
				}
				
				if(up.getPersonInCharge().equals("Ei") && up.getStartTime().equals("13:45")) {
					if(rowCounter == 8) {
						validator.updateSheet(42, 2,  wb.getSheetAt(1), up);
						rowCounter++;
					} else if(rowCounter == 9) {
						validator.updateSheet(43, 2,  wb.getSheetAt(1), up);
						rowCounter++;
					}        					
				}
				
				if(up.getPersonInCharge().equals("Kyllä") && up.getStartTime().equals("07:40")) {
						validator.updateSheet(45, 2,  wb.getSheetAt(1), up);        							
				}
				
				if(up.getPersonInCharge().equals("Kyllä") && up.getStartTime().equals("13:45")) {
					validator.updateSheet(46, 2,  wb.getSheetAt(1), up);        							
				}
			}
			
			if(up.getUserRole() == UserRole.Kioski && up.getWeekDay() == OnsiteDay.Sunnuntai) {
				if(up.getPersonInCharge().equals("Ei") && up.getStartTime().equals("07:30")) {
					if(rowCounter == 10) {
						validator.updateSheet(39, 8,  wb.getSheetAt(1), up);
						rowCounter++;
					} else if(rowCounter == 11) {
						validator.updateSheet(40, 8,  wb.getSheetAt(1), up);
						rowCounter++;
					}        					
				}
				
				if(up.getPersonInCharge().equals("Ei") && up.getStartTime().equals("13:00")) {
					if(rowCounter == 12) {
						validator.updateSheet(42, 8,  wb.getSheetAt(1), up);
						rowCounter++;
					} else if(rowCounter == 13) {
						validator.updateSheet(43, 8,  wb.getSheetAt(1), up);
						rowCounter++;
					}        					
				}
				
				if(up.getPersonInCharge().equals("Kyllä") && up.getStartTime().equals("07:30")) {
						validator.updateSheet(45, 8,  wb.getSheetAt(1), up);        							
				}
				
				if(up.getPersonInCharge().equals("Kyllä") && up.getStartTime().equals("13:00")) {
					validator.updateSheet(46, 8,  wb.getSheetAt(1), up);        							
				}
			}
		}
	}
	

	private void parseMuut(List<UserPurposeInfo> muut, HSSFWorkbook wb) {
		RowSheetValidator validator = new RowSheetValidator();	
		int rowCounter = 0;
		
		for(UserPurposeInfo up : muut) {
			if(up.getUserRole() == UserRole.Yövalvonta) {
    			if(up.getWeekDay().equals(OnsiteDay.Perjantai)) {
    				if(rowCounter == 0) {
    					validator.updateSheet(10, 2, wb.getSheetAt(3), up);
    					rowCounter++;
    				}
    				if(rowCounter == 1) {
    					validator.updateSheet(11, 2, wb.getSheetAt(3), up);
    					rowCounter++;
    				}
    			}
    		}
    		
    		if(up.getUserRole() == UserRole.Yövalvonta) {
    			if(up.getWeekDay().equals(OnsiteDay.Lauantai)) {
    				if(rowCounter == 2) {
    					validator.updateSheet(10, 9, wb.getSheetAt(3), up);
    					rowCounter++;
    				}
    				
    				if(rowCounter == 3) {
    					validator.updateSheet(11, 9, wb.getSheetAt(3), up);
    					rowCounter++;
    				}
    			}
    		}
    		
    		if(up.getUserRole() == UserRole.Alkujärjestely) {
    			if(up.getWeekDay().equals(OnsiteDay.Perjantai) && up.getStartTime().equals("16:00")) {
    				if(rowCounter == 4) {
    					validator.updateSheet(23, 2, wb.getSheetAt(3), up);
    					rowCounter++;
    				} else if(rowCounter == 5) {
    					validator.updateSheet(24, 2, wb.getSheetAt(3), up);
    					rowCounter++;
    				} else if(rowCounter == 6) {
    					validator.updateSheet(25, 2, wb.getSheetAt(3), up);
    					rowCounter++;
    				} else if(rowCounter == 7){
    					validator.updateSheet(26, 2, wb.getSheetAt(3), up);
    					rowCounter++;
    				}
    			}
    			
    			if(up.getWeekDay().equals(OnsiteDay.Perjantai) && up.getStartTime().equals("16:30")) {
    				if(rowCounter == 8) {
    					validator.updateSheet(27, 2, wb.getSheetAt(3), up);
    					rowCounter++;
    				} else if(rowCounter == 9) {
    					validator.updateSheet(28, 2, wb.getSheetAt(3), up);
    					rowCounter++;
    				} else if(rowCounter == 10){
    					validator.updateSheet(29, 2, wb.getSheetAt(3), up);
    					rowCounter++;
    				}
    			}
    		}
    		
    		if(up.getUserRole() == UserRole.Loppusiivous) {
    			if(up.getWeekDay().equals(OnsiteDay.Sunnuntai) && up.getStartTime().equals("16:00")) {
    				if(rowCounter == 11) {
    					validator.updateSheet(23, 9, wb.getSheetAt(3), up);
    					rowCounter++;
    				} else if(rowCounter == 12) {
    					validator.updateSheet(24, 9, wb.getSheetAt(3), up);
    					rowCounter++;
    				} else if(rowCounter == 13) {
    					validator.updateSheet(25, 9, wb.getSheetAt(3), up);
    					rowCounter++;
    				} else if(rowCounter == 14){
    					validator.updateSheet(26, 9, wb.getSheetAt(3), up);
    					rowCounter++;
    				}
    			}
    			
    			if(up.getWeekDay().equals(OnsiteDay.Sunnuntai) && up.getStartTime().equals("16:30")) {
    				if(rowCounter == 15) {
    					validator.updateSheet(27, 9, wb.getSheetAt(3), up);
    					rowCounter++;
    				} else if(rowCounter == 16) {
    					validator.updateSheet(28, 9, wb.getSheetAt(3), up);
    					rowCounter++;
    				} else if(rowCounter == 17){
    					validator.updateSheet(29, 9, wb.getSheetAt(3), up);
    					rowCounter++;
    				}
    			}
    		}
		}
	}
}

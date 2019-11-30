package com.nousuapi.forms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetModelResource {

	int ageClass;
	double osallistumisMaksut;
	double lisenssiMaksut;
	double kenttamaksut;
	double erotuomariMaksut;
	double piiriJoukkueTapahtumat;
	double tapatumaOsallistumiset;
	double kenttaVuorot;
	double jasenMaksut;
	double tarvikkeet;
	double edustusAsut;
	double oheisHarjoitteet;
	double turnausosallistumisMaksut;
	double matkat;
	double koulutusMaksut;
	double essentials;
	double other1;
	String other1Reason;
	
	double tulotToimintaMaksut;
	double tulotTilaisuudet;
	double tulotTuotemyynnit;
	double tulotTukijat;
	double tulotOther;
	double tulotOther2;
	String otherReason2;
	double tulotOther3;
	String otherReason3;
	double tulotOther4;
	String otherReason4;
	
	String budgetFiledDate;
	String place;
	String moneyManager;
	String teamLeader;
	
	String extraFieldForNeededInfo;
}

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
	double menotTotal;
	
	double tulotToimintaMaksut;
	double tulotTilaisuudet;
	double tulotTuotemyynnit;
	double tulotTukijat;
	double tulotOther;
	double tulotTotal;
	
	String date;
	String place;
	String moneyManager;
	String teamLeader;
	
	String extraFieldForNeededInfo;
}

package com.nousuapi.forms.budget.model;


import lombok.Getter;

@Getter
public class BudgetResource {

	//kulut osio
	private double participantPament; // SPL piirisarjoihin osallistumismaksut
	private double licencePayment; // SPL lisenssimaksut
	private double arenaPayment; // Piirisajoista syntyvä sali -ja kenttämaksu
	private double refPayment; // Erotuomari -ja rajanvetomaksut ( piirisarja )
	private double eventPayment; // Piirijoukkue tapahtumat
	private double unionEventPayment; // Osallistumiset piirin ja liiton tapahtumiin
	private double hallTimesPayment; // Sali -ja kenttävuorot
	private double membershipPayment; // Seuran jäsenmaksut
	private double materialPayment; // Tarvikehankinnat
	private double gameClothesPayment; // Peli -ja edustusasut
	private double additionalEventPayment; // Oheisharjoitteet ( uinti, kuntosali )
	private double tournamentParticipantPayment; // Turnauksten osallistumismaksut
	private double tournamentAdditionalPayment; // Turnausten matka, majoitus, ruoka
	private double coatchEducationPayment; // valmentajien ja toimihenkilöiden koulutus
	private double otherpayment; // Muut kulut
	private double totalCost;
	
	//Tuotot osio
	private double actionPayment; // Toimintamaksut
	private double eventAdditionPayment; // Tuotot tilaisuuksista
	private double sellingMiscellaneous; // Tuotot arpa -ja tuotemyynnistä
	private double supporter; //tuotot tukijoista
	private double otherSupport; // muu varainhankinta ( siirto edelliseltä kaudelta )
	private double totalIncome;
	
	private String additionalinfoText;
	private String moneyManager;
	private String teamLeader;
}
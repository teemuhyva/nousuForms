package com.nousuapi.forms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionFormModel {

	private String ikäluokka;
	private String pelaajia;
	private List<Clerks> seuraHenkilöt;
	private String harjoittelu;
	private List<String> talviharjoitukset;
	private List<String> kesäharjoitukset;
	
	public ActionFormModel() {}
	
	public ActionFormModel(String ikäluokka, String pelaajia, List<Clerks> seuraHenkilöt, 
			String harjoittelu, List<String> kesäharjoitukset, List<String> talviharjoitukset) {
		this.ikäluokka = ikäluokka;
		this.pelaajia = pelaajia;
		this.seuraHenkilöt = seuraHenkilöt;
		this.harjoittelu = harjoittelu;
		this.kesäharjoitukset = kesäharjoitukset;
		this.talviharjoitukset = talviharjoitukset;
	}
}

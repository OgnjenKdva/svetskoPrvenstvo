package com.ftninformatika.jwd.modul3.test.service;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.test.model.Utakmica;

public interface UtakmicaService {
	
	Page<Utakmica>findAll(int pageNo);
	
	Utakmica findOne(Long id);
	
	Utakmica save(Utakmica utakmica);
	
	Utakmica update(Utakmica utakmica);
	
	Utakmica delete(Long id);
	
	Page<Utakmica>search(String ReprezentacijaA,String ReprezentacijaB,int pageNo);
	
	Utakmica povecajGolA(Utakmica utakmica);
	
	Utakmica povecajGolB(Utakmica utakmica);
	
	
}

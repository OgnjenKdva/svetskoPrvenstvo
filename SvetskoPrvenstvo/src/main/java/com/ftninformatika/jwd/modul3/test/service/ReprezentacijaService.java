package com.ftninformatika.jwd.modul3.test.service;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.test.model.Reprezentacija;

public interface ReprezentacijaService {

	Page<Reprezentacija>findAll(int pageNo);
	
	Reprezentacija findOne(Long id);
}

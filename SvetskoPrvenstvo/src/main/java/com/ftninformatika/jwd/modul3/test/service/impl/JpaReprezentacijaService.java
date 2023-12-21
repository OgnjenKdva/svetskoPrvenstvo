package com.ftninformatika.jwd.modul3.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.test.model.Reprezentacija;
import com.ftninformatika.jwd.modul3.test.repository.ReprezentacijaRepository;
import com.ftninformatika.jwd.modul3.test.service.ReprezentacijaService;

@Service
public class JpaReprezentacijaService implements ReprezentacijaService {
	@Autowired
	private ReprezentacijaRepository repRep;
	@Override
	public Page<Reprezentacija> findAll(int pageNo) {
		// TODO Auto-generated method stub
		return repRep.findAll(PageRequest.of(pageNo,4));
	}

	@Override
	public Reprezentacija findOne(Long id) {
		// TODO Auto-generated method stub
		return repRep.findOneById(id);
	}

}

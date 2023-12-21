package com.ftninformatika.jwd.modul3.test.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.test.model.Utakmica;
import com.ftninformatika.jwd.modul3.test.repository.UtakmicaRepository;
import com.ftninformatika.jwd.modul3.test.service.UtakmicaService;

@Service
public class JpaUtakmicaService implements UtakmicaService {

	@Autowired
	private UtakmicaRepository utkRepo;
	@Override
	public Page<Utakmica> findAll(int pageNo) {
		// TODO Auto-generated method stub
		return utkRepo.findAll(PageRequest.of(pageNo,3));
	}

	@Override
	public Utakmica findOne(Long id) {
		// TODO Auto-generated method stub
		return utkRepo.findOneById(id);
	}

	@Override
	public Utakmica save(Utakmica utakmica) {
		utakmica.setGoloviA(0);
		utakmica.setGoloviB(0);
		return utkRepo.save(utakmica);
	}

	@Override
	public Utakmica update(Utakmica utakmica) {
		// TODO Auto-generated method stub
		return utkRepo.save(utakmica);
	}

	@Override
	public Utakmica delete(Long id) {
		Optional<Utakmica> utakmica=utkRepo.findById(id);
		if (utakmica.isPresent()) {
			utkRepo.deleteById(id);
			return utakmica.get();
		}
		return null;
	}

	@Override
	public Page<Utakmica> search(String ReprezentacijaA, String ReprezentacijaB, int pageNo) {
		// TODO Auto-generated method stub
		return utkRepo.search(ReprezentacijaA, ReprezentacijaB, PageRequest.of(pageNo,3));
	}

	@Override
	public Utakmica povecajGolA(Utakmica utakmica) {
		int povecaniGolovi=utakmica.getGoloviA()+1;
		utakmica.setGoloviA(povecaniGolovi);
		return utakmica;
	}

	@Override
	public Utakmica povecajGolB(Utakmica utakmica) {
		int povecaniGolovi=utakmica.getGoloviB()+1;
		utakmica.setGoloviB(povecaniGolovi);
		return utakmica;
		
	}

}

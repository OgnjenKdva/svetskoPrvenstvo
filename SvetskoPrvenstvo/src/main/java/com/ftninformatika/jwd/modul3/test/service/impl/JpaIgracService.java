package com.ftninformatika.jwd.modul3.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.test.model.Igrac;
import com.ftninformatika.jwd.modul3.test.repository.IgracRepository;
import com.ftninformatika.jwd.modul3.test.service.IgracService;

@Service
public class JpaIgracService implements IgracService {

	@Autowired
	private IgracRepository igrRepo;
	@Override
	public Page<Igrac> findAll(int pageNo) {
		// TODO Auto-generated method stub
		return igrRepo.findAll(PageRequest.of(pageNo,3));
	}

	@Override
	public Igrac findOne(Long id) {
		// TODO Auto-generated method stub
		return igrRepo.findOneById(id);
	}

	@Override
	public List<Igrac> find(List<Long> ids) {
		// TODO Auto-generated method stub
		return igrRepo.findByIdIn(ids);
	}

	@Override
	public Igrac najboljiIgrac() {
		List <Igrac>igraci=igrRepo.findAll();
		Igrac najboljiIgrac = null;
		for(Igrac igrac:igraci) {
			if(najboljiIgrac == null || igrac.getPostignutiGolovi()>=najboljiIgrac.getPostignutiGolovi()) {
				najboljiIgrac=igrac;
			}
		}
		return najboljiIgrac;
	}

	@Override
	public List<Igrac> getByRepId(Long id) {
		
		return igrRepo.getByReprezentacijaId(id);
	}

	@Override
	public Igrac golPlus(Long id) {
		Igrac igrac=igrRepo.findOneById(id);
		int golPlus=igrac.getPostignutiGolovi()+1;
		igrac.setPostignutiGolovi(golPlus);
		return igrac;
	}

}

package com.ftninformatika.jwd.modul3.test.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.test.model.Igrac;

public interface IgracService {
	Page<Igrac>findAll(int pageNo);
	
	Igrac findOne(Long id);
	
	List<Igrac>find(List<Long>ids);
	
	Igrac najboljiIgrac();
	
	List<Igrac>getByRepId(Long id);
	
	Igrac golPlus(Long id);

}

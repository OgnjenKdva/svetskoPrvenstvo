package com.ftninformatika.jwd.modul3.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.test.model.Igrac;

@Repository
public interface IgracRepository extends JpaRepository<Igrac, Long> {
	
	Igrac findOneById(Long id);
	
	List<Igrac>findByIdIn(List<Long>ids);
	
	List<Igrac>getByReprezentacijaId(Long id);

}

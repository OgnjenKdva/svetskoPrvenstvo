package com.ftninformatika.jwd.modul3.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.test.model.Reprezentacija;

@Repository
public interface ReprezentacijaRepository extends JpaRepository<Reprezentacija, Long> {

	Reprezentacija findOneById(Long id);
	
}

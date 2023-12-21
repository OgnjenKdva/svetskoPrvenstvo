package com.ftninformatika.jwd.modul3.test.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.test.model.Utakmica;

@Repository
public interface UtakmicaRepository extends JpaRepository<Utakmica, Long>{
	
	Utakmica findOneById(Long id);
	
	@Query("SELECT u FROM Utakmica u WHERE"
			+ "(:ReprezentacijaA IS NULL OR u.reprezentacijaA.naziv LIKE %:ReprezentacijaA%)AND"
			+ "(:ReprezentacijaB IS NULL OR u.reprezentacijaB.naziv LIKE %:ReprezentacijaB%)")
	Page<Utakmica>search(
			@Param ("ReprezentacijaA") String ReprezentacijaA,
			@Param("ReprezentacijaB") String ReprezentacijaB,
			Pageable pageable);
	
	
	

}

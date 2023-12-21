package com.ftninformatika.jwd.modul3.test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.test.model.Utakmica;
import com.ftninformatika.jwd.modul3.test.service.UtakmicaService;
import com.ftninformatika.jwd.modul3.test.support.UtakmicaDtoToUtakmica;
import com.ftninformatika.jwd.modul3.test.support.UtakmicaToUtakmicaDto;
import com.ftninformatika.jwd.modul3.test.web.dto.UtakmicaDTO;

@RestController
@RequestMapping(value = "/api/utakmice", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class UtakmicaController {
	
	@Autowired
	private UtakmicaService utkService;
	
	@Autowired
	private UtakmicaToUtakmicaDto toDto;
	
	@Autowired
	private UtakmicaDtoToUtakmica toUtakmica;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtakmicaDTO>create(@Valid @RequestBody UtakmicaDTO utakmicaDTO){
		Utakmica utakmica=toUtakmica.convert(utakmicaDTO);
		
		if(utakmica.getReprezentacijaA()==utakmica.getReprezentacijaB()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(utakmica.getReprezentacijaA()==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(utakmica.getReprezentacijaB()==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Utakmica sacuvanaUtakmica=utkService.save(utakmica);
		return new ResponseEntity<>(toDto.convert(sacuvanaUtakmica),HttpStatus.CREATED);
		}
	@PutMapping(value="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtakmicaDTO>update(@PathVariable Long id,@Valid @RequestBody UtakmicaDTO utakmicaDTO){
		
		
		if(!id.equals(utakmicaDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Utakmica utakmica=toUtakmica.convert(utakmicaDTO);
		
		if(utakmica.getReprezentacijaA()==utakmica.getReprezentacijaB()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(utakmica.getReprezentacijaA()==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(utakmica.getReprezentacijaB()==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Utakmica sacuvanaUtakmica=utkService.update(utakmica);
		return new ResponseEntity<>(toDto.convert(sacuvanaUtakmica),HttpStatus.OK);
		}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){
		Utakmica obrisanaUtakmica=utkService.delete(id);
		if(obrisanaUtakmica==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<UtakmicaDTO>getOne(@PathVariable Long id){
		Utakmica utakmica=utkService.findOne(id);
		
		if(utakmica!=null) {
			return new ResponseEntity<>(toDto.convert(utakmica),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping
	public ResponseEntity<List<UtakmicaDTO>>getAll(
			@RequestParam(required=false)String ReprezentacijaA,
			@RequestParam(required=false)String ReprezentacijaB,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
		Page<Utakmica>page;
		page=utkService.search(ReprezentacijaA, ReprezentacijaB, pageNo);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toDto.convert(page.getContent()),headers,HttpStatus.OK);
	}
	
			

}

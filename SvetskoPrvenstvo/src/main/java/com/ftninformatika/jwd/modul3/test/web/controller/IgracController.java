package com.ftninformatika.jwd.modul3.test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.test.model.Igrac;

import com.ftninformatika.jwd.modul3.test.service.IgracService;
import com.ftninformatika.jwd.modul3.test.support.IgracToIgracDto;
import com.ftninformatika.jwd.modul3.test.web.dto.IgracDTO;
import com.mysql.fabric.Response;


@RestController
@RequestMapping(value = "/api/igraci", produces = MediaType.APPLICATION_JSON_VALUE)
public class IgracController {
	
	@Autowired
	private IgracToIgracDto toDto;
	
	@Autowired
	private IgracService igracService;
	
	@GetMapping
	public ResponseEntity<List<IgracDTO>>getAll(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
		
		Page<Igrac>page=igracService.findAll(pageNo);
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Total-pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toDto.convert(page.getContent()),headers,HttpStatus.OK);
	}
	
	@GetMapping(value="/najboljiIgrac")
	public ResponseEntity<IgracDTO>bestStriker(){
		Igrac najboljiIgrac=igracService.najboljiIgrac();
		return new ResponseEntity<>(toDto.convert(najboljiIgrac),HttpStatus.OK);
	}
	
	@GetMapping(value="/reprezentacije/{id}")
	public ResponseEntity<List<IgracDTO>>getAllByReprezentacijaId(@PathVariable Long id){
		List<Igrac>igraci=igracService.getByRepId(id);
		return new ResponseEntity<>(toDto.convert(igraci),HttpStatus.OK);
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<IgracDTO>dodajGol(@PathVariable Long id){
		Igrac igrac=igracService.golPlus(id);
		return new ResponseEntity<>(toDto.convert(igrac),HttpStatus.OK);
	}
	

}

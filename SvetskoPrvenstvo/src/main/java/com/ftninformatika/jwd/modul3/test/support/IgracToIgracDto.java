package com.ftninformatika.jwd.modul3.test.support;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.model.Igrac;
import com.ftninformatika.jwd.modul3.test.service.IgracService;
import com.ftninformatika.jwd.modul3.test.web.dto.IgracDTO;

@Component
public class IgracToIgracDto implements Converter<Igrac, IgracDTO>{

	@Autowired
	private IgracService igracService;
	
	@Autowired
	private ReprezentacijaToReprezentacijaDto toRepDto;
	@Override
	public IgracDTO convert(Igrac igrac) {
		IgracDTO dto=new IgracDTO();
		dto.setId(igrac.getId());
		dto.setIme(igrac.getIme());
		dto.setPrezime(igrac.getPrezime());
		dto.setPostignutiGolovi(igrac.getPostignutiGolovi());
		dto.setReprezentacija(toRepDto.convert(igrac.getReprezentacija()));
		return dto;
	}
	public List<IgracDTO>convert(List<Igrac> igraci){
		List<IgracDTO>dtos=new ArrayList<>();
		for(Igrac igrac:igraci) {
			dtos.add(convert(igrac));
		}
		return dtos;
	}

}

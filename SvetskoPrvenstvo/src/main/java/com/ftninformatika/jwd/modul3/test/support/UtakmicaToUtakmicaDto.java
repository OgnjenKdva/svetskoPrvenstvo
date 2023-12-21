package com.ftninformatika.jwd.modul3.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.model.Utakmica;
import com.ftninformatika.jwd.modul3.test.service.ReprezentacijaService;
import com.ftninformatika.jwd.modul3.test.web.dto.UtakmicaDTO;

@Component
public class UtakmicaToUtakmicaDto implements Converter<Utakmica, UtakmicaDTO> {

	@Autowired
	private ReprezentacijaService repService;
	
	@Autowired
	private ReprezentacijaToReprezentacijaDto toRepDto;
	@Override
	public UtakmicaDTO convert(Utakmica utakmica) {
		UtakmicaDTO dto=new UtakmicaDTO();
		dto.setId(utakmica.getId());
		dto.setGoloviA(utakmica.getGoloviA());
		dto.setGoloviB(utakmica.getGoloviB());
		dto.setReprezentacijaA(toRepDto.convert(utakmica.getReprezentacijaA()));
		dto.setReprezentacijaB(toRepDto.convert(utakmica.getReprezentacijaB()));
		return dto;
	}
	public List<UtakmicaDTO>convert(List<Utakmica>tekme){
		List<UtakmicaDTO>dtos=new ArrayList<>();
		for(Utakmica utak:tekme) {
			dtos.add(convert(utak));
		}
		return dtos;
	}

}

package com.ftninformatika.jwd.modul3.test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.model.Utakmica;
import com.ftninformatika.jwd.modul3.test.service.ReprezentacijaService;
import com.ftninformatika.jwd.modul3.test.service.UtakmicaService;
import com.ftninformatika.jwd.modul3.test.web.dto.UtakmicaDTO;

@Component
public class UtakmicaDtoToUtakmica implements Converter<UtakmicaDTO, Utakmica> {

	@Autowired
	private UtakmicaService utakmicaService;
	
	@Autowired
	private ReprezentacijaService repService;
	
	@Override
	public Utakmica convert(UtakmicaDTO dto) {
		Utakmica utakmica;
		if(dto.getId()==null) {
			utakmica=new Utakmica();
		}else {
			utakmica=utakmicaService.findOne(dto.getId());
		}
		if(utakmica!=null) {
			utakmica.setGoloviA(dto.getGoloviA());
			utakmica.setGoloviB(dto.getGoloviB());
			utakmica.setReprezentacijaA(repService.findOne(dto.getReprezentacijaA().getId()));
			utakmica.setReprezentacijaB(repService.findOne(dto.getReprezentacijaB().getId()));
			
		}
		return utakmica;
	}

}

package com.ftninformatika.jwd.modul3.test.support;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.model.Igrac;
import com.ftninformatika.jwd.modul3.test.model.Reprezentacija;
import com.ftninformatika.jwd.modul3.test.web.dto.ReprezentacijaDTO;

@Component
public class ReprezentacijaToReprezentacijaDto implements Converter<Reprezentacija, ReprezentacijaDTO>{

	@Override
	public ReprezentacijaDTO convert(Reprezentacija reprezentacija) {
		ReprezentacijaDTO dto=new ReprezentacijaDTO();
		dto.setId(reprezentacija.getId());
		dto.setNaziv(reprezentacija.getNaziv());
		dto.setSkraceniNaziv(reprezentacija.getSkraceniNaziv());
		LinkedHashMap<Long, String>igraci=new LinkedHashMap<>();
		for(Igrac igrac:reprezentacija.getIgraci()) {
			igraci.put(igrac.getId(), igrac.getPrezime());
		}
		dto.setIgraci(igraci);
		return dto;
	}

	public List<ReprezentacijaDTO>convert(List<Reprezentacija>repke){
		List<ReprezentacijaDTO>dtos=new ArrayList<>();
		for(Reprezentacija rep:repke) {
			dtos.add(convert(rep));
		}
		return dtos;
	}

}

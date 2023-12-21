package com.ftninformatika.jwd.modul3.test.web.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ReprezentacijaDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	@NotEmpty
	private String naziv;
	@Size(min = 3, max=3)
	private String skraceniNaziv;
	
	private Map<Long,String>igraci=new LinkedHashMap<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}

	public Map<Long, String> getIgraci() {
		return igraci;
	}

	public void setIgraci(Map<Long, String> igraci) {
		this.igraci = igraci;
	}

	public ReprezentacijaDTO() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReprezentacijaDTO other = (ReprezentacijaDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ReprezentacijaDTO [id=" + id + ", naziv=" + naziv + ", skraceniNaziv=" + skraceniNaziv + ", igraci="
				+ igraci + "]";
	}
	
	
	
}

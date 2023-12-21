package com.ftninformatika.jwd.modul3.test.web.dto;

import java.util.Objects;

import javax.validation.constraints.Positive;

public class IgracDTO {
	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	private String ime;
	
	private String prezime;
	
	private int postignutiGolovi;
	
	private ReprezentacijaDTO reprezentacija;

	public IgracDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getPostignutiGolovi() {
		return postignutiGolovi;
	}

	public void setPostignutiGolovi(int postignutiGolovi) {
		this.postignutiGolovi = postignutiGolovi;
	}

	public ReprezentacijaDTO getReprezentacija() {
		return reprezentacija;
	}

	public void setReprezentacija(ReprezentacijaDTO reprezentacija) {
		this.reprezentacija = reprezentacija;
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
		IgracDTO other = (IgracDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "IgracDTO [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", postignutiGolovi=" + postignutiGolovi
				+ ", reprezentacija=" + reprezentacija + "]";
	}
	
	
}

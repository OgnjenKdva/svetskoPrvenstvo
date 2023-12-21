package com.ftninformatika.jwd.modul3.test.web.dto;

import java.util.Objects;

import javax.validation.constraints.Positive;

import org.springframework.lang.Nullable;

public class UtakmicaDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	private ReprezentacijaDTO reprezentacijaA;
	
	private ReprezentacijaDTO reprezentacijaB;
	@Nullable
	private int goloviA;
	@Nullable
	private int goloviB;

	public Long getId() {
		return id;
	}	
	public UtakmicaDTO() {
		super();
	}
	public void setId(Long id) {
		this.id = id;
	}

	public ReprezentacijaDTO getReprezentacijaA() {
		return reprezentacijaA;
	}

	public void setReprezentacijaA(ReprezentacijaDTO reprezentacijaA) {
		this.reprezentacijaA = reprezentacijaA;
	}

	public ReprezentacijaDTO getReprezentacijaB() {
		return reprezentacijaB;
	}

	public void setReprezentacijaB(ReprezentacijaDTO reprezentacijaB) {
		this.reprezentacijaB = reprezentacijaB;
	}

	public int getGoloviA() {
		return goloviA;
	}

	public void setGoloviA(int goloviA) {
		this.goloviA = goloviA;
	}

	public int getGoloviB() {
		return goloviB;
	}

	public void setGoloviB(int goloviB) {
		this.goloviB = goloviB;
	}

	public UtakmicaDTO(@Positive(message = "Id mora biti pozitivan broj.") Long id) {
		super();
		this.id = id;
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
		UtakmicaDTO other = (UtakmicaDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "UtakmicaDTO [id=" + id + ", reprezentacijaA=" + reprezentacijaA + ", reprezentacijaB=" + reprezentacijaB
				+ ", goloviA=" + goloviA + ", goloviB=" + goloviB + "]";
	}
	
	
}

package com.ftninformatika.jwd.modul3.test.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Utakmica {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	private Reprezentacija reprezentacijaB;
	
	@ManyToOne
	private Reprezentacija reprezentacijaA;
	
	@Column
	private int goloviA;
	
	@Column
	private int goloviB;

	public Utakmica() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Reprezentacija getReprezentacijaB() {
		return reprezentacijaB;
	}

	public void setReprezentacijaB(Reprezentacija reprezentacijaB) {
		this.reprezentacijaB = reprezentacijaB;
	}

	public Reprezentacija getReprezentacijaA() {
		return reprezentacijaA;
	}

	public void setReprezentacijaA(Reprezentacija reprezentacijaA) {
		this.reprezentacijaA = reprezentacijaA;
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
		Utakmica other = (Utakmica) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Utakmica [id=" + id + ", reprezentacijaB=" + reprezentacijaB + ", reprezentacijaA=" + reprezentacijaA
				+ ", goloviA=" + goloviA + ", goloviB=" + goloviB + "]";
	}
	
	
	
}

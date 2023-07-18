package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Semestre {
	@GeneratedValue(generator = "seq_semestre",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_semestre",sequenceName ="seq_semestre",allocationSize = 1 )
	@Id
	@Column(name="seme_id")
	private Integer id;
	
	@Column(name="seme_numero")
	private String numero;
	
	@Column(name="seme_periodo")
	private String periodo;
	
	@Column(name="seme_nombre_carrera")
	private String nombreCarrera;
	
	@OneToMany(mappedBy = "semestre",cascade = CascadeType.ALL)
	private List<Materia> materias;

	
	
	@Override
	public String toString() {
		return "Semestre [id=" + id + ", numero=" + numero + ", periodo=" + periodo + ", nombreCarrera=" + nombreCarrera
				+ "]";
	}

	//SET Y GETS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	
	
	

}

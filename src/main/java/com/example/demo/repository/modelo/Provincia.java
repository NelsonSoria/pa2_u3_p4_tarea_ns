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
public class Provincia {
	@GeneratedValue(generator = "seq_provincia",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_provincia",sequenceName ="seq_provincia",allocationSize = 1 )
	@Id
	@Column(name="prov_id")
	private Integer id;
	
	@Column(name="prov_nombre")
	private String nombre;
	
	@Column(name="prov_codigo")
	private String codigo;
	
	@Column(name="prov_region")
	private String region;

	@OneToMany(mappedBy = "provincia",cascade = CascadeType.ALL)
	private List<Estudiante> estudiantes;

	//SETS Y GETS
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", region=" + region + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	
}

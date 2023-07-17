package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Persona {
	@GeneratedValue(generator = "seq_persona",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_persona",sequenceName ="seq_persona",allocationSize = 1 )
	@Id
	@Column(name="pers_id")
	private Integer id;
	@Column(name="pers_nombre")
	private String nombre;
	@Column(name="pers_edad")
	private String edad;
	
	@OneToMany(mappedBy = "persona",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Factura> facturas;

	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", facturas=" + facturas + "]";
	}

	public Integer getId() {
		return id;
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

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	
	

}

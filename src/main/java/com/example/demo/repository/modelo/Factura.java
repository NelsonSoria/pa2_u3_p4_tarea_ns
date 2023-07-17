package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Factura {
	
	@GeneratedValue(generator = "seq_factura",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_factura",sequenceName ="seq_factura",allocationSize = 1 )
	@Id
	@Column(name="fact_id")
	private Integer id;
	
	@Column(name="fact_fecha")
	private LocalDate fecha;
	
	@Column(name="fact_descripcion")
	private String descripcion;
	
	@Column(name="fact_precio_total")
	private BigDecimal precioTotal;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fact_pers_id")
	private Persona persona;

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", descripcion=" + descripcion + ", precioTotal="
				+ precioTotal + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(BigDecimal precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	

}

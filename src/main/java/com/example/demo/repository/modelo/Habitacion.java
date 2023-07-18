package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.Transient;

@Entity
@Table(name = "habitacion")
public class Habitacion {

	@GeneratedValue(generator = "seq_habitacion",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_habitacion",sequenceName ="seq_habitacion",allocationSize = 1 )
	@Id
	@Column(name="habi_id")
	private Integer id;
	@Column(name="habi_numero")
	private String numero;
	@Column(name="habi_valor")
	private BigDecimal valor; 
	
	@Transient
	private BigDecimal valorIncluidoIva;
	
	@ManyToOne
	@JoinColumn(name = "habi_id_hotel")
	private Hotel hotel;

	//set y get
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", numero=" + numero + ", valor=" + valor + ", hotel=" + hotel + "]";
	}

	public BigDecimal getValorIncluidoIva() {
		return valorIncluidoIva;
	}

	public void setValorIncluidoIva(BigDecimal valorIncluidoIva) {
		this.valorIncluidoIva = valorIncluidoIva;
	}
	
	
}
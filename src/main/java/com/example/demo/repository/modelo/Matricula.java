package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Matricula {
	@GeneratedValue(generator = "seq_matricula",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_matricula",sequenceName ="seq_matricula",allocationSize = 1 )
	@Id
	@Column(name="matr_id")
	private Integer id;
	
	@Column(name="matr_numero")
	private String numero;
	
	@Column(name="matr_fecha")
	private LocalDate fecha;
	
	@Column(name="matr_valor")
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name="matr_estu_id")
	private Estudiante estudiante;
	
	@ManyToOne
	@JoinColumn(name="matr_mate_id")
	private Materia materia;

	//SETS Y GETS
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", valor=" + valor + ", estudiante="
				+ estudiante + ", materia=" + materia + "]";
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	

	
}

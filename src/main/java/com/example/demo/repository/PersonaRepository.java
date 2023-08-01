package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.repository.modelo.Persona;

public interface PersonaRepository {
	public void insertar(Persona persona);
	public void eliminar(Integer id);
	public Persona seleccionarPorID(Integer id);
	public void actualizar(Persona persona);
		
	public List<Persona> seleccionarInnerJoin();
	public List<Persona> seleccionarOuterRightJoin();
	public List<Persona> seleccionarOuterLeftJoin();
	public List<Persona> seleccionarOuterFullJoin();
	public List<Persona> seleccionarJoinWhere();
	public List<Persona> seleccionarJoinFech();

}
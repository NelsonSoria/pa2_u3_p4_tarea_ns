package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.repository.modelo.Persona;

public interface PersonaService {
	public void gusrdar(Persona persona);
	public void borrar(Integer id);
	public Persona buscarPorID(Integer id);
	public void actualizar(Persona persona);
	
	public List<Persona> buscarInnerJoin();
	public List<Persona> buscarOuterRightJoin();
	public List<Persona> buscarOuterLeftJoin();
	public List<Persona> buscarOuterFullJoin();
	public List<Persona> buscarJoinWhere();
	public List<Persona> buscarJoinFetch();
}

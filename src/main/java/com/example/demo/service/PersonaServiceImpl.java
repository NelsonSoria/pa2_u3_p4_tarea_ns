package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PersonaRepository;
import com.example.demo.repository.modelo.Persona;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaRepository personaRepository;
	@Override
	public void gusrdar(Persona persona) {
		this.personaRepository.insertar(persona);
		
	}

	@Override
	public void borrar(Integer id) {
		this.personaRepository.eliminar(id);
		
	}

	@Override
	public Persona buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.personaRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.personaRepository.actualizar(persona);
	}

	@Override
	public List<Persona> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.personaRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Persona> buscarOuterRightJoin() {
		// TODO Auto-generated method stub
		return this.personaRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<Persona> buscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.personaRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Persona> buscarOuterFullJoin() {
		// TODO Auto-generated method stub
		return this.personaRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Persona> buscarJoinWhere() {
		// TODO Auto-generated method stub
		return this.personaRepository.seleccionarJoinWhere();
	}

	@Override
	public List<Persona> buscarJoinFetch() {
		// TODO Auto-generated method stub
		return this.personaRepository.seleccionarJoinFech();
	}

	
	
	

}

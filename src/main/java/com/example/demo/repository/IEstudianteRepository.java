package com.example.demo.repository;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	public void insertar(Estudiante estudiante);
	public void eliminar(Integer id);
	public Estudiante seleccionarPorID(Integer id);
	public void actualizar(Estudiante estudiante);
	
	public Estudiante seleccionarPorCedula(String cedula);
}

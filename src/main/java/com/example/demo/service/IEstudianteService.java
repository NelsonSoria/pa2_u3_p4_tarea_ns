package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.repository.modelo.Estudiante;


public interface IEstudianteService {
	
	public void guardar(Estudiante estudiante);
	public CompletableFuture<Integer> calcularEdad(String cedula);
	

}

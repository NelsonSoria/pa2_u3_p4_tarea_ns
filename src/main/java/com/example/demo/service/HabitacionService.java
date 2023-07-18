package com.example.demo.service;


import com.example.demo.repository.modelo.Habitacion;


public interface HabitacionService {
	public void guardar(Habitacion habitacion);
	public void borrar(Integer id);
	public Habitacion buscarPorID(Integer id);
	public void actualizar(Habitacion habitacion);

}

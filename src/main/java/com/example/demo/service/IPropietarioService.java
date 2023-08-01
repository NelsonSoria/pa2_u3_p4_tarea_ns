package com.example.demo.service;

import com.example.demo.repository.modelo.Propietario;

public interface IPropietarioService {
	public void guardar(Propietario propietario);
	public void borrar(Integer id);
	public Propietario buscarPorId(Integer id);
	public void actualizar(Propietario propietario);

}

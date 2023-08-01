package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.repository.modelo.Transferencia;

public interface ITransferenciaRepository {
	public void insertar(Transferencia transferencia);
	public void eliminar(Integer id);
	public Transferencia seleccionarPorId(Integer id);
	public void actualizar(Transferencia transferencia);
	
	public List<Transferencia> seleccionarTodos();

}

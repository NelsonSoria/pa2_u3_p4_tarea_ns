package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPropietarioRepository;
import com.example.demo.repository.modelo.Propietario;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired
	private IPropietarioRepository iPropietarioRepository;
	
	@Override
	public void guardar(Propietario propietario) {
		this.iPropietarioRepository.insertar(propietario);
		
	}

	@Override
	public void borrar(Integer id) {
		this.iPropietarioRepository.eliminar(id);
		
	}

	@Override
	public Propietario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iPropietarioRepository.seleccionarPorId(id);
	}

	@Override
	public void actualizar(Propietario propietario) {
		this.iPropietarioRepository.actualizar(propietario);
		
	}

}

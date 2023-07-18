package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProvinciaRepository;
import com.example.demo.repository.modelo.Provincia;



@Service
public class ProvinciaServiceImpl implements IProvinciaService{

	@Autowired
	private IProvinciaRepository iProvinciaRepository;
	
	@Override
	public void guardar(Provincia provincia) {
		this.iProvinciaRepository.insertar(provincia);
		
	}

}

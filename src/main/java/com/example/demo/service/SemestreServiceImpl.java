package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ISemestreRepository;
import com.example.demo.repository.modelo.Semestre;


@Service
public class SemestreServiceImpl implements ISemestreService{

	@Autowired
	private ISemestreRepository iSemestreRepository;
	
	@Override
	public void guardar(Semestre semestre) {
		this.iSemestreRepository.insertar(semestre);
	}

}

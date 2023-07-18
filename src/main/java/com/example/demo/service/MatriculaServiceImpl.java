package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements IMatriculaService{
	
	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	
	@Autowired
	private IMateriaRepository iMateriaRepository;
	
	@Autowired
	private IEstudianteRepository iestudianteRepository;

	@Override
	public void matricular(String cedulaEstudiante, List<String> codigosMateria) {
		
		Estudiante miEstudiante =this.iestudianteRepository.seleccionarPorCedula(cedulaEstudiante);
		
		for(String codigo:codigosMateria) {
			Materia miMateria =new Materia();
			miMateria =this.iMateriaRepository.seleccionarPorCodigo(codigo);
			
			Matricula miMatricula=new Matricula();
			miMatricula.setFecha(LocalDate.now());
			Random r = new Random();
			Integer numRandom = r.nextInt(100)+1;
			miMatricula.setNumero(numRandom.toString());
			miMatricula.setValor(BigDecimal.valueOf(100));
			miMatricula.setEstudiante(miEstudiante);
			miMatricula.setMateria(miMateria);
			this.iMatriculaRepository.insertar(miMatricula);
		}

	}

}

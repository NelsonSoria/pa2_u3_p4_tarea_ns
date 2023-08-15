package com.example.demo.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
	private static final Logger LOG = LoggerFactory.getLogger(EstudianteServiceImpl.class);
	@Autowired
	IEstudianteRepository estudianteRepository;
	
	@Override
	public void guardar(Estudiante estudiante) {
		this.estudianteRepository.insertar(estudiante);
		
	}

	@Override
	@Async
	public CompletableFuture<Integer> calcularEdad(String cedula) {
		LOG.info("Hilo Service. " + Thread.currentThread().getName()); 
        try {
        	TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Estudiante e=this.estudianteRepository.seleccionarPorCedula(cedula);
        LocalDate fechaNacimiento= e.getFechaNacimiento();
        LocalDate fechaActual=LocalDate.now();
        int edad= Period.between(fechaNacimiento, fechaActual).getYears();
    
        
		return CompletableFuture.completedFuture(edad);
	}

}

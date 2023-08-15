package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P4T2areaNsApplication implements CommandLineRunner{
	
	@Autowired
	IEstudianteService estudianteService;
	
	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4T2areaNsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4T2areaNsApplication.class, args);
	}

	//METODO Para generar fechas random
	public static LocalDate generadorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        long diaInicio = fechaInicio.toEpochDay();
        long diaFin = fechaFin.toEpochDay();

        long random = ThreadLocalRandom.current().nextLong(diaInicio, diaFin + 1);

        return LocalDate.ofEpochDay(random);
    }
	
	@Override
	public void run(String... args) throws Exception {
		
		String [] cedulas= new String [] {
				"121","122","123","124","125","126","127","128","129","130"
		};
		
		LocalDate fechaInicio = LocalDate.of(1980, 1, 1); 
        LocalDate fechaFin = LocalDate.of(2005, 12, 31);
        
        for(int i=0;i<10;i++) {
        	Estudiante e= new Estudiante();
        	e.setNombre("Nelson");
        	e.setApellido("Soria");
        	e.setCedula(cedulas[i]);
        	e.setFechaNacimiento(generadorFecha(fechaInicio,fechaFin));
        	//this.estudianteService.guardar(e);
        }
        
        LOG.info("Hilo Main: " + Thread.currentThread().getName());

		long tiempoInicial = System.currentTimeMillis();
		
        List<CompletableFuture<Integer>> listaRespuestasEdades= new ArrayList<>();
        for(int i=0;i<10;i++) {	
        	CompletableFuture<Integer> respuestaEdad=this.estudianteService.calcularEdad(cedulas[i]);
        	listaRespuestasEdades.add(respuestaEdad);
        }
        
        CompletableFuture<Void> future =CompletableFuture.allOf(listaRespuestasEdades.get(0),listaRespuestasEdades.get(1),listaRespuestasEdades.get(2),listaRespuestasEdades.get(3),listaRespuestasEdades.get(4),
				listaRespuestasEdades.get(5),listaRespuestasEdades.get(6),listaRespuestasEdades.get(7),listaRespuestasEdades.get(8),listaRespuestasEdades.get(9));
        future.get();
        
        double sumEdad=0.0;
        
        for(CompletableFuture<Integer> f:listaRespuestasEdades ) {
        	sumEdad += f.get();
        }
        LOG.info("Promedio de Edades:"+ sumEdad/10);
        
        LOG.info("Respuesta 0:"+ listaRespuestasEdades.get(0).get());
		LOG.info("Respuesta 0:"+ listaRespuestasEdades.get(1).get());
		LOG.info("Respuesta 0:"+ listaRespuestasEdades.get(2).get());
		LOG.info("Respuesta 0:"+ listaRespuestasEdades.get(3).get());
		LOG.info("Respuesta 0:"+ listaRespuestasEdades.get(4).get());
		LOG.info("Respuesta 0:"+ listaRespuestasEdades.get(5).get());
		LOG.info("Respuesta 0:"+ listaRespuestasEdades.get(6).get());
		LOG.info("Respuesta 0:"+ listaRespuestasEdades.get(7).get());
		LOG.info("Respuesta 0:"+ listaRespuestasEdades.get(8).get());
		LOG.info("Respuesta 0:"+ listaRespuestasEdades.get(9).get());
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiempo transcurrido: " + tiempoTranscurrido);
		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));

		LOG.info("Se termino de procesar todo ");
		
	}

}
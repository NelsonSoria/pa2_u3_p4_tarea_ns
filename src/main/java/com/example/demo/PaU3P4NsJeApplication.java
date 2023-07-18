package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.IProvinciaRepository;
import com.example.demo.repository.ISemestreRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Provincia;
import com.example.demo.repository.modelo.Semestre;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.IMatriculaService;
import com.example.demo.service.IProvinciaService;
import com.example.demo.service.ISemestreService;

@SpringBootApplication
public class PaU3P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService iMateriaService;
	
	@Autowired
	private IMatriculaService iMatriculaService;
	
	@Autowired
	private IProvinciaService iProvinciaService;
	
	@Autowired
	private ISemestreService iSemestreService;

	public static void main(String[] args) {
		SpringApplication.run(PaU3P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<String> codigos = new ArrayList<>();
		codigos.add("M01");
		codigos.add("P002");
		codigos.add("A001");
		this.iMatriculaService.matricular("126", codigos);
		
		//Insercion de Datos
		Provincia prov1 = new Provincia();
		prov1.setCodigo("17");
		prov1.setNombre("Pichincha");
		prov1.setRegion("Sierra");
		
	
		Estudiante estu1 = new Estudiante();
		estu1.setApellido("Soria");
		estu1.setCedula("123");
		estu1.setNombre("Nelson");
		estu1.setProvincia(prov1);
		
		//this.estudianteService.guardar(estu1);
		
		Provincia prov3 = new Provincia();
		prov3.setCodigo("15");
		prov3.setNombre("Esmeraldas");
		prov3.setRegion("Costa");
		
		Estudiante estu3 = new Estudiante();
		estu3.setApellido("Alvarez");
		estu3.setCedula("126");
		estu3.setNombre("Patricio");
		estu3.setProvincia(prov3);
		
		Estudiante estu4 = new Estudiante();
		estu4.setApellido("Santillan");
		estu4.setCedula("127");
		estu4.setNombre("Andy");
		estu4.setProvincia(prov3);
		
		Estudiante estu5 = new Estudiante();
		estu5.setApellido("Enriquez");
		estu5.setCedula("128");
		estu5.setNombre("Jeremy");
		estu5.setProvincia(prov3);
		
		List<Estudiante> miLista= new ArrayList<>();
		miLista.add(estu5);
		miLista.add(estu4);
		miLista.add(estu3);
		
		prov3.setEstudiantes(miLista);
		//this.iProvinciaService.guardar(prov3);
		
		
		Semestre s = new Semestre();
		s.setNumero("5");
		s.setPeriodo("2020-2021");
		s.setNombreCarrera("Computacion");
		
		Materia m1 = new Materia();
		m1.setCodigo("M01");
		m1.setNombre("Matematicas");
		m1.setNombreProfesor("Julio Profe");
		m1.setSemestre(s);
		
		Semestre s1 = new Semestre();
		s1.setNumero("7");
		s1.setPeriodo("2020-2022");
		s1.setNombreCarrera("Filosofia");
		
		
		Materia m2 = new Materia();
		m2.setCodigo("L001");
		m2.setNombre("Lengua");
		m2.setNombreProfesor("Davicho");
		m2.setSemestre(s1);
		//this.iMateriaService.guardar(m1);
		//this.iMateriaService.guardar(m2);
		
		
		Semestre s3 = new Semestre();
		s3.setNumero("9");
		s3.setPeriodo("2022-2023");
		s3.setNombreCarrera("Computacion");
		
		Materia m4 = new Materia();
		m4.setCodigo("A001");
		m4.setNombre("Algebra");
		m4.setNombreProfesor("Oscar");
		m4.setSemestre(s3);
		
		Materia m5 = new Materia();
		m5.setCodigo("P002");
		m5.setNombre("Programacion");
		m5.setNombreProfesor("Pedro");
		m5.setSemestre(s3);
		
		Materia m6 = new Materia();
		m6.setCodigo("BD001");
		m6.setNombre("BD");
		m6.setNombreProfesor("Carlos");
		m6.setSemestre(s3);
		
		List<Materia> materias =new ArrayList<>();
		materias.add(m4);
		materias.add(m5);
		materias.add(m6);
		
		s3.setMaterias(materias);
	//	this.iSemestreService.guardar(s3);
		
		
		
	}

}

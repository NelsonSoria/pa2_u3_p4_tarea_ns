package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Persona;
import com.example.demo.service.FacturaService;
import com.example.demo.service.PersonaService;

@SpringBootApplication
public class Pa2U3P4TareaNsApplication implements CommandLineRunner{
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private FacturaService facturaService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4TareaNsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		List<Persona> myLista1 = this.personaService.buscarInnerJoin();
		for (Persona p : myLista1) {
			System.out.println(p);
		}
		List<Persona> myLista2 = this.personaService.buscarOuterLeftJoin();
		for (Persona p : myLista2) {
			System.out.println(p);
		}
		List<Persona> myLista3 = this.personaService.buscarJoinWhere();
		for (Persona p : myLista3) {
			System.out.println(p);
		}
		
		List<Persona> myLista4= this.personaService.buscarOuterFullJoin();
		for (Persona p : myLista4) {
			System.out.println(p);
		}
	
	    List<Persona> myLista5 = this.personaService.buscarOuterRightJoin();
	    for (Persona p : myLista5) {
			System.out.println(p);
		}
		List<Factura> myLista6 = this.facturaService.buscarInnerJoin();
		for (Factura f : myLista6) {
			System.out.println(f);
		}
		List<Factura> myLista7 = this.facturaService.buscarOuterRightJoin();
		for (Factura f : myLista7) {
			System.out.println(f);
		}
		List<Factura> myLista8 = this.facturaService.buscarOuterLeftJoin();
		for (Factura f : myLista8) {
			System.out.println(f);
		}
		List<Factura> myLista9 = this.facturaService.buscarOuterFullJoin();
		for (Factura f : myLista9) {
			System.out.println(f);
		}
		List<Factura> myLista10 = this.facturaService.buscarJoinWhere();
		for (Factura f : myLista10) {
			System.out.println(f);
		}
		List<Persona> myLista11 = this.personaService.buscarJoinFetch();
		for (Persona p : myLista11) {
			System.out.println(p);
		}
		
		List<Factura> myLista12 = this.facturaService.buscarJoinFetch();
		for (Factura f : myLista12) {
			System.out.println(f);
		}
	}

}
package com.example.demo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Persona;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.service.FacturaService;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.IPruebaService;
import com.example.demo.service.ITransferenciaService;
import com.example.demo.service.PersonaService;

@SpringBootApplication
public class Pa2U3P4TareaNsApplication implements CommandLineRunner{
	
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	@Autowired
	private IPropietarioService iPropietarioService;
	@Autowired
	private IPruebaService iPruebaService;
	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4TareaNsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Main: "+ TransactionSynchronizationManager.isActualTransactionActive());
		
	   /* Propietario p1= new Propietario();
		p1.setApellido("Soria");
		p1.setCedula("1750932893");
		p1.setNombre("Nelson");
		
		Propietario p2= new Propietario();
		p2.setApellido("Paredes");
		p2.setCedula("158904344");
		p2.setNombre("Patricio");

		CuentaBancaria cta1=new CuentaBancaria();
		cta1.setNumero("001");
		cta1.setSaldo(new BigDecimal(50));
		cta1.setTipo('A');
		cta1.setPropietario(p1);

		CuentaBancaria cta2=new CuentaBancaria();
		cta2.setNumero("002");
		cta2.setSaldo(new BigDecimal(70));
		cta2.setTipo('A');
		cta2.setPropietario(p2);
		
	
		this.bancariaService.guardar(cta1);
		this.bancariaService.guardar(cta2);*/
		
		this.iTransferenciaService.realizarTransferencia("001", "002", new BigDecimal(300));
		List<Transferencia> trans=this.iTransferenciaService.reporte();
		for(Transferencia t:trans) {
			System.err.println(t);
		}
		
	}

}
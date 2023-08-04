package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

	
		
		//******************* Interfaces Funcionales Java ******
				//1. Supplier
		     
				Stream<String> lista = Stream.generate(MetodosReferenciados::getIdHO).limit(5);
				lista.forEach(cadena->LOG.info(cadena));
		
				//2. Consumer
				List<Integer> listaNumeros= Arrays.asList(4,5,6,7,8,9,10,11,12,20);
				listaNumeros.forEach(MetodosReferenciados::aceptarConsumer);

				//3. Predicate

				Stream <Integer> listaFinal = listaNumeros.stream().filter(MetodosReferenciados::evaluar);
				listaFinal.forEach(numero -> LOG.info("Valor:" + numero));

				//4. Function
				Stream <String> listaCambiada = listaNumeros.stream().map(MetodosReferenciados::aplicarFunction);
				listaCambiada.forEach(cadena -> LOG.info(cadena));

				//5. UnaryOperator

				Stream <Integer> listaCambiada2 = listaNumeros.stream().map(MetodosReferenciados::aplicarUnary2);
			 	listaCambiada2.forEach(cadena -> LOG.info(" "+cadena));
	}

}

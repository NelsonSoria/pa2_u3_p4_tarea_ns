package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		// 1. Supplier

		// Clases:

		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier clase:" + supplier1.getId());

		// Lambdas
		IPersonaSupplier<String> supplier2 = () -> "17522859486";
		LOG.info("Supplier Lamdba:" + supplier2.getId());

		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "1564156";
			cedula = cedula + "zzzzzzzzzz" +"Nelcrew";
			return cedula;
		};
		LOG.info("Supplier clase:" + supplier3.getId());

		// Metodos referenciados

		IPersonaSupplier<Integer> supplier4 = MetodosReferenciados::getId;
		LOG.info("Supplier metodo referenciado:" + supplier4.getId());

		// 2. CONSUMER

		// Clases
		IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();
		LOG.info("Cosumer clase:");
		consumer1.accept("Nelson Soria");

		// LAMBDAS
		IPersonaConsumer<String> consumer2 = cadena -> {
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		};
		LOG.info("Cosumer Lambdas:");
		consumer2.accept("Nelson2");
		consumer2.accept("Nelson3");
		
		// Metodos referenciados
		IPersonaConsumer<String> consumer3 = MetodosReferenciados::aceptar;
		LOG.info("Cosumer Metodos Referenciados:");
		consumer3.accept("Nelson Soria 3");

		// 3. PREDICATE
		// LAMBDAS
		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8) == 0;
		LOG.info("Predicate Lambda: " + predicate1.evaluar(4));

		IPersonaPredicate<Integer> predicate2 = valor -> {
			Integer valor2 = 10;
			valor = valor + valor2;
			if (valor.compareTo(100) > 0) {
				return true;
			} else {
				return false;
			}
		};
		LOG.info("Predicate Lambda: " + predicate2.evaluar(95));

		IPersonaPredicate<String> predicate3 = caracter -> "Joel".contains(caracter);
		LOG.info("Predicate Lambda: " + predicate3.evaluar("o"));

		IPersonaBiPredicate<String, String> predicate4 = (caracter, nombre) -> nombre.contains(caracter);
		LOG.info("BiPredicate Lambda: " + predicate4.evaluar("N", "Nelson"));

		// Metodos referenciados
		IPersonaPredicate<Integer> predicate5 = MetodosReferenciados::evaluar;
		LOG.info("Predicate Metodos Referenciados: " + predicate5.evaluar(500));

		// 4. FUNCTION
		// LAMBDAS
		IPersonaFunction<String, Integer> function1 = numero -> numero.toString();
		LOG.info("Funcion1 Lambda: " + function1.aplicar(8));

		IPersonaFunction<String, Integer> function2 = numero -> {
			String valorFinal = numero.toString().concat("Valor");
			return valorFinal;
		};
		LOG.info("Funcion2 Lambda: " + function2.aplicar(10));

		// 5. unary operator
		IPersonaUnaryOperator<Integer> unary1 = numero -> numero + (numero * 2);
		LOG.info("Unary Lambda: " + unary1.aplicar(3));
		

		// 6. unary operator Funtion
		IPersonaUnaryOperatorFunction<Integer> unary2 = numero -> numero + (numero * 2);
		LOG.info("UnaryOperatorFunction Lambda: " + unary2.aplicar(3));

		
		//////////////////Metodos High Order**************

		// SUPPLIER

		// 1. Clase
		IPersonaSupplier<String> supplierHO = new PersonaSupplierImpl();
		MetodosHighOrder.metodo(supplierHO);

		// 2. Lambdas
		MetodosHighOrder.metodo(() -> "17654561HO");

		// 3. Metodos referenciados
		MetodosHighOrder.metodo(MetodosReferenciados::getIdHO);

		// CONSUMER

		// 1. Clase

		MetodosHighOrder.metodoConsumer(new PersonaConsumerImpl(), "Nelson");
		// 2. Lambdas

		MetodosHighOrder.metodoConsumer(cadena -> {
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		}, "Lambdas Consumer");

		// 3. Metodos referenciados
		MetodosHighOrder.metodoConsumer(MetodosReferenciados::aceptar, "MetodosReferenciados Consumer");

		                      // Predicate

		// 1. Clase

		MetodosHighOrder.metodoPredicate(new PersonaPredicateImpl(), 23);

		// 2. Lambdas
		MetodosHighOrder.metodoPredicate(valor -> valor.compareTo(8) > 0, 20);

		// 3. Metodos referenciados
		MetodosHighOrder.metodoPredicate(MetodosReferenciados::evaluar, 80);

		                      // Function
		// 1. Clase

		MetodosHighOrder.metodoFunction(new PersonaFunctionImpl(), 400);

		// 2. Lambdas
		MetodosHighOrder.metodoFunction(numero -> {
			String valorFinal = numero.toString().concat("Valor");
			return valorFinal;
		}, 100000);

		// 3. Metodos referenciados
		MetodosHighOrder.metodoFunction(MetodosReferenciados::aplicarFunction, 8000);

		                         // UnaryOperator

		// 1. Clase

		MetodosHighOrder.metodoUnaryOperator(new PersonaUnaryOperatorImpl(), " Nelsooon");

		// 2. Lambdas
		MetodosHighOrder.metodoUnaryOperator(cadena -> {
			String cadenafinal = cadena.concat(" Soooooria");
			return cadenafinal;
		}, "Nelson");

		// 3. Metodos referenciados
		MetodosHighOrder.metodoUnaryOperator(MetodosReferenciados::aplicarUnary, " Paredes");

		// ******************* Interfaces Funcionales Java METODOS LAMBDAS******
		// 1. Supplier

		Stream<String> lista = Stream.generate(() -> "17654561HO").limit(10);
		lista.forEach(cadena -> LOG.info(cadena));
		LOG.info("Prueba: " + lista);
		// 2. Consumer
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
		listaNumeros.forEach(cadena -> {
			LOG.info(" " + cadena);
		});

		// 3. Predicate

		Stream<Integer> listaFinal = listaNumeros.stream().filter(numero -> numero >= 5);
		listaFinal.forEach(numero -> LOG.info("Valor:" + numero));

		// 4. Function
		Stream<String> listaCambiada = listaNumeros.stream().map(numero -> {
			Integer num = 10;
			num = numero + num;
			return "N:" + num;
		});
		listaCambiada.forEach(cadena -> LOG.info(cadena));

		// 5. UnaryOperator

		Stream<Integer> listaCambiada2 = listaNumeros.stream().map(numero -> {
			Integer num = 10;
			num = numero + num;
			return num;
		});
		listaCambiada2.forEach(cadena -> LOG.info(" " + cadena));

		// ******************* Interfaces Funcionales Java METODOS REFERENCIADOS******
		// 1. Supplier

		Stream<String> lista9 = Stream.generate(MetodosReferenciados::getIdHO).limit(5);
		lista9.forEach(cadena -> LOG.info(cadena));

		// 2. Consumer
		List<Integer> listaNumeros6 = Arrays.asList(4, 5, 6, 7, 8, 9, 10, 11, 12, 20);
		listaNumeros6.forEach(MetodosReferenciados::aceptarConsumer);

		// 3. Predicate

		Stream<Integer> listaFinal7 = listaNumeros6.stream().filter(MetodosReferenciados::evaluar);
		listaFinal7.forEach(numero -> LOG.info("Valor:" + numero));

		// 4. Function
		Stream<String> listaCambiada7 = listaNumeros6.stream().map(MetodosReferenciados::aplicarFunction);
		listaCambiada7.forEach(cadena -> LOG.info(cadena));

		// 5. UnaryOperator

		Stream<Integer> listaCambiada8 = listaNumeros6.stream().map(MetodosReferenciados::aplicarUnary2);
		listaCambiada8.forEach(cadena -> LOG.info(" " + cadena));
	}

}

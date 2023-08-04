package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

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
	}

}

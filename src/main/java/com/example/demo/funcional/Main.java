package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		
		MetodosReferenciados metodos= new MetodosReferenciados();
		
		//4. FUNCTION
		
		IPersonaFunction<String, Integer> function1 = numero->numero.toString();
		LOG.info("Funcion1 Lambda: "+ function1.aplicar(8));

		IPersonaFunction<String, Integer> function2 = numero->
		{
			String valorFinal= numero.toString().concat("Valor");
			return valorFinal;
		};
		LOG.info("Funcion2 Lambda: "+ function2.aplicar(10));
		
		//Metodos referenciados
		IPersonaFunction<String, Integer> function3 = metodos::aplicarFunction;
		LOG.info("Function Metodos Referenciados: "+ function3.aplicar(5));
		
		// 5. unary operator
		IPersonaUnaryOperator<Integer> unary1 = numero -> numero+(numero*2);
		LOG.info("Unary Lambda: "+ unary1.aplicar(3));
		
		//Metodos referenciados
		IPersonaUnaryOperator<String> unary2 = metodos::aplicarUnary;
		LOG.info("Unary Metodos Referenciados: "+ unary2.aplicar(" Nelson"));
		
		
	}

}

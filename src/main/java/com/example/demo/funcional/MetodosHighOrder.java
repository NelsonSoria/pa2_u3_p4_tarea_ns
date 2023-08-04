package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {
	
	private static final Logger LOG = LoggerFactory.getLogger(MetodosHighOrder.class);

	public static void metodo(IPersonaSupplier<String> funcion) {
		funcion.getId();
		LOG.info("High Order Supplier: "+ funcion.getId());
	}
	public static void metodoConsumer(IPersonaConsumer<String> funcion, String arg) {
		funcion.accept(arg);
	}
	public static boolean metodoPredicate(IPersonaPredicate<Integer> funcion, Integer arg) {
		Boolean aux= funcion.evaluar(arg);
		LOG.info("Predicate metodo HO:" + aux);
		return aux;
	}
	public static String metodoFunction(IPersonaFunction<String,Integer> funcion, Integer arg) {
		String aux= funcion.aplicar(arg);
		LOG.info("Function metodo HO:" + aux);
		return funcion.aplicar(arg);
	}
    public static String metodoUnaryOperator(IPersonaUnaryOperator<String> funcion,String arg) {
    	String aux= funcion.aplicar(arg);
		LOG.info("UnaryOperator metodo HO:" + aux);
    	return aux;
	}

}

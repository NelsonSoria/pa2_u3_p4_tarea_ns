package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);

	public static Integer getId() {
		return 8;
	}
	public static void aceptar(String arg) {
		String cadena = "Nelson";
		LOG.info(cadena+ " "+ arg);
	}
	public static void aceptarConsumer(Integer arg) {
		LOG.info("Consumer: "+ arg);
	}
	public static  boolean evaluar(Integer arg) {	
		if(arg.compareTo(10)<=0) {
			return true;
		}else {
			return false;
		}
	}
	public static  String aplicarFunction(Integer arg) {
		String aux ="Nelson".concat(String.valueOf(arg));
		return aux;
	}
	
	public static String aplicarUnary(String arg) {	
		String aux="Soria".concat(arg);
		return aux;
	}
	public static String getIdHO() {
		//LOG.info("Metodos referenciado y HO");
		return "Nelson Soria";
	}
	public static Integer aplicarUnary2(Integer arg) {	
		Integer aux=arg*1000;
		return aux;
	}
	
}

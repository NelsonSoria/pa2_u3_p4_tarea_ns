package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);

	public Integer getId() {
		return 8;
	}
	public void aceptar(String arg) {
		String cadena = "Nelson";
		LOG.info(cadena+ " "+ arg);
	}
	public boolean evaluar(Integer arg) {
		
		if(arg.compareTo(100)<0) {
			return true;
		}else {
			return false;
		}
		
		
	}
	public String aplicarFunction(Integer arg) {
		String aux ="Nelson".concat(String.valueOf(arg));
		
		return aux;
				
	}
	
	public String aplicarUnary(String arg) {	
		String aux="Soria".concat(arg);
		return aux;
	}
}

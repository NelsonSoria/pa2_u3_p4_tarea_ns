package com.example.demo.funcional;

public class PersonaPredicateImpl implements IPersonaPredicate{

	@Override
	public boolean evaluar(Object arg) {
		Integer valor= (Integer)arg;
		Integer valor2 = 10;
		valor = valor + valor2;
		if(valor.compareTo(100)>0 ) {
			return true;
		}else {
			return false;
		}
	}

}

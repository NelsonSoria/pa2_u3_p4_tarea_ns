package com.example.demo.funcional;

public class PersonaUnaryOperatorImpl implements IPersonaUnaryOperator{

	@Override
	public Object aplicar(Object arg) {
		String aux= (String)arg;
		aux.concat(" zzzzzzzzz ");
		return aux;
	}

}

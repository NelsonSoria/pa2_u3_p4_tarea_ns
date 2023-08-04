package com.example.demo.funcional;

public class PersonaFunctionImpl implements IPersonaFunction{

	@Override
	public Object aplicar(Object arg) {
		Integer valor= (Integer) arg;
		String aux= "Function".concat(String.valueOf(valor));
		return aux;
	}

}

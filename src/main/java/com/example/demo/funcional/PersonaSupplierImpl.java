package com.example.demo.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier{

	@Override
	public String getId() {
		 String cedula="1564156";
		 cedula = cedula+"zzzzzzzzzz";
		return cedula;
	}

}

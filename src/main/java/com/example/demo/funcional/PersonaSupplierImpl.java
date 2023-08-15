
package com.example.demo.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier{

	@Override
	public String getId() {
		 String cedula="Nelson";
		 cedula = cedula+" Soria";
		return cedula;
	}

}

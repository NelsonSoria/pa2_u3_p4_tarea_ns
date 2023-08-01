package com.example.demo.repository;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
	public void insertar(CuentaBancaria CuentaBancaria);
	public void eliminar(Integer id);
	public CuentaBancaria seleccionarPorId(Integer id);
	public void actualizar(CuentaBancaria cuentaBancaria);
	
	public CuentaBancaria seleccionarPorNumero(String numeroCuenta);

}

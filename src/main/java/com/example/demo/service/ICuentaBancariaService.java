package com.example.demo.service;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	public void guardar(CuentaBancaria CuentaBancaria);
	public void borrar(Integer id);
	public CuentaBancaria buscarPorId(Integer id);
	public void actualizar(CuentaBancaria cuentaBancaria);
	
	public CuentaBancaria buscarPorNumero(String numeroCuenta);

}

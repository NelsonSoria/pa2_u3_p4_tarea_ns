package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	

	@Override
	public void guardar(CuentaBancaria CuentaBancaria) {
		this.bancariaRepository.insertar(CuentaBancaria);
		
	}

	@Override
	public void borrar(Integer id) {
		this.bancariaRepository.eliminar(id);
		
	}

	@Override
	public CuentaBancaria buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionarPorId(id);
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.bancariaRepository.actualizar(cuentaBancaria);
		
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numeroCuenta) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionarPorNumero(numeroCuenta);
	}

}

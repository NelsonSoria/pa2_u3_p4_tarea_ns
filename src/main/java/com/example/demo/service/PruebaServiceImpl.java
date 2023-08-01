package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PruebaServiceImpl implements IPruebaService {

	@Override
	@Transactional(value = TxType.NEVER)
	public void prueba() {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba");
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void prueba2() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba 2");
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba SUpports");
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void pruebaNotSupported() {
		System.out.println("metodo 2: "+ TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba Not Supported");
		
		
	}

	@Override
	@Transactional(value = TxType.REQUIRED)  /// siempre por defecto es required
	public void pruebaRequired() {
		System.out.println("metodo 2: "+ TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba required");
		
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void pruebaRequiresNew() {
		System.out.println("metodo 2: "+ TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba requires new");
		
	}

}

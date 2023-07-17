package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertar(CuentaBancaria CuentaBancaria) {
		this.entityManager.persist(CuentaBancaria);
		
	}

	@Override
	public void eliminar(Integer id) {
		CuentaBancaria cuenta=this.seleccionarPorId(id);
		this.entityManager.remove(cuenta);
		
	}

	@Override
	public CuentaBancaria seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CuentaBancaria.class, id);
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.entityManager.merge(cuentaBancaria);
		
	}

	@Override
	public CuentaBancaria seleccionarPorNumero(String numeroCuenta) {
		TypedQuery<CuentaBancaria> myQuery = this.entityManager.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero=:DatoNumero",CuentaBancaria.class);
		myQuery.setParameter("DatoNumero", numeroCuenta);
		return myQuery.getSingleResult();
	}

}

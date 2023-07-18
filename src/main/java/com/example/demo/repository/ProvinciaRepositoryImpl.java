package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Provincia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProvinciaRepositoryImpl implements IProvinciaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Provincia provincia) {
		this.entityManager.persist(provincia);
		
	}

}

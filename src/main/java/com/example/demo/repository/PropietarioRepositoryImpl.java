package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PropietarioRepositoryImpl  implements IPropietarioRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Propietario propietario) {
		this.entityManager.persist(propietario);
		
	}

	@Override
	public void eliminar(Integer id) {
		Propietario propietario=this.seleccionarPorId(id);
		this.entityManager.remove(propietario);
		
	}

	@Override
	public Propietario seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Propietario.class, id);
	}

	@Override
	public void actualizar(Propietario propietario) {
		this.entityManager.merge(propietario);
		
	}

}
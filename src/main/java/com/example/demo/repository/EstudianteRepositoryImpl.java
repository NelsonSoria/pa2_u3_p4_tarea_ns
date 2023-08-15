package com.example.demo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{
	private static final Logger LOG = LoggerFactory.getLogger(EstudianteRepositoryImpl.class);
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
		
	}

	@Override
	public void eliminar(Integer id) {
		Estudiante e=this.seleccionarPorId(id);
		this.entityManager.remove(e);
		
	}

	@Override
	public Estudiante seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
	this.entityManager.merge(estudiante);	
	}

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		LOG.info("Hilo Repository" + Thread.currentThread().getName());
		TypedQuery<Estudiante> query=this.entityManager.createQuery("Select e From Estudiante e Where "
				+ "e.cedula=:DatoCedula",Estudiante.class);
		query.setParameter("DatoCedula", cedula);
		return query.getSingleResult();
	}

	
}

package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{
  
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
		Materia materia= this.seleccionarPorID(id);
		this.entityManager.remove(materia);
	}

	@Override
	public Materia seleccionarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(materia);
	}

	@Override
	public Materia seleccionarPorCodigo(String codigo) {
		TypedQuery<Materia> myQuery= this.entityManager.createQuery("Select m from Materia m Where m.codigo=:datoCodigo",Materia.class);
		myQuery.setParameter("datoCodigo",codigo);
		return myQuery.getSingleResult();
	}

}

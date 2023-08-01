package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRepositoryImpl implements FacturaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Factura factura) {
		this.entityManager.persist(factura);
		
	}

	@Override
	public void eliminar(Integer id) {
		Factura fac= this.seleccionarPorID(id);
		this.entityManager.remove(fac);
		
	}

	@Override
	public Factura seleccionarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public void actualizar(Factura factura) {
		this.entityManager.merge(factura);
		
	}

	@Override
	public List<Factura> seleccionarInnerJoin() {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f  JOIN f.persona p ",
				Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> seleccionarOuterRightJoin() {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f  RIGHT JOIN f.persona p ",
				Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> seleccionarOuterLeftJoin() {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f   LEFT JOIN f.persona p ",
				Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> seleccionarOuterFullJoin() {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f  FULL JOIN f.persona p ",
				Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> seleccionarJoinWhere() {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f,Persona p Where f.persona=p ",
				Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> seleccionarJoinFetch() {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f  JOIN FETCH f.persona p ",
				Factura.class);
		return myQuery.getResultList();
	}



}

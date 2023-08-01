package com.example.demo.repository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class PersonaRepositoryImpl implements PersonaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Persona persona) {
		this.entityManager.persist(persona);
		
	}

	@Override
	public void eliminar(Integer id) {
		Persona p= this.seleccionarPorID(id);
		this.entityManager.remove(p);
		
	}

	@Override
	public Persona seleccionarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void actualizar(Persona persona) {
		this.entityManager.merge(persona);
		
	}

	

	@Override
	public List<Persona> seleccionarInnerJoin() {
		TypedQuery<Persona> myQuery = this.entityManager.createQuery("SELECT p FROM Persona p  JOIN p.facturas f ",
				Persona.class);
		List<Persona> miLista = myQuery.getResultList();
		for (Persona p : miLista) {
			p.getFacturas().size();
		}
		return miLista;
	}

	@Override
	public List<Persona>  seleccionarOuterRightJoin() {
		TypedQuery<Persona> myQuery = this.entityManager.createQuery("SELECT p FROM Persona p  RIGHT JOIN p.facturas f",
				Persona.class);
		List<Persona> miLista = myQuery.getResultList();
		for (Persona p : miLista) {
			if(p==null) {
				System.err.println("NO existe aun un hotel");
			}else {
				p.getFacturas().size();
			}
		}
		return miLista;
	}

	@Override
	public List<Persona> seleccionarOuterLeftJoin() {
		TypedQuery<Persona> myQuery = this.entityManager.createQuery("SELECT p FROM Persona p  LEFT JOIN p.facturas f ",
				Persona.class);
		List<Persona> miLista = myQuery.getResultList();
		for (Persona p : miLista) {
			p.getFacturas().size();
		}
		return miLista;
	}
	@Override
	public List<Persona> seleccionarOuterFullJoin() {
		TypedQuery<Persona> myQuery = this.entityManager.createQuery("SELECT p FROM Persona p FULL JOIN p.facturas f ",
				Persona.class);
		List<Persona> miLista = myQuery.getResultList();
		for (Persona p : miLista) {
			if(p==null) {
				System.err.println("NO existe aun un hotel");
			}else {
				p.getFacturas().size();
			}
		}
		return miLista;
	}

	@Override
	public List<Persona> seleccionarJoinWhere() {
		TypedQuery<Persona> myQuery = this.entityManager.createQuery("SELECT p FROM Persona p,Factura f "
				+ "WHERE p=f.persona ",
				Persona.class);
	
		List<Persona> miLista = myQuery.getResultList();
		for (Persona p : miLista) {
			p.getFacturas().size();
		}
		return miLista;
	}

	@Override
	public List<Persona> seleccionarJoinFech() {
		TypedQuery<Persona> myQuery = this.entityManager.createQuery("SELECT p FROM Persona p JOIN FETCH p.facturas f ",
				Persona.class);
	
		List<Persona> miLista = myQuery.getResultList();
		for (Persona p : miLista) {
			p.getFacturas().size();
		}
		return miLista;
	}
	

}

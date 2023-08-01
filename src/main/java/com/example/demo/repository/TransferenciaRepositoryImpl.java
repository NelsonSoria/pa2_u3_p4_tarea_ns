package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Transferencia transferencia) {
		
		this.entityManager.persist(transferencia);
		//throw new RuntimeException();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		Transferencia transferencia= this.seleccionarPorId(id);
		this.entityManager.remove(transferencia);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Transferencia seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Transferencia.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Transferencia transferencia) {
		this.entityManager.merge(transferencia);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Transferencia> seleccionarTodos() {
		//TypedQuery<Transferencia> myQuery =this.entityManager.createQuery("Select t from Transferencia t",Transferencia.class);
		TypedQuery<Transferencia> myQuery =this.entityManager.createQuery("Select t from Transferencia t JOIN FETCH t.cuentaOrigen co JOIN FETCH t.cuentaDestino cd",Transferencia.class);
		return myQuery.getResultList();
	}

}

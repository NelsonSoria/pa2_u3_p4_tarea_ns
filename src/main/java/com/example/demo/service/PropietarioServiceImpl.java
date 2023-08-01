package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.IPropietarioRepository;
import com.example.demo.repository.modelo.Propietario;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired
	private IPropietarioRepository iPropietarioRepository;
	
	@Autowired
	private IPruebaService iPruebaService;
	
	@Override
	@Transactional
	public void guardar(Propietario propietario) {
		System.out.println("Service: "+ TransactionSynchronizationManager.isActualTransactionActive());
		//this.iPropietarioRepository.insertar(propietario);
		//this.iPruebaService.prueba();
		//this.iPruebaService.prueba2();
		//this.iPruebaService.pruebaSupports();
		//this.iPruebaService.pruebaNotSupported();
		//this.iPruebaService.pruebaRequired();
		this.iPruebaService.pruebaRequiresNew();
	}
	
	@Transactional(value = TxType.NEVER)
	public void prueba() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		System.out.println("Metodo de prueba");
	}
	@Override
	public void borrar(Integer id) {
		this.iPropietarioRepository.eliminar(id);
		
	}

	@Override
	public Propietario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iPropietarioRepository.seleccionarPorId(id);
	}

	@Override
	public void actualizar(Propietario propietario) {
		this.iPropietarioRepository.actualizar(propietario);
		
	}

}

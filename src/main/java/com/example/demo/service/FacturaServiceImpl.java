package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.FacturaRepository;
import com.example.demo.repository.modelo.Factura;


@Service
public class FacturaServiceImpl implements FacturaService{

	@Autowired
	private FacturaRepository facturaRepository;
	
	@Override
	public void guardar(Factura factura) {
		this.facturaRepository.insertar(factura);
		
	}

	@Override
	public void borrar(Integer id) {
		this.facturaRepository.eliminar(id);
		
	}

	@Override
	public Factura buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Factura factura) {
		this.facturaRepository.actualizar(factura);
		
	}

	@Override
	public List<Factura> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Factura> buscarOuterRightJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<Factura> buscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Factura> buscarOuterFullJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Factura> buscarJoinWhere() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarJoinWhere();
	}

	@Override
	public List<Factura> buscarJoinFetch() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarJoinFetch();
	}



}

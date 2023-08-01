package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Factura;


public interface FacturaRepository {

	public void insertar(Factura factura);
	public void eliminar(Integer id);
	public Factura seleccionarPorID(Integer id);
	public void actualizar(Factura factura);
	
	public List<Factura> seleccionarInnerJoin();
	public List<Factura> seleccionarOuterRightJoin();
	public List<Factura> seleccionarOuterLeftJoin();
	public List<Factura> seleccionarOuterFullJoin();
	public List<Factura> seleccionarJoinWhere();
	public List<Factura> seleccionarJoinFetch();
	
	
}

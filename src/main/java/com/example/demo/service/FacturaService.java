package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Factura;


public interface FacturaService {
	public void guardar(Factura factura);
	public void borrar(Integer id);
	public Factura buscarPorID(Integer id);
	public void actualizar(Factura factura);
	
	public List<Factura> buscarInnerJoin();
	public List<Factura> buscarOuterRightJoin();
	public List<Factura> buscarOuterLeftJoin();
	public List<Factura> buscarOuterFullJoin();
	public List<Factura> buscarJoinWhere();
	public List<Factura> buscarJoinFetch();
	
}

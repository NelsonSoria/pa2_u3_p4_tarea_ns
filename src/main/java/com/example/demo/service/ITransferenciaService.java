package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Transferencia;

public interface ITransferenciaService {
	public void buscar(Transferencia transferencia);
	public void borrar(Integer id);
	public Transferencia buscarPorId(Integer id);
	public void actualizar(Transferencia transferencia);
	
	public List<Transferencia> reporte();
	public void realizarTransferencia(String numeroCtaOrigen,String numeroCtaDestino,BigDecimal monto);
}

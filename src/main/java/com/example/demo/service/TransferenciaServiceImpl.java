package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.ITransferenciaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{

	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Override
	public void buscar(Transferencia transferencia) {
		this.iTransferenciaRepository.insertar(transferencia);
		
	}

	@Override
	public void borrar(Integer id) {
		this.iTransferenciaRepository.eliminar(id);
		
	}

	@Override
	public Transferencia buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionarPorId(id);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.iTransferenciaRepository.actualizar(transferencia);
		
	}

	@Override
	public List<Transferencia> reporte() {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionarTodos();
	}

	@Override
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		CuentaBancaria ctaOrigen=this.bancariaRepository.seleccionarPorNumero(numeroCtaOrigen);
		if(ctaOrigen==null) {
			System.err.println("La Cuenta Origen no exite");
			return;
		}
		CuentaBancaria ctaDestino=this.bancariaRepository.seleccionarPorNumero(numeroCtaDestino);
		if(ctaDestino==null) {
			System.err.println("La Cuenta Destino no exite");
			return;
		}
		BigDecimal saldoOrigen=ctaOrigen.getSaldo();
		BigDecimal saldoDestino=ctaDestino.getSaldo();
		
		if(monto.compareTo(saldoOrigen)<=0) {
			ctaOrigen.setSaldo(saldoOrigen.subtract(monto));
			ctaDestino.setSaldo(saldoDestino.add(monto));
			this.bancariaRepository.actualizar(ctaOrigen);
			this.bancariaRepository.actualizar(ctaDestino);
			
			Transferencia miTransferencia = new Transferencia();
			miTransferencia.setFecha(LocalDateTime.now());
			miTransferencia.setMonto(monto);
			miTransferencia.setCuentaOrigen(ctaOrigen);
			miTransferencia.setCuentaDestino(ctaDestino);
			
			this.iTransferenciaRepository.insertar(miTransferencia);
			
		}else{
			System.err.println("Saldo Insuficiente");
			return;
		}
		
		
		
		
		
		
		
	}

}

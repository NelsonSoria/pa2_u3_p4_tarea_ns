package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements HotelService{
     
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public void guardar(Hotel hotel) {
		for(Habitacion c : hotel.getHabitaciones()) {
			c.setValorIncluidoIva(c.getValor().multiply(new BigDecimal(1.12)));	
		}
		this.hotelRepository.insertar(hotel);
	}

	@Override
	public void borrar(Integer id) {
		
		this.hotelRepository.eliminar(id);
	}

	@Override
	public Hotel buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Hotel hotel) {
		this.hotelRepository.actualizar(hotel);;
		
	}

	@Override
	public Hotel cantidad(Integer n) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarPorNumero(n);
	}

	@Override
	public List<Hotel> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Hotel> buscarOuterRightJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<Hotel> buscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHabitacionOuterLeftJoin();
	}

	@Override
	public List<Hotel> buscarOuterFullJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Hotel> buscarJoinWhere() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarJoinWhere();
	}

	@Override
	public List<Hotel> buscarFetchJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarFetchJoin();
	}

}

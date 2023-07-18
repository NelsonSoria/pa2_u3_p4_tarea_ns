package com.example.demo.service;


import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface HotelService {
	public void guardar(Hotel hotel);
	public void borrar(Integer id);
	public Hotel buscarPorID(Integer id);
	public void actualizar(Hotel hotel);
	public Hotel cantidad(Integer n);
	public List<Hotel> buscarInnerJoin();
	public List<Hotel> buscarOuterRightJoin();
	public List<Hotel> buscarOuterLeftJoin();
	public List<Habitacion> buscarHabitacionOuterLeftJoin();
	public List<Hotel> buscarOuterFullJoin();
	public List<Hotel> buscarJoinWhere();
	public List<Hotel> buscarFetchJoin();

}

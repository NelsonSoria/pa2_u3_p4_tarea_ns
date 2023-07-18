package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements HotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Hotel hotel) {
		this.entityManager.persist(hotel);

	}

	@Override
	public void eliminar(Integer id) {
		Hotel hotEncontrado = this.seleccionarPorID(id);
		this.entityManager.remove(hotEncontrado);

	}

	@Override
	public Hotel seleccionarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void actualizar(Hotel hotel) {
		this.entityManager.merge(hotel);

	}

	@Override
	public Hotel seleccionarPorNumero(Integer n) {
		Hotel h = this.entityManager.find(Hotel.class, n);
		h.getHabitaciones().get(0).getNumero();
		return h;
	}

	@Override
	public List<Hotel> seleccionarInnerJoin() {
		// SQL
		// SELECT * from hotel h JOIN habitacion ha ON h.hotel_id=ha.habi_id_hotel
		// JPQL
		// SELECT h FROM Hotel h JOIN h.habitaciones ha

		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha",
				Hotel.class);
		List<Hotel> miLista = myQuery.getResultList();
		for (Hotel h : miLista) {
			h.getHabitaciones().size();
		}
		return miLista;
	}

	@Override
	public List<Hotel> seleccionarOuterRightJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha ",
				Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterLeftJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",
				Hotel.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin() {
		TypedQuery<Habitacion> myQuery = this.entityManager
				.createQuery("SELECT ha FROM Hotel h LEFT JOIN h.habitaciones ha", Habitacion.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterFullJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h FULL JOIN h.habitaciones ha",
				Hotel.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarJoinWhere() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h, Habitacion ha WHERE h=ha.hotel ",
				Hotel.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarFetchJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha",
				Hotel.class);
		return myQuery.getResultList();
	}

}

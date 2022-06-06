package com.api.personas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.personas.exception.ApiUnprocessableEntityException;
import com.api.personas.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

	public boolean existsByDni(int dni);

	public List<Persona> findBySurNameLike(String s) throws ApiUnprocessableEntityException;

	@Override
	public List<Persona> findAll();

	public Persona findByDni(int id);
}

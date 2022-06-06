package com.api.personas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.personas.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

	public boolean existsByDni(int dni);

	public Optional<Persona> findBySurName(String s);

	@Override
	public List<Persona> findAll();
}

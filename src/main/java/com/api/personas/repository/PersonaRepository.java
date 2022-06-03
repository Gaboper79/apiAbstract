package com.api.personas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.personas.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}

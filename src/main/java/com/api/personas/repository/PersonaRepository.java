package com.api.personas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.personas.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}

package com.api.personas.service;

import java.util.List;

import com.api.personas.model.Persona;
import com.api.personas.util.Gender;

public interface IPersona {

	public Persona savePersona(Persona per);

	public String saveGender(Long id, Gender gender);

	public List<Persona> findAll();

	public Persona findByID(Long id) throws Exception;

	public List<Persona> findBySurname(String surname);

	public Persona findByDni(int dni);
}

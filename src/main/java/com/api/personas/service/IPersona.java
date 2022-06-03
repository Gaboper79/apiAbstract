package com.api.personas.service;

import java.util.List;

import com.api.personas.model.Persona;

public interface IPersona {

	public Persona savePersona(Persona per);

	public void saveSex(Long id, Boolean sex);

	public List<Persona> findAll();

	public Persona findByID(Long id);

	public List<Persona> findBySurname(String surname);

	public Persona findByDni(int dni);
}

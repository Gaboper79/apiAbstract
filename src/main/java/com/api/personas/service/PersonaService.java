package com.api.personas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.personas.model.Persona;
import com.api.personas.repository.PersonaRepository;

@Service
public class PersonaService implements IPersona {

	@Autowired
	private PersonaRepository personaRepo;

	@Override
	public Persona savePersona(Persona per) {

		return personaRepo.save(per);
	}

	@Override
	public Persona findByID(Long id) {

		return personaRepo.findById(id).get();
	}

	@Override
	public void saveSex(Long id, Boolean sex) {
		Persona persona = personaRepo.findById(id).get();
		System.out.println(persona);

	}

	@Override
	public List<Persona> findBySurname(String surname) {

		return null;
	}

	@Override
	public Persona findByDni(int dni) {

		return null;
	}

	@Override
	public List<Persona> findAll() {

		return personaRepo.findAll();
	}

}

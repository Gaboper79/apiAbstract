package com.api.personas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.personas.exception.BadRequestException;
import com.api.personas.exception.ResourceNotfoundException;
import com.api.personas.model.Persona;
import com.api.personas.repository.PersonaRepository;
import com.api.personas.util.Gender;
import com.api.personas.util.Validaciones;

@Service
public class PersonaService implements IPersona {

	@Autowired
	private PersonaRepository personaRepo;

	@Override
	public Persona savePersona(Persona per) {
		Validaciones.personaValida(per);
		return personaRepo.save(per);
	}

	@Override
	public Persona findByID(Long id) {

		return personaRepo.findById(id)
				.orElseThrow(() -> new ResourceNotfoundException("Usuario no encontrado con el id: " + id));
	}

	@Override
	public String saveGender(Long id, Gender gender) {

		if (!Validaciones.genderIncludes(gender.toString())) {
			throw new BadRequestException("Genero no permitido");
		}
		Persona persona = this.findByID(id);

		persona.setGender(gender);
		this.savePersona(persona);
		return "Gender modificado exitosamente";

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

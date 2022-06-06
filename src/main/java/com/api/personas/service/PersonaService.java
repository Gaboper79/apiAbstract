package com.api.personas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.personas.dto.PersonaDTO;
import com.api.personas.exception.ApiResourceNotfoundException;
import com.api.personas.exception.ApiUnprocessableEntityException;
import com.api.personas.model.Persona;
import com.api.personas.repository.PersonaRepository;
import com.api.personas.util.Gender;

@Service
public class PersonaService implements IPersona {

	@Autowired
	private PersonaRepository personaRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public PersonaDTO savePersona(PersonaDTO perDTO) throws ApiUnprocessableEntityException {

		if (personaRepo.existsByDni(perDTO.getDni())) {

			throw new ApiUnprocessableEntityException("Dni existente");
		}

		Persona per = convertDTOToPersona(perDTO);

		Persona personaRta = personaRepo.save(per);
		PersonaDTO personaDto = convertPersonaToDTO(personaRta);
		return personaDto;
	}

	@Override
	public PersonaDTO findByID(Long id) throws ApiResourceNotfoundException {

		Persona personas = personaRepo.findById(id)
				.orElseThrow(() -> new ApiResourceNotfoundException("Id no encontrado"));
		PersonaDTO personaDTO = convertPersonaToDTO(personas);
		return personaDTO;

	}

	@Override
	public String saveGender(Long id, String gender) throws ApiResourceNotfoundException {

		Persona persona = personaRepo.findById(id)
				.orElseThrow(() -> new ApiResourceNotfoundException("Id no encontrado"));

		persona.setGender(Gender.valueOf(gender.toUpperCase()));
		personaRepo.save(persona);
		return "Gender modificado exitosamente";

	}

	@Override
	public List<PersonaDTO> findAll() {
		List<Persona> personas = personaRepo.findAll();
		List<PersonaDTO> personasDTO = personas.stream().map((persona) -> convertPersonaToDTO(persona))
				.collect(Collectors.toList());
		return personasDTO;
	}

	@Override
	public PersonaDTO findBySurName(String surname) {
		Optional<Persona> personas = personaRepo.findBySurName(surname);
		if (personas.isPresent()) {
			return null;
		}
		return null;
	}

	@Override
	public PersonaDTO findByDni(int dni) {

		return null;
	}

	// convert persona to DTO
	private PersonaDTO convertPersonaToDTO(Persona persona) {

		PersonaDTO personaDTO = mapper.map(persona, PersonaDTO.class);

		// personaDTO.setGender(personaDTO.getGender().toUpperCase());

		return personaDTO;
	}

	// convert DTO to persona
	private Persona convertDTOToPersona(PersonaDTO personaDTO) {
		personaDTO.setGender(personaDTO.getGender().toUpperCase());
		Persona persona = mapper.map(personaDTO, Persona.class);
		return persona;
	}

}

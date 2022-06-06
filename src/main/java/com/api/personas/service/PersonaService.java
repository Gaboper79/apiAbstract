package com.api.personas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.personas.dto.PersonaDTO;
import com.api.personas.exception.ApiResourceNotfoundException;
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
	public PersonaDTO savePersona(PersonaDTO perDTO) {

		Persona per = convertDTOToPersona(perDTO);

		Persona personaRta = personaRepo.save(per);

		return convertPersonaToDTO(personaRta);
	}

	@Override
	public PersonaDTO findByID(Long id) throws ApiResourceNotfoundException {

		Persona personas = personaRepo.findById(id)
				.orElseThrow(() -> new ApiResourceNotfoundException("Id no encontrado"));
		PersonaDTO personaDTO = convertPersonaToDTO(personas);
		return personaDTO;

	}

	@Override
	public String saveGender(Long id, Gender gender) {

//		
//		Persona persona = this.findByID(id);
//
//		persona.setGender(gender);
//		this.savePersona(persona);
//		return "Gender modificado exitosamente";
//
		return null;
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
		return personaDTO;
	}

	// convert DTO to persona
	private Persona convertDTOToPersona(PersonaDTO personaDTO) {

		Persona persona = mapper.map(personaDTO, Persona.class);
		return persona;
	}

}

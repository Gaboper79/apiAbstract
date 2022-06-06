package com.api.personas.service;

import java.util.List;

import com.api.personas.dto.PersonaDTO;
import com.api.personas.exception.ApiResourceNotfoundException;
import com.api.personas.util.Gender;

public interface IPersona {

	public PersonaDTO savePersona(PersonaDTO per);

	public String saveGender(Long id, Gender gender);

	public List<PersonaDTO> findAll();

	public PersonaDTO findByID(Long id) throws ApiResourceNotfoundException;

	public PersonaDTO findBySurName(String surname);

	public PersonaDTO findByDni(int dni);

}

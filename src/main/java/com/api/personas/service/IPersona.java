package com.api.personas.service;

import java.util.List;

import com.api.personas.dto.PersonaDTO;
import com.api.personas.exception.ApiResourceNotfoundException;
import com.api.personas.exception.ApiUnprocessableEntityException;

public interface IPersona {

	public PersonaDTO savePersona(PersonaDTO per) throws ApiUnprocessableEntityException;

	public String saveGender(Long id, String gender) throws ApiResourceNotfoundException;

	public List<PersonaDTO> findAll();

	public PersonaDTO findByID(Long id) throws ApiResourceNotfoundException;

	public List<PersonaDTO> findBySurName(String surname) throws ApiUnprocessableEntityException;

	public PersonaDTO findByDni(int dni) throws ApiResourceNotfoundException;

}

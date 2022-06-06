package com.api.personas.validator;

import org.springframework.stereotype.Service;

import com.api.personas.dto.PersonaDTO;
import com.api.personas.exception.ApiUnprocessableEntityException;

@Service
public interface IPersonaValidator {
	public void validator(PersonaDTO personaDto) throws ApiUnprocessableEntityException;
}

package com.api.personas.validator;

import org.springframework.stereotype.Component;

import com.api.personas.dto.PersonaDTO;
import com.api.personas.exception.ApiUnprocessableEntityException;
import com.api.personas.util.Gender;

@Component
public class PersonaValidator implements IPersonaValidator {

	@Override
	public void validator(PersonaDTO personaDto) throws ApiUnprocessableEntityException {

		if (personaDto.getDni() == 0) {
			message("Dni no puede ser 0");
		}
		if (personaDto.getName() == null || personaDto.getName().isEmpty()) {
			message("El nombre no puede estar vacio");
		}
		if (personaDto.getName().length() < 3) {
			message("El nombre debe tener al menos 3 caracteres");
		}
		if (personaDto.getSurName() == null || personaDto.getSurName().isEmpty()) {
			message("El apellido no puede estar vacio");
		}
		if (personaDto.getSurName().length() < 3) {
			message("El Apellido debe tener al menos 3 caracteres");
		}
		if (personaDto.getBirth() == null) {
			message("La Fecha de nacimiento no puede estar vacio");
		}
		if (!genderIncludes(personaDto.getGender().toString())) {
			message("Genero no reconocido");
		}
	}

	private void message(String message) throws ApiUnprocessableEntityException {

		throw new ApiUnprocessableEntityException(message);
	}

	public static boolean genderIncludes(String gender) {
		String genderUpper = gender.toUpperCase();
		Boolean genderInclude = false;
		Gender[] allGender = Gender.values();

		for (Gender gen : allGender) {

			if (gen.toString().equals(genderUpper)) {
				genderInclude = true;
			}
		}
		return genderInclude;
	}
}

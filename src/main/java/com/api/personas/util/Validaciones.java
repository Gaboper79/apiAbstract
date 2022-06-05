package com.api.personas.util;

import com.api.personas.exception.BadRequestException;
import com.api.personas.model.Persona;

public class Validaciones {

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

	public static boolean personaValida(Persona persona) {
		String message = "";
		if (persona.getDni() == 0) {
			message = "Dni no puede ser 0";
		}
		if (persona.getName() == null || persona.getName() == "") {
			message = "El nombre no puede estar vacio";
		}
		if (persona.getSurName() == null || persona.getSurName() == "") {
			message = "El apellido no puede estar vacio";
		}
		if (persona.getBirth() == null) {
			message = "La Fecha de nacimiento no puede estar vacio";
		}
		if (!genderIncludes(persona.getGender().toString())) {
			message = "Genero no reconocido";
		}
		if (message != "") {
			throw new BadRequestException(message);
		}
		return true;
	}
}

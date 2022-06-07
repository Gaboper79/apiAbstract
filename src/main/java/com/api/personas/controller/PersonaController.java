package com.api.personas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.personas.dto.PersonaDTO;
import com.api.personas.exception.ApiResourceNotfoundException;
import com.api.personas.exception.ApiUnprocessableEntityException;
import com.api.personas.service.PersonaService;
import com.api.personas.validator.PersonaValidator;

@RestController
@RequestMapping("api/persona")
@CrossOrigin(origins = "*")
public class PersonaController {

	@Autowired
	private PersonaService personaSVC;

	@Autowired
	private PersonaValidator personaValid;

//	@GetMapping("/all")
//	public List<PersonaDTO> getAllPersona() {
//		return personaSVC.findAll();
//	}

	// getbyid
	@GetMapping("/{id}")
	public PersonaDTO getPersonaById(@PathVariable(value = "id") long personaId) throws ApiResourceNotfoundException {
		return personaSVC.findByID(personaId);
	}

	// createuser
	@PostMapping("/add")
	public ResponseEntity<PersonaDTO> addPersona(@RequestBody PersonaDTO personaDto)
			throws ApiUnprocessableEntityException {

		personaValid.validator(personaDto);
		return new ResponseEntity<>(personaSVC.savePersona(personaDto), HttpStatus.CREATED);

	}

	// update genders
	@PutMapping("/updategender/{id}")
	public String updateGender(@PathVariable("id") long personaId, @RequestParam("gender") String gender)
			throws ApiResourceNotfoundException {

		return personaSVC.saveGender(personaId, gender);
	}

//find by apellido
	@GetMapping("/surname")
	public List<PersonaDTO> findBySurName(@RequestParam("surname") String surname)
			throws ApiUnprocessableEntityException {
		return personaSVC.findBySurName(surname);
	}

	// find by dni

	@GetMapping("/dni")
	public PersonaDTO findByDni(@RequestParam("dni") int dni)
			throws ApiUnprocessableEntityException, ApiResourceNotfoundException {
		return personaSVC.findByDni(dni);
	}
}

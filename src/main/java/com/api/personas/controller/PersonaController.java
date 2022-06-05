package com.api.personas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.api.personas.model.Persona;
import com.api.personas.service.PersonaService;
import com.api.personas.util.Gender;

@RestController
@RequestMapping("api/persona")
@CrossOrigin
public class PersonaController {

	@Autowired
	private PersonaService personaSVC;

	@GetMapping("/all")
	public List<Persona> getAllPersona() {
		return personaSVC.findAll();
	}

	// getbyid
	@GetMapping("/{id}")
	public Persona getPersonaById(@PathVariable(value = "id") long personaId) {
		return personaSVC.findByID(personaId);
	}

	// createuser
	@PostMapping("/add")
	public ResponseEntity<Persona> addPersona(@RequestBody Persona persona) {

		return ResponseEntity.ok(personaSVC.savePersona(persona));

	}

	// update gender
	@PutMapping("/updategender/{id}")
	public String updateGender(@PathVariable("id") long personaId, @RequestParam("gender") Gender gender) {

		return personaSVC.saveGender(personaId, gender);
	}
}

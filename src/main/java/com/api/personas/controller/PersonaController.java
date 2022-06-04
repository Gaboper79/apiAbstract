package com.api.personas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.personas.dto.Mensaje;
import com.api.personas.model.Persona;
import com.api.personas.service.PersonaService;

@RestController
@RequestMapping("api/persona")
@CrossOrigin
public class PersonaController {

	@Autowired
	private PersonaService personaSVC;

	@GetMapping("/all")
	public ResponseEntity<List<Persona>> getAllPersona() {
		return ResponseEntity.ok(personaSVC.findAll());
	}

	@PostMapping("/add")
	public ResponseEntity<Persona> addPersona(@RequestBody Persona persona) {
		personaSVC.savePersona(persona);
		return new ResponseEntity(new Mensaje("cargado"), HttpStatus.OK);
	}
}

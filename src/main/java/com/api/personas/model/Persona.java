package com.api.personas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.api.personas.util.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "personas", uniqueConstraints = { @UniqueConstraint(columnNames = { "dni" }) })
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty(message = "El dni no puede estar vacio")
	private int dni;
	@NotEmpty(message = "El nombre no puede estar vacio")
	private String name;
	@NotEmpty(message = "El apellido no puede estar vacio")
	private String surName;

	@NotBlank
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birth;

	public Persona() {
		super();
	}

	public Persona(@NotEmpty(message = "El dni no puede estar vacio") int dni,
			@NotEmpty(message = "El nombre no puede estar vacio") String name,
			@NotEmpty(message = "El apellido no puede estar vacio") String surName, @NotBlank Gender gender,
			Date birth) {
		super();
		this.dni = dni;
		this.name = name;
		this.surName = surName;
		this.gender = gender;
		this.birth = birth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}

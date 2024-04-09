package com.poli.practica.project.model.dto;

import lombok.Data;

@Data
public class PreguntaDTO {

	private Integer id;
	private String dificultad;
	private String categoria;
	private Integer posicion;
	private String palabra;
	private Boolean orientacion;
}

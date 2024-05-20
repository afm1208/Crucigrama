package com.poli.practica.project.model.dto;

import com.poli.practica.project.utils.constant.DifficultEnum;

import lombok.Data;

@Data
public class GeneralGameDTO {
	
	private Long id;
	private String preguntasH;
	private String preguntasV;
	private String respuestas;
	private DifficultEnum dificultad;
	private String pistas;
}

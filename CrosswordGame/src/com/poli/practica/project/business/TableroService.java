package com.poli.practica.project.business;

import com.poli.practica.project.utils.constant.DifficultEnum;

public interface TableroService {
	
	String seleccionarDificultad(Integer dificultad);
	String[][] generarMatrizJuego(DifficultEnum dificultad);
	
}

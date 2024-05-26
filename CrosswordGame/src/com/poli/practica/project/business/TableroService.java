package com.poli.practica.project.business;

import java.sql.SQLException;

import com.poli.practica.project.utils.constant.DifficultEnum;

public interface TableroService {

	String seleccionarDificultad(Integer dificultad);

	String[][] generarMatrizJuego(DifficultEnum dificultad);

	void generarCrucigrama(String dificultad, String username) throws SQLException;

	String getPreguntasHorizontales(String string);

	String getPreguntasVerticales(String dificultad);
	
	String getRespuestas(String dificultad);
}

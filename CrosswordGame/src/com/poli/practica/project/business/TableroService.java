package com.poli.practica.project.business;

import java.sql.SQLException;

import com.poli.practica.project.utils.constant.DifficultEnum;

import javafx.scene.control.TextField;

public interface TableroService {

	String seleccionarDificultad(Integer dificultad);

	String[][] generarMatrizJuego(DifficultEnum dificultad);

	void generarCrucigrama(String dificultad, String username, TextField textField) throws SQLException;

	String getPreguntasHorizontales(String string);

	String getPreguntasVerticales(String dificultad);
	
	String getRespuestas(String dificultad);
}

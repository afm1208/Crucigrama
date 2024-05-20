package com.poli.practica.project.business;

import java.sql.SQLException;

import com.poli.practica.project.utils.constant.DifficultEnum;

public interface TableroService {

	String seleccionarDificultad(Integer dificultad);

	String[][] generarMatrizJuego(DifficultEnum dificultad);

	boolean validarPalabra(String palabra, Integer posicionInicial, Integer posicionFinal, DifficultEnum dificultad);

	void generarCrucigrama(String dificultad, String username) throws SQLException;

	public String getPreguntasHorizontales(String string);

	public String getPreguntasVerticales(String dificultad);

}

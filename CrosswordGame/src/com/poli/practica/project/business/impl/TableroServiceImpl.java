package com.poli.practica.project.business.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.util.StringUtils;
import com.poli.practica.project.business.TableroService;
import com.poli.practica.project.config.ConexionDB;
import com.poli.practica.project.utils.constant.DifficultEnum;

public class TableroServiceImpl implements TableroService {

	private ConexionDB conexion;

	@Override
	public String seleccionarDificultad(Integer dificultad) {

		String diff = null;

		switch (dificultad) {
		case 1:
			diff = DifficultEnum.LOW.name();
		case 2:
			diff = DifficultEnum.MEDIUM.name();
		case 3:
			diff = DifficultEnum.HARD.name();
		default:
			diff = "Escoger una dificultad valida.";
		}

		return diff;
	}

	@Override
	public String[][] generarMatrizJuego(DifficultEnum dificultad) {

		String[][] matriz = null;

		switch (dificultad) {
		case LOW:
			matriz = new String[13][13];
		case MEDIUM:
			matriz = new String[15][15];
		case HARD:
			matriz = new String[20][20];
		default:
			break;
		}
		return matriz;

	}

	@Override
	public void generarCrucigrama(String dificultad, String username) throws SQLException {

		if (StringUtils.isEmptyOrWhitespaceOnly(username) || username == null) {
			throw new IllegalArgumentException("El nombre de usuario es obligatorio...");
		}

		System.out.println(String.format("Generando crucigrama de dificultad %s... ", dificultad));

		this.conexion = new ConexionDB();
		PreparedStatement preparedStatement = ConexionDB.obtenerConexion()
				.prepareStatement("INSERT INTO Usuario(Nombre, Puntaje) VALUES (?, ?)");
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, "0");

		preparedStatement.execute();

		System.out.println(String.format("Insertando informacion de : %s", username));
	}

	@Override
	public String getPreguntasHorizontales(String dificultad) {

		try {
			conexion = new ConexionDB();
			PreparedStatement preparedStatement = ConexionDB.obtenerConexion()
					.prepareStatement("SELECT preguntas_h FROM General_game WHERE dificultad = ?");
			preparedStatement.setString(1, dificultad);

			ResultSet result = preparedStatement.executeQuery();

			System.out.println(String.format("Obteniendo preguntas horizontales de dificultad %s... ", dificultad));

			if (result.next()) {
				String preguntasHorizontales = result.getString("preguntas_h");

				return preguntasHorizontales;
			} else {

				System.out.println("No se encontraron preguntas horizontales para la dificultad especificada.");
				return null;
			}
		} catch (SQLException e) {
			System.out.println(String.format("Error en  getPreguntasHorizontales  %s", e));
		}
		return null;
	}

	@Override
	public String getPreguntasVerticales(String dificultad) {

		try {
			conexion = new ConexionDB();
			PreparedStatement preparedStatement = ConexionDB.obtenerConexion()
					.prepareStatement("SELECT preguntas_v FROM General_game  WHERE dificultad = ?");
			preparedStatement.setString(1, dificultad);

			ResultSet result = preparedStatement.executeQuery();
			
			System.out.println(String.format("Obteniendo preguntas verticales de dificultad %s... ", dificultad));


			if (result.next()) {
				String preguntasHorizontales = result.getString("preguntas_v");

				return preguntasHorizontales;
			} else {

				System.out.println("No se encontraron preguntas horizontales para la dificultad especificada.");
				return null;
			}
		} catch (SQLException e) {
			System.out.println(String.format("Error en  getPreguntasHorizontales  %s", e));
		}
		return null;
	}
	
	@Override
	public String getRespuestas(String dificultad) {

		try {
			conexion = new ConexionDB();
			PreparedStatement preparedStatement = ConexionDB.obtenerConexion()
					.prepareStatement("SELECT respuestas FROM General_game  WHERE dificultad = ?");
			preparedStatement.setString(1, dificultad);

			ResultSet result = preparedStatement.executeQuery();
			
			System.out.println(String.format("Obteniendo respuestas de dificultad %s... ", dificultad));


			if (result.next()) {
				String preguntasHorizontales = result.getString("respuestas");

				return preguntasHorizontales;
			} else {

				System.out.println("No se encontraron respuestas para la dificultad especificada.");
				return null;
			}
		} catch (SQLException e) {
			System.out.println(String.format("Error en  getPreguntasHorizontales  %s", e));
		}
		return null;
	}
}

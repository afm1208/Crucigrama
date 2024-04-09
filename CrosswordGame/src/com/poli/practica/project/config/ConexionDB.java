package com.poli.practica.project.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

	private static final String URL = "jdbc:mysql://localhost:3306/practica_aplicada";
	private static final String USUARIO = "test_user";
	private static final String CONTRASEÑA = "123456";

	public static Connection obtenerConexion() throws SQLException {
		return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
	}

}
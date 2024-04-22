package com.poli.practica.project.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {

	private static final String URL = "jdbc:mysql://localhost:3306/practica_aplicada";
	private static final String USUARIO = "root";
	private static final String CONTRASEÑA = "123456";	
	private static Connection co;  
    private static Statement stm;

	public static Connection obtenerConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			co = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
			stm = co.createStatement();
            System.out.println("Conectado correctamente a la Base de Datos");
            return co;

		} catch (ClassNotFoundException e) {
			System.out.println("Clase no encontrada: " + e);
		} catch (SQLException e) {
			System.out.println("Error de conexion: " + e);
		} catch (Exception e) {
			System.out.println("Error desconocido: " + e);
		}
		return null;
	}

}
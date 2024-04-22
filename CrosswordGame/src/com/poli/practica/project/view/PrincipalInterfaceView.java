package com.poli.practica.project.view;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.poli.practica.project.config.ConexionDB;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrincipalInterfaceView extends Application {

	private Stage primaryStage;
	private ConexionDB conexion;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("CrosswordGame");


		Label usernameLabel = new Label();
		usernameLabel.setText("Inserte nombre de usuario.");
		usernameLabel.setAlignment(Pos.TOP_LEFT);
		TextField username = new TextField();

		Button facilButton = new Button("Fácil");
		Button medioButton = new Button("Medio");
		Button dificilButton = new Button("Difícil");

		facilButton.setOnAction(e -> {
			try {
				generarCrucigrama("Fácil", username.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		medioButton.setOnAction(e -> {
			try {
				generarCrucigrama("Medio", username.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		dificilButton.setOnAction(e -> {
			try {
				generarCrucigrama("Difícil", username.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		VBox titles = new VBox(10);
		titles.setPadding(new Insets(20));
		titles.setAlignment(Pos.TOP_CENTER);
		titles.getChildren().addAll(username, usernameLabel);

		VBox root = new VBox(10);
		root.setPadding(new Insets(20));
		root.setAlignment(Pos.BOTTOM_CENTER);
		root.getChildren().addAll(username, usernameLabel, facilButton, medioButton, dificilButton);

		primaryStage.setScene(new Scene(root, 300, 200));
		primaryStage.show();

	}

	private void generarCrucigrama(String dificultad, String username) throws SQLException {
		System.out.println(String.format("Generando crucigrama de dificultad %s... ", dificultad));

		conexion = new ConexionDB();
		PreparedStatement preparedStatement = ConexionDB.obtenerConexion()
				.prepareStatement("INSERT INTO Usuario(Nombre, Puntaje) VALUES (?, ?)");
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, "0");

		preparedStatement.execute();

		System.out.println(String.format("Insertando informacion de : %s", username));
	}

	public static void main(String[] args) {
		launch(args);
	}
}

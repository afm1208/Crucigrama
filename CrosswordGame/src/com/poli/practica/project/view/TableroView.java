package com.poli.practica.project.view;

import java.sql.SQLException;

import com.poli.practica.project.business.TableroService;
import com.poli.practica.project.business.impl.TableroServiceImpl;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;

public class TableroView extends Application {

	private Stage primaryStage;
	private TableroService service;
	private CrucigramaFacilView crucigramaFacil;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		service = new TableroServiceImpl(); 
		crucigramaFacil = new CrucigramaFacilView();
		
		this.primaryStage = primaryStage;
		primaryStage.setTitle("CrosswordGame");

		Label usernameLabel = new Label();
		usernameLabel.setText("Inserte nombre de usuario.");
		TextField username = new TextField();

		Button facilButton = new Button("Fácil");
		Button medioButton = new Button("Medio");
		Button dificilButton = new Button("Difícil");

		facilButton.setOnAction(e -> {
			try {
				service.generarCrucigrama("Fácil", username.getText(), username);
				primaryStage.close();
				crucigramaFacil.start(primaryStage);
			} catch (SQLException e1) {
				e1.printStackTrace();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		medioButton.setOnAction(e -> {
			try {
				service.generarCrucigrama("Medio", username.getText(), username);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		dificilButton.setOnAction(e -> {
			try {
				service.generarCrucigrama("Difícil", username.getText(),username);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		VBox root = new VBox(10);
		root.setPadding(new Insets(20));
		root.setAlignment(Pos.BOTTOM_CENTER);
		root.getChildren().addAll(usernameLabel, username, facilButton, medioButton, dificilButton);

		primaryStage.setScene(new Scene(root, 300, 200));
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

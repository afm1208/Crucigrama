package com.poli.practica.project.view;

import com.poli.practica.project.business.TableroService;
import com.poli.practica.project.business.impl.TableroServiceImpl;
import com.poli.practica.project.utils.TextUtils;
import com.poli.practica.project.utils.constant.DifficultEnum;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CrucigramaFacilView extends Application {

	private TextUtils textUtils;
	private TableroService tableroService;

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.textUtils = new TextUtils();
		this.tableroService = new TableroServiceImpl();

		Label usernameLabel = new Label();
		usernameLabel.setText("Crucigrama facíl.");

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setVgap(5);
		gridPane.setHgap(5);

		int rows = 10;
		int cols = 10;

		TextField[][] inputs = new TextField[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				TextField textField = new TextField();
				textUtils.addTextLimiter(textField, 1);
				inputs[i][j] = textField;
				gridPane.add(textField, j, i);
			}
		}
		VBox contentBox = new VBox(10);

		String[] palabrasHorizontales = tableroService.getPreguntasHorizontales(Character.toString(DifficultEnum.LOW.getValue()))
				.split(",");
		
		String[] palabrasVerticales = tableroService.getPreguntasVerticales(Character.toString(DifficultEnum.LOW.getValue()))
				.split(",");

		for (String palabra : palabrasHorizontales) {
			Label palabraLabel = new Label(palabra);
			contentBox.getChildren().add(palabraLabel);
		}
		
		
		//TODO: cuadrar bien la posicion de las preguntas veritcales
		for (String palabra : palabrasVerticales) {
			Label palabraLabel = new Label(palabra);
			contentBox.getChildren().add(palabraLabel);
		}

		VBox root = new VBox(10);
		root.setPadding(new Insets(20));
		root.setAlignment(Pos.BOTTOM_CENTER);
		root.getChildren().addAll(usernameLabel, gridPane, contentBox);

		primaryStage.setScene(new Scene(root, 700, 550));
		primaryStage.setTitle("Crucigrama facíl");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}

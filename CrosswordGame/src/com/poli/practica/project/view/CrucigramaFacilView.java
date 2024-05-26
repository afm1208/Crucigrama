package com.poli.practica.project.view;

import java.util.regex.Pattern;

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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CrucigramaFacilView extends Application {
	
	private final String NUMBER_VALID_REGEX = "^[1-9]$";
	
	private TextUtils textUtils;
	private TableroService tableroService;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Integer puntaje = TextUtils.puntaje;
		
		this.textUtils = new TextUtils();
		this.tableroService = new TableroServiceImpl();

		Label lable = new Label();
		lable.setText("Crucigrama facíl.                                   "
				+ "Puntaje: ".concat(String.valueOf(puntaje)));
		

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setVgap(5);
		gridPane.setHgap(5);

		int rows = 12;
		int colums = 12;

		
		TextField[][] inputs = new TextField[rows][colums];

		String[] respuestas = tableroService.getRespuestas(Character.toString(DifficultEnum.LOW.getValue())).split(",");

		String[][] matrizRespuestas = new String [rows][colums];

		for (int i = 0; i < rows; i++) {
			String character = respuestas[i];
			for (int j = 0; j < character.length(); j++) {
				matrizRespuestas[i][j] = Character.toString(character.charAt(j));
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colums; j++) {
				
				if(Pattern.compile(NUMBER_VALID_REGEX).matcher(matrizRespuestas[i][j]).matches()) {
					
					TextField textField = new TextField();
					textField.setText(matrizRespuestas[i][j].concat("."));
					textField.setEditable(false);
					textField.setStyle("-fx-background-color: transparent; -fx-alignment: CENTER-RIGHT;");
					inputs[i][j] = textField;
					gridPane.add(textField, j, i);
					
				}else if (!matrizRespuestas[i][j].equals("*")) {
					TextField textField = new TextField();
					textUtils.addTextLimiter(textField, 1);
					inputs[i][j] = textField;
					gridPane.add(textField, j, i);
				}

			}
		}

		VBox contentBoxH = new VBox(13);
		VBox contentBoxV = new VBox(13);

		String[] palabrasHorizontales = tableroService
				.getPreguntasHorizontales(Character.toString(DifficultEnum.LOW.getValue())).split(",");

		String[] palabrasVerticales = tableroService
				.getPreguntasVerticales(Character.toString(DifficultEnum.LOW.getValue())).split(",");

		for (String palabra : palabrasHorizontales) {
			Label palabraLabel = new Label(palabra.concat("."));
			contentBoxH.getChildren().add(palabraLabel);
		}

		// TODO: cuadrar bien la posicion de las preguntas veritcales
		for (String palabra : palabrasVerticales) {
			Label palabraLabel = new Label(palabra.concat("."));
			contentBoxV.getChildren().add(palabraLabel);
		}

		HBox container = new HBox();
		HBox.setMargin(contentBoxV, new Insets(0, 0, 0, 50));
		container.getChildren().addAll(contentBoxH, contentBoxV);

		VBox root = new VBox(10);
		root.setPadding(new Insets(20));
		root.setAlignment(Pos.BOTTOM_CENTER);
		root.getChildren().addAll(lable, gridPane, container);

		primaryStage.setScene(new Scene(root, 1055, 650));
		primaryStage.setTitle("Crucigrama facíl");
		primaryStage.show();

		do {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < colums; j++) {
					if (inputs[i][j] != null) {
						textUtils.validateLetter(inputs[i][j], matrizRespuestas[i][j], lable);
					}
				}
			}
		} while (false);
	}

	public static void main(String[] args) {
		launch(args);
	}

}

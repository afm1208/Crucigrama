package com.poli.practica.project;

import com.poli.practica.project.view.TableroView;

import javafx.application.Application;
import javafx.stage.Stage;

public class PrincipalApplication extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		TableroView tableroView = new TableroView();
		tableroView.start(arg0);
	}

	public static void main(String[] args) {
		launch(args);
	}

}

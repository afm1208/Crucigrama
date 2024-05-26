package com.poli.practica.project.utils;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TextUtils {

	public static Integer puntaje = 0;

	public void addTextLimiter(final TextField tf, final int maxLength) {
		tf.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (tf.getText().length() > maxLength) {
					String s = tf.getText().substring(0, maxLength);
					tf.setText(s);
				}
			}
		});
	}

	public void validateLetter(TextField tf, String letter, Label lable) {
		tf.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (tf.getText().equals(letter)) {
					tf.setStyle("-fx-text-fill: white;-fx-background-color: green;");
					puntaje = puntaje + 10;
					lable.setText("Crucigrama facíl.                              "
							+ "Puntaje: ".concat(String.valueOf(puntaje)));
					tf.setEditable(false);
				} else {
					tf.setStyle("-fx-background-color: white;");
				}
			}
		});
	}

}

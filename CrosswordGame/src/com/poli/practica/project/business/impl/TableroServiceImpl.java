package com.poli.practica.project.business.impl;

import com.poli.practica.project.business.TableroService;
import com.poli.practica.project.utils.constant.DifficultEnum;

public class TableroServiceImpl implements TableroService {
	

	@Override
	public String seleccionarDificultad(Integer dificultad) {
		
		String diff = null;
		
		switch (dificultad) {
		case 1:
			diff = DifficultEnum.FACIL.name();
		case 2:
			diff = DifficultEnum.MEDIO.name();
		case 3:
			diff = DifficultEnum.DIFICIL.name();
		default:
			diff = "Escoger una dificultad valida.";
		}
		
		return diff;
	}
	
	@Override
	public String[][] generarMatrizJuego(DifficultEnum dificultad) {

		String[][] matriz = null;

		switch (dificultad) {
		case FACIL:
			matriz = new String[10][10];
		case MEDIO:
			matriz = new String[15][15];
		case DIFICIL:
			matriz = new String[20][20];
		default:
			break;
		}
		return matriz;

	}

	@Override
	public boolean validarPalabra(String palabra, Integer posicionInicial, Integer posicionFinal, DifficultEnum dificultad) {
		return false;
		
		//validar mejor la logica
 
	}


}

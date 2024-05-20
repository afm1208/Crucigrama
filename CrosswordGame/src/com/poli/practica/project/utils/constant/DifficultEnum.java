package com.poli.practica.project.utils.constant;

public enum DifficultEnum {
	
	LOW ('L'),
	MEDIUM ('M'),
	HARD('H');
	
	private char value;
	
	private DifficultEnum(char value) {
		this.value = value;
	}
	
	public char getValue() {
        return this.value;
    }
}

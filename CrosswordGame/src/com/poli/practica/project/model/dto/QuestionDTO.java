package com.poli.practica.project.model.dto;

public class QuestionDTO {

	private Integer id;
	private String word;
	private String difficult;
	private String category;
	private Integer start_position;
	private Boolean orientation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDifficult() {
		return difficult;
	}

	public void setDifficult(String difficult) {
		this.difficult = difficult;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getStart_position() {
		return start_position;
	}

	public void setStart_position(Integer start_position) {
		this.start_position = start_position;
	}

	public Boolean getOrientation() {
		return orientation;
	}

	public void setOrientation(Boolean orientation) {
		this.orientation = orientation;
	}

}

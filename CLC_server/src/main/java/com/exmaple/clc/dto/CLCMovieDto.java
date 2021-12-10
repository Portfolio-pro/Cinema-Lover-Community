package com.exmaple.clc.dto;

public class CLCMovieDto {

	private String movie_id;
	private String title;
	private String genres;
	private String runtime;
	private String year;
	private String summary;
	private String image;

	public CLCMovieDto() {}
	
	public CLCMovieDto(String movie_id, String title, String genres, String runtime, 
						String year, String summary, String image) {
		this.movie_id = movie_id;
		this.title = title;
		this.genres = genres;
		this.runtime = runtime;
		this.year = year;
		this.summary = summary;
		this.image = image;
	}

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getMedium_cover_image() {
		return image;
	}

	public void setMedium_cover_image(String medium_cover_image) {
		this.image = image;
	}	
	
}

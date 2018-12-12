package com.registercrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* * This is our model class and it corresponds to Country table in database */
@Entity
@Table(name = "MOVIE")
public class Movie {

	@Id
	@Column(name = "id")

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "movieName")
	String movieName;

	@Column(name = "movieGenre")
	String movieGenre;

	@Column(name = "likes")
	int likes;

	public Movie() {
		super();
	}

	public Movie(int i, String movieName, String movieGenre, int likes) {
		super();
		this.id = i;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.likes = likes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
}

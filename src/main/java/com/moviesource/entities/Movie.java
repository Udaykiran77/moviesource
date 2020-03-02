package com.moviesource.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Long movieId;

	private Double budget;
	private String imdbId;
	private Double popularity;
	private LocalDate releaseDate;
	private String title;
	private Double voteAverage;
	private Double voteCount;

	public Movie() {

	}
}

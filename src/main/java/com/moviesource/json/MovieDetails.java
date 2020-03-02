package com.moviesource.json;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MovieDetails {

	@JsonProperty("id")
	private Long movieId;

	@JsonProperty("budget")
	private Double budget;

	@JsonProperty("imdb_id")
	private String imdbId;

	private Double popularity;

	@JsonProperty("release_date")
	private LocalDate releaseDate;

	private String title;

	@JsonProperty("vote_average")
	private Double voteAverage;

	@JsonProperty("vote_count")
	private Double voteCount;

	public MovieDetails() {
	}
}
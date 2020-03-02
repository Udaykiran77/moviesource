package com.moviesource.json;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TopRatedMovie {

	private Double popularity;

	@JsonProperty("vote_count")
	private Integer voteCount;

	@JsonProperty("id")
	private Integer movieId;

	@JsonProperty("vote_average")
	private Double voteAverage;

	@JsonProperty("release_date")
	private LocalDate releaseDate;

	private String title;

	public TopRatedMovie() {
	}
}
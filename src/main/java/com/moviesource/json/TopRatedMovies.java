package com.moviesource.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TopRatedMovies {
	private Integer page;

	@JsonProperty("total_results")
	private Integer totalResults;

	@JsonProperty("total_pages")
	private Integer totalPages;

	@JsonProperty("results")
	private List<TopRatedMovie> movies;

	public TopRatedMovies() {
	}
}
package com.moviesource;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.moviesource.json.MovieDetails;
import com.moviesource.json.TopRatedMovie;
import com.moviesource.json.TopRatedMovies;

@Component
public class TopRatedMoviesFetcher implements ApplicationRunner {

	@Autowired
	private RestTemplate restTemplate;

	public void run(ApplicationArguments args) throws Exception {
		int page = 1;
		TopRatedMovies topRatedMovies = fetchTopRatedMoviesByPage(page);

		int totalPages = topRatedMovies.getTotalPages();

		List<TopRatedMovie> top20Movies = new ArrayList<>();
		LocalDate fiveYears = LocalDate.now().minus(5, ChronoUnit.YEARS).minusDays(1);

		do {
			topRatedMovies.getMovies().forEach(movie -> {
				if (movie.getReleaseDate().isAfter(fiveYears) && top20Movies.size() < 20) {
					top20Movies.add(movie);
				}
			});
			if (top20Movies.size() == 20)
				break;

			page++;
			topRatedMovies = fetchTopRatedMoviesByPage(page);
		} while (page <= totalPages);

		top20Movies.forEach(movie -> {
			MovieDetails movieDetails = fetchMovieDetails(movie.getMovieId());
			System.out.println(movieDetails.toString());
		}

		);
	}

	private TopRatedMovies fetchTopRatedMoviesByPage(int page) {
		return restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/top_rated?api_key=aa0ea741dcbdabdf6fd9953b60e629cf&language=en-US&page="
						+ page,
				TopRatedMovies.class);
	}

	private MovieDetails fetchMovieDetails(Integer movieId) {
		return restTemplate.getForObject(String.format(
				"https://api.themoviedb.org/3/movie/%s?api_key=aa0ea741dcbdabdf6fd9953b60e629cf&language=en-US",
				movieId), MovieDetails.class);
	}
}
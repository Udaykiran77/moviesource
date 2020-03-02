package com.moviesource.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.moviesource.entities.Movie;

@RepositoryRestResource
public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
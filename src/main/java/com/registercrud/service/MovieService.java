package com.registercrud.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.registercrud.model.Movie;
import com.registercrud.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("movieService")

public class MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Transactional
	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		Iterable<Movie> moviesIterable = movieRepository.findAll();
		Iterator<Movie> moviesIterator = moviesIterable.iterator();
		while (moviesIterator.hasNext()) {
			movies.add(moviesIterator.next());
		}
		return movies;
	}

	@Transactional
	public Movie getMovie(int id) {
		return movieRepository.findOne(id);
	}

	@Transactional
	public void addMovie(Movie movie) {
		movieRepository.save(movie);
	}

	@Transactional
	public void updateMovie(Movie movie) {
		movieRepository.save(movie);
	}

	@Transactional
	public void deleteMovie(int id) {
		movieRepository.delete(id);
	}
}

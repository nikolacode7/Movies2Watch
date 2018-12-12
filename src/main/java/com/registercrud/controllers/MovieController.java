package com.registercrud.controllers;

import java.util.List;
import com.registercrud.model.Movie;
import com.registercrud.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class MovieController {
    Movie movie;
	@Autowired
	MovieService movieService;

	@RequestMapping(value = { "/getAllMovies" }, method = RequestMethod.GET, headers = "Accept=application/json")
	public String getMovies(Model model) {
		List<Movie> listOfMovies = movieService.getAllMovies();
		model.addAttribute("movie", new Movie());
		model.addAttribute("listOfMovies", listOfMovies);
		return "movieDetails";
	}

	@RequestMapping(value = { "/preview" }, method = RequestMethod.GET, headers = "Accept=application/json")
	public String getMoviesPreview(Model model) {
		List<Movie> listOfMovies = movieService.getAllMovies();
		model.addAttribute("movie", new Movie());
		model.addAttribute("listOfMovies", listOfMovies);
		return "preview";
	}

	@RequestMapping(value = "/getMovie/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Movie getMovieById(@PathVariable int id) {
		return movieService.getMovie(id);
	}

	@RequestMapping(value = "/addMovie", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addMovie(@ModelAttribute("movie") Movie movie) {
		if (movie.getId() == 0) {
			movieService.addMovie(movie);
		}
		else {
			movieService.updateMovie(movie);
		}
		return "redirect:/getAllMovies";
	}

	@RequestMapping(value = "/updateMovie/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateMovie(@PathVariable("id") int id, Model model) {
		model.addAttribute("movie", this.movieService.getMovie(id));
		model.addAttribute("listOfMovies", this.movieService.getAllMovies());
		return "movieDetails";
	}
	
	@RequestMapping(value = "/deleteMovie/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteMovie(@PathVariable("id") int id) {
		movieService.deleteMovie(id);
		return "redirect:/getAllMovies";
	}
}

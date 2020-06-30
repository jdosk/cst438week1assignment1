package com.example.cst438week1assignment1;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Movies {    // localhost:8080/movies

  @Autowired
  MovieRepository movieRepository;

  @GetMapping("/movies")
  public String getAllMovies(Model model) {
    Iterable<Movie> movies = movieRepository.findAllMovieRatingsOrderByTitleDateDesc();
    model.addAttribute("movies", movies);
    return "movie_list";
  }

  @GetMapping("/movies/new")
  public String createMovie(Model model) {
    Movie movie = new Movie();
    model.addAttribute("movie", movie);
    return "movie_form";
  }

  @PostMapping("/movies")
  public String processMovieForm(@Valid Movie movie, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "movie_form";
    }
    movie.setDate(new java.util.Date().toString());
    movieRepository.save(movie);
    return "movie_show";
  }
}

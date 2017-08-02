package com.theironyard.to_the_movies.controllers;

import com.theironyard.to_the_movies.Movie;
import com.theironyard.to_the_movies.ResultsPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BasicController {
    private static final String API_TOKEN = "be2a38521a7859c95e2d73c48786e4bb";
    private static final String NOW_PLAYING_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + API_TOKEN;
    private static RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(path = "/now-playing", method = RequestMethod.GET)
    public String nowPlaying(Model model) {
        model.addAttribute("movies", getMovies(NOW_PLAYING_URL));
        return "now-playing";
    }

    @RequestMapping(path = "/medium-popular-long-name", method = RequestMethod.GET)
    public String mediumPopularLongName(Model model) {
        model.addAttribute("movies", getMovies(NOW_PLAYING_URL)
                .stream()
                .filter(movie -> movie.getTitle().length() > 9)
                .filter(movie -> movie.getPopularity() > 29 && movie.getPopularity() < 81)
                .collect(Collectors.toList()));
        return "medium-popular-long-name";
    }

    public static List<Movie> getMovies(String route) {
        ResultsPage resultsPage = restTemplate.getForObject(route, ResultsPage.class);
        return resultsPage.getResults();
    }
}

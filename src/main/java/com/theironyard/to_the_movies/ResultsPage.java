package com.theironyard.to_the_movies;

import java.util.List;

public class ResultsPage {
    private List<Movie> results;

    public ResultsPage() {
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        String output = "";
        for (Movie movie : results) {
            output += "Title: " + movie.getTitle() + "\n" +
                    "Poster Path: " + movie.getPosterPath() + "\n" +
                    "Overview: " + movie.getOverview() + "\n" +
                    "Popularity: " + movie.getPopularity() + "\n\n";
        }
        return output;
    }
}

package com.example.moviepractice.services;

import com.example.moviepractice.movies.Movie;
import com.example.moviepractice.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.getMovies();
    }
}

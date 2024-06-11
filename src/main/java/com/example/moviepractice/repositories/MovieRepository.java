package com.example.moviepractice.repositories;

import com.example.moviepractice.movies.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Movie> getMovies(){
        String query = "SELECT * FROM movie;";
        RowMapper rowMapper = new BeanPropertyRowMapper(Movie.class);
        return jdbcTemplate.query(query, rowMapper);
    }
}

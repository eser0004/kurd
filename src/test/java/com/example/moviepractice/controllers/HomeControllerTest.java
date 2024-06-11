package com.example.moviepractice.controllers;

import com.example.moviepractice.movies.Movie;
import com.example.moviepractice.services.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testIndex() throws Exception {
        // Mocking the MovieService
        List<Movie> movies = Arrays.asList(
                new Movie(1, "Movie 1", "Description 1", 2020),
                new Movie(2, "Movie 2", "Description 2", 2021)
        );
        when(movieService.getMovies()).thenReturn(movies);

        // Perform GET request and verify the response
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home/index"))
                .andExpect(model().attributeExists("movies"))
                .andExpect(model().attribute("movies", hasSize(2)));
    }
}
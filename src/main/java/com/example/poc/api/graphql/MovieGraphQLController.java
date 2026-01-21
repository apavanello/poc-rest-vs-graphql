package com.example.poc.api.graphql;

import com.example.poc.domain.Actor;
import com.example.poc.domain.Movie;
import com.example.poc.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MovieGraphQLController {

    private final MovieRepository movieRepository;

    @QueryMapping
    public List<Movie> movies() {
        return movieRepository.findAll();
    }

    @QueryMapping
    public Movie movieById(@Argument UUID id) {
        return movieRepository.findById(id).orElse(null);
    }

    @SchemaMapping
    public List<Actor> actors(Movie movie) {
        // This log confirms when the "actors" field is actually requested
        log.info("Fetching actors for movie: {}", movie.getTitle());
        return movie.getActors().stream().toList();
    }

    @org.springframework.graphql.data.method.annotation.MutationMapping
    public Movie createMovie(@Argument MovieInput input) {
        Movie movie = new Movie();
        movie.setTitle(input.title());
        movie.setGenre(input.genre());
        movie.setReleaseYear(input.releaseYear());
        return movieRepository.save(movie);
    }

    public record MovieInput(String title, String genre, Integer releaseYear) {}
}

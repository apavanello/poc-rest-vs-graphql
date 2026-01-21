package com.example.poc.service;

import com.example.poc.domain.Actor;
import com.example.poc.domain.Movie;
import com.example.poc.domain.Review;
import com.example.poc.repository.ActorRepository;
import com.example.poc.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (movieRepository.count() > 0) {
            log.info("Database already populated. Skipping initialization.");
            return;
        }

        log.info("Initializing Database with Dummy Data...");

        // Create Actors
        List<Actor> actors = IntStream.range(1, 51).mapToObj(i -> {
            Actor actor = new Actor();
            actor.setName("Actor " + i);
            actor.setBirthDate(LocalDate.now().minusYears(20 + i));
            return actor;
        }).collect(Collectors.toList());
        actorRepository.saveAll(actors);

        // Create Movies
        Random random = new Random();
        List<Movie> movies = IntStream.range(1, 21).mapToObj(i -> {
            Movie movie = new Movie();
            movie.setTitle("Movie Title " + i);
            movie.setGenre(random.nextBoolean() ? "Action" : "Drama");
            movie.setReleaseYear(2000 + i);

            // Assign random actors (3 to 6 actors per movie)
            int numActors = 3 + random.nextInt(4);
            Set<Actor> movieActors = new HashSet<>();
            for (int j = 0; j < numActors; j++) {
                movieActors.add(actors.get(random.nextInt(actors.size())));
            }
            movie.setActors(movieActors);

            // Add reviews
            IntStream.range(1, 4).forEach(r -> {
                Review review = new Review();
                review.setComment("Review " + r + " for Movie " + i);
                review.setRating(1 + random.nextInt(5));
                review.setMovie(movie);
                movie.getReviews().add(review);
            });

            return movie;
        }).collect(Collectors.toList());

        movieRepository.saveAll(movies);
        log.info("Database Initialization Complete: {} Movies, {} Actors created.", movies.size(), actors.size());
    }
}

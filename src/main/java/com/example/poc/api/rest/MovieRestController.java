package com.example.poc.api.rest;

import com.example.poc.api.rest.dto.ActorResponseDTO;
import com.example.poc.api.rest.dto.MovieResponseDTO;
import com.example.poc.domain.Movie;
import com.example.poc.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieRestController {

    private final MovieRepository movieRepository;

    @GetMapping
    public List<MovieResponseDTO> listMovies() {
        return movieRepository.findAll().stream()
                .map(MovieResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> getMovie(@PathVariable UUID id) {
        return movieRepository.findById(id)
                .map(MovieResponseDTO::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/actors")
    public ResponseEntity<List<ActorResponseDTO>> getMovieActors(@PathVariable UUID id) {
        return movieRepository.findById(id)
                .map(movie -> movie.getActors().stream()
                        .map(ActorResponseDTO::fromEntity)
                        .collect(Collectors.toList()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MovieResponseDTO> createMovie(@RequestBody com.example.poc.api.rest.dto.MovieCreateRequestDTO request) {
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setGenre(request.getGenre());
        movie.setReleaseYear(request.getReleaseYear());
        
        Movie saved = movieRepository.save(movie);
        return ResponseEntity.ok(MovieResponseDTO.fromEntity(saved));
    }

    @GetMapping("/heavy")
    public List<com.example.poc.api.rest.dto.MovieHeavyResponseDTO> listMoviesHeavy() {
        return movieRepository.findAll().stream()
                .map(com.example.poc.api.rest.dto.MovieHeavyResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }
}

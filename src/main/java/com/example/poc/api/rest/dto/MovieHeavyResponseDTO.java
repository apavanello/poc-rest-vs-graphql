package com.example.poc.api.rest.dto;

import com.example.poc.domain.Movie;
import lombok.Data;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class MovieHeavyResponseDTO {
    private UUID id;
    private String title;
    private String genre;
    private Integer releaseYear;
    // Overfetching: Including full lists of objects even if not requested
    private List<ActorResponseDTO> actors;
    private List<String> reviews;
    private String metadata; // Dummy large field

    public static MovieHeavyResponseDTO fromEntity(Movie movie) {
        MovieHeavyResponseDTO dto = new MovieHeavyResponseDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setGenre(movie.getGenre());
        dto.setReleaseYear(movie.getReleaseYear());
        
        dto.setActors(movie.getActors().stream()
                .map(ActorResponseDTO::fromEntity)
                .collect(Collectors.toList()));
        
        dto.setReviews(movie.getReviews().stream()
                .map(r -> r.getRating() + ": " + r.getComment())
                .collect(Collectors.toList()));
                
        dto.setMetadata("X".repeat(1000)); // Simulate 1KB of extra data per movie
        return dto;
    }
}

package com.example.poc.api.rest.dto;

import com.example.poc.domain.Movie;
import lombok.Data;

import java.util.UUID;

@Data
public class MovieResponseDTO {
    private UUID id;
    private String title;
    private String genre;
    private Integer releaseYear;

    public static MovieResponseDTO fromEntity(Movie movie) {
        MovieResponseDTO dto = new MovieResponseDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setGenre(movie.getGenre());
        dto.setReleaseYear(movie.getReleaseYear());
        return dto;
    }
}

package com.example.poc.api.rest.dto;

import lombok.Data;

@Data
public class MovieCreateRequestDTO {
    private String title;
    private String genre;
    private Integer releaseYear;
}

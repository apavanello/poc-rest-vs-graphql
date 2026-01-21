package com.example.poc.api.rest.dto;

import com.example.poc.domain.Actor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ActorResponseDTO {
    private UUID id;
    private String name;
    private LocalDate birthDate;

    public static ActorResponseDTO fromEntity(Actor actor) {
        ActorResponseDTO dto = new ActorResponseDTO();
        dto.setId(actor.getId());
        dto.setName(actor.getName());
        dto.setBirthDate(actor.getBirthDate());
        return dto;
    }
}

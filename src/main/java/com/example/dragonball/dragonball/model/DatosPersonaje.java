package com.example.dragonball.dragonball.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosPersonaje(
        @JsonAlias("name")
        String nombre,
        @JsonAlias("ki")
        String ki,
        @JsonAlias("race")
        String raza,
        @JsonAlias("description")
        String descripcion
) {
}

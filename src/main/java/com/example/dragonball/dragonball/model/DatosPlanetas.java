package com.example.dragonball.dragonball.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosPlanetas(
        @JsonAlias("name")
        String nombre,
        @JsonAlias("isDestroyed")
        boolean desutruido
) {
}

package com.example.dragonball.dragonball.repositorio;

import com.example.dragonball.dragonball.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRepository extends JpaRepository<Personaje, Long> {
    List<Personaje> findTopByOrderByKiDesc();
    Personaje findByNombreIgnoreCase(String nombre);
}

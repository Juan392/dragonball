package com.example.dragonball.dragonball.model;

import com.example.dragonball.dragonball.service.GeminiAI;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name="personaje")
public class Personaje{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @Column(unique = true)
    private String nombre;
    private String ki;
    private String raza;
    @Column(length = 1000)
    private String descripcion;

    public Personaje() {
    }

    public Personaje(DatosPersonaje datosPersonaje) {
        this.nombre = datosPersonaje.nombre();
        this.ki = datosPersonaje.ki();
        this.raza = datosPersonaje.raza();
        this.descripcion = GeminiAI.obtenerTraduccion(datosPersonaje.descripcion());
    }

    public Integer kiComoEntero() {
        // Elimina los puntos y convierte a Integer
        return Integer.parseInt(ki.replace(".", ""));
    }


    @Override
    public String toString() {
        return "\nnombre='" + nombre + '\'' +
                ", ki='" + ki + '\'' +
                ", raza='" + raza + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getKi() {
        return ki;
    }

    public void setKi(String ki) {
        this.ki = ki;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

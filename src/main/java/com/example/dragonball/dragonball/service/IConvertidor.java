package com.example.dragonball.dragonball.service;

public interface IConvertidor {
    <T>T ConvertirDatos(String json, Class<T> clase);
}

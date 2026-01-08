package com.example.dragonball.dragonball.service;

import com.example.dragonball.dragonball.model.Personaje;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.jspecify.annotations.Nullable;

public class GeminiAI {
    private static final String MODELO = "gemini-2.0-flash-lite";
    private static final String API = "";


    public static String conexion(Client cliente, String prompt){
        try{
            GenerateContentResponse respuesta = cliente.models.generateContent(MODELO, prompt, null);
            if(!respuesta.text().isEmpty()){
                return respuesta.text();
            }
        }catch (Exception e){
            System.out.println("Error al obtener la respuesta de Gemini AI: " + e.getMessage());
        }
        return null;
    }

    public static String obtenerTraduccion(String descripcion){
        String prompt = "Necesito que me des la traduccion al español directamente de: " + descripcion;
        Client cliente = new Client.Builder().apiKey(API).build();
        return conexion(cliente, prompt);
    }

    public static String batalla(Personaje personaje1, Personaje personaje2){
        String prompt= "Quiero que simules una batalla entre: "+personaje1.getNombre() + " que tiene un ki de: "+ personaje1.getKi()+ "y " + personaje2.getNombre()+ " que tiene un ki de: "+personaje2.getKi()+". Trata de evitar usar markdown o negritas";
        Client cliente = new Client.Builder().apiKey(API).build();
        return conexion(cliente, prompt);
    }
}



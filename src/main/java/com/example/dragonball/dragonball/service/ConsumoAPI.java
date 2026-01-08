package com.example.dragonball.dragonball.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public String consumirAPI(String url){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> res = null;
        try{
            res = client.send(req, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            System.out.println("Ocurrio un error al consumir el API: " + e.getMessage());
        }

        String json = res.body();
        return json;
    }
}

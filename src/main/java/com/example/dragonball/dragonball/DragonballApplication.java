package com.example.dragonball.dragonball;

import com.example.dragonball.dragonball.principal.Menu;
import com.example.dragonball.dragonball.repositorio.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DragonballApplication implements CommandLineRunner {
	@Autowired
	private IRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DragonballApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Menu principal = new Menu(repository);
		principal.mostrarMenu();

	}
}

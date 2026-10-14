package com.example.Taller2;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CargaData implements CommandLineRunner {

    private final RegistroRepository repository;

    public CargaData(RegistroRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Agregando 1,000,000 de filas...");
        List<Registro> registros = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            registros.add(new Registro("Nombre " + i, "Descripción del registro " + i));
        }
        repository.saveAll(registros);
        System.out.println("Filas agregadas.");
    }
}
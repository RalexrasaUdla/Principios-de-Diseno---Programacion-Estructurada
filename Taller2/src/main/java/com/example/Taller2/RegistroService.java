package com.example.Taller2;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegistroService {

    private final RegistroRepository repository;

    public RegistroService(RegistroRepository repository) {
        this.repository = repository;
    }

    public List<Registro> obtenerSinCache() {
        return repository.findAll();
    }

    @Cacheable("registros")
    public List<Registro> obtenerConCache() {
        return repository.findAll();
    }
}
package com.example.Taller2;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TestController {

    private final RegistroService service;

    public TestController(RegistroService service) {
        this.service = service;
    }

    @GetMapping("/test-cache")
    public String testCache() {
  
        long inicioSinCache = System.currentTimeMillis();
        service.obtenerSinCache();
        long finSinCache = System.currentTimeMillis();
        long tiempoSinCache = finSinCache - inicioSinCache;

        //service.obtenerConCache(); 

        long inicioConCache = System.currentTimeMillis();
        service.obtenerConCache();
        long finConCache = System.currentTimeMillis();
        long tiempoConCache = finConCache - inicioConCache;

        return String.format(
            "Tiempo de lectura SIN caché (Directo a BD): %d ms <br>Tiempo de lectura CON caché (Desde RAM): %d ms", 
            tiempoSinCache, tiempoConCache
        );
    }
}
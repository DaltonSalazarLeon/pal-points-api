package com.api.pal_points.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Pruebas {

    @GetMapping("/")
    public String hello() {
        return "Hola";
    }
}
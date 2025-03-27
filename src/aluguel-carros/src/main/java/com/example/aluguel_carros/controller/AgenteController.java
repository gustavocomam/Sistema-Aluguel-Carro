package com.example.aluguel_carros.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agente")
public class AgenteController {

    @GetMapping
    public String mostrarAgente() {
        return "agente";
    }

}

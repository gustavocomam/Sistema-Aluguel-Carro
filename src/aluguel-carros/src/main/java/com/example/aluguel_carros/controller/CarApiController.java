package com.example.aluguel_carros.controller;

import com.example.aluguel_carros.model.CarroModel;
import com.example.aluguel_carros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarApiController {
    @Autowired
    private CarroService carroService;
@GetMapping
public List<CarroModel> getCars(){
    return carroService.ListarCarros();
    }
}

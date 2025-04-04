package com.example.aluguel_carros.controller;

import com.example.aluguel_carros.model.CarModel;
import com.example.aluguel_carros.repository.CarRepository;
import com.example.aluguel_carros.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarApiController {
    @Autowired
    private CarService carService;
@GetMapping
public List<CarModel> getCars(){
    return carService.ListarCarros();
}
}

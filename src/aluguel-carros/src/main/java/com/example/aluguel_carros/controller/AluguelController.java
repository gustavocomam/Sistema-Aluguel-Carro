package com.example.aluguel_carros.controller;

import com.example.aluguel_carros.model.AluguelModel;
import com.example.aluguel_carros.model.CarModel;
import com.example.aluguel_carros.repository.CarRepository;
import com.example.aluguel_carros.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("aluguel-cliente")
public class AluguelController {
    @Autowired
    private AluguelService aluguelService;
    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public String mostrarAluguel(){
        return "AluguelCliente";
    }

    @GetMapping("/aluguel/{id}")
    public String mostrarAluguel(@PathVariable Long id, Model model){
        CarModel car = carRepository.findById(id).orElse(null);
        if (car == null) {
            return "erro";
        }


        model.addAttribute("carro", car);


        return "AluguelCliente";
    }

    @PostMapping("/aluguel")
    public String salvarAluguel(@ModelAttribute AluguelModel aluguel){
        aluguelService.Aluguel(aluguel);
        return "AluguelCliente";
    }



}

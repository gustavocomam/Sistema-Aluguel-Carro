package com.example.aluguel_carros.controller;
import com.example.aluguel_carros.model.CarModel;
import com.example.aluguel_carros.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agente")
public class AgenteController {

    @Autowired
    private CarService carService;

    @GetMapping
    public String mostrarAgente() {
        return "Agente";
    }
    @PostMapping("/cadastrar-carro")
    public String addCarro(@ModelAttribute CarModel car) {
        carService.cadastrarCarro(car);
        System.out.println(car);
        return "redirect:/agente";
    }

}

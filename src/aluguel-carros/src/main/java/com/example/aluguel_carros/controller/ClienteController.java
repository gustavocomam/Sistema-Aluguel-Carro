package com.example.aluguel_carros.controller;

import com.example.aluguel_carros.model.CarModel;
import com.example.aluguel_carros.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import java.util.List;
@Controller
@RequestMapping("cliente")
public class ClienteController {


    @GetMapping
    public String mostrarCliente(){
        return "Cliente";
    }




}

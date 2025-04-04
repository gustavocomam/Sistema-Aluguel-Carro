package com.example.aluguel_carros.service;

import com.example.aluguel_carros.model.CarModel;
import com.example.aluguel_carros.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public void cadastrarCarro(CarModel car) {
        carRepository.save(car);
    }

    public List<CarModel> ListarCarros() {
        return carRepository.findByDisponivelTrue();
    }


}

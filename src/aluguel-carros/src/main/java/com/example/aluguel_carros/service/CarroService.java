package com.example.aluguel_carros.service;

import com.example.aluguel_carros.model.CarroModel;
import com.example.aluguel_carros.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    // Salvar um carro novo
    public void cadastrar(CarroModel carro) {
        carroRepository.save(carro);
    }

    // Listar todos os carros (para uso em reservas, por exemplo)
    public List<CarroModel> ListarCarros() {
        return carroRepository.findAll();
    }
}

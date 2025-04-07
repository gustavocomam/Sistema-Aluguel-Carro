package com.example.aluguel_carros.service;

import com.example.aluguel_carros.model.AluguelModel;
import com.example.aluguel_carros.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluguelService {
    @Autowired
    AluguelRepository aluguelRepository;

    public void Aluguel(AluguelModel aluguel) {
        aluguelRepository.save(aluguel);
    }

    public List<AluguelModel> ListarAlugueis() {
        return aluguelRepository.findAll();
    }

    public List<AluguelModel> ListarAlugueisPorCliete(String Cpf) {
        return  aluguelRepository.cpf(Cpf);
    }

}

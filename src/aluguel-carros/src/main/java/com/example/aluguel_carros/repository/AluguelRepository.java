package com.example.aluguel_carros.repository;
import com.example.aluguel_carros.model.AluguelModel;
import com.example.aluguel_carros.model.CarModel;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AluguelRepository extends JpaRepository<AluguelModel, Long>  {

    List<AluguelModel> cpf(String cpf);
}

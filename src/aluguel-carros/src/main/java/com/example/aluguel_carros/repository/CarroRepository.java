package com.example.aluguel_carros.repository;
import com.example.aluguel_carros.model.CarroModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<CarroModel, Long> {

List<CarroModel> findByDisponivelTrue();
}

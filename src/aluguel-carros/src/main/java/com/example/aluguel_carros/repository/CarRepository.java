package com.example.aluguel_carros.repository;
import com.example.aluguel_carros.model.CarModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarModel, Long> {

List<CarModel> findByDisponivelTrue();
}

package com.example.aluguel_carros.repository;

import com.example.aluguel_carros.model.PedidoModel;
import com.example.aluguel_carros.model.PedidoModel.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {

    List<PedidoModel> findByStatus(Status status);
}

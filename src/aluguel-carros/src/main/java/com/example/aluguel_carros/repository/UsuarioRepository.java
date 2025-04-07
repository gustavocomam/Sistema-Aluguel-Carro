package com.example.aluguel_carros.repository;

import com.example.aluguel_carros.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByEmail(String email); // busca usuário pelo e-mail
}

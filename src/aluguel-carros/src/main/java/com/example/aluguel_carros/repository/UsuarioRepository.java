package com.example.aluguel_carros.repository;
import com.example.aluguel_carros.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

    UsuarioModel findByEmail(String email);
}

package com.example.aluguel_carros.service;

import com.example.aluguel_carros.DTO.Usuario;
import com.example.aluguel_carros.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CadastroService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) {
     return  usuarioRepository.save(usuario);
    }


}

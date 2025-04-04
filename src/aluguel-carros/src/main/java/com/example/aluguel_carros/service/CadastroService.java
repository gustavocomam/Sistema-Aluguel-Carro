package com.example.aluguel_carros.service;

import com.example.aluguel_carros.model.UsuarioModel;
import com.example.aluguel_carros.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void cadastrarUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
    }


}

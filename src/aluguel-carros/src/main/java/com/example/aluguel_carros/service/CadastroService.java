package com.example.aluguel_carros.service;

import com.example.aluguel_carros.model.UsuarioModel;
import com.example.aluguel_carros.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    private final UsuarioRepository usuarioRepository;

    public CadastroService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrarUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario); // ✅ salva com ID gerado automaticamente
    }
}

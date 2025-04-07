package com.example.aluguel_carros.service;

import com.example.aluguel_carros.model.UsuarioModel;
import com.example.aluguel_carros.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final UsuarioRepository usuarioRepository;

    public LoginService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioModel autenticar(String email, String senha) {
        Optional<UsuarioModel> usuario = usuarioRepository.findByEmail(email);

        if (usuario.isPresent() && usuario.get().getSenha().equals(senha)) {
            return usuario.get();
        }

        return null;
    }
}

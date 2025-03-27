package com.example.aluguel_carros.service;

import com.example.aluguel_carros.DTO.Usuario;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final CadastroService cadastroService;

    public LoginService(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    public String Login(Usuario usuario) {
        for (int i = 0; i < cadastroService.getUsuarios().size(); i++) {
            Usuario u = cadastroService.getUsuarios().get(i);
            if (usuario.getEmail().equals(u.getEmail()) && usuario.getSenha().equals(u.getSenha())) {
                if (u.getTipo().equals(Usuario.TipoUsuario.AGENTE)) {
                    return "redirect:/agente";
                } else if (u.getTipo().equals(Usuario.TipoUsuario.CLIENTE)) {
                    System.out.println("Usuario logado com sucesso");
                }
            }
        }

        return "Caindo no ultimo return";
    }
}

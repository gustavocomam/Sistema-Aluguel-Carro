package com.example.aluguel_carros.service;

import com.example.aluguel_carros.DTO.Usuario;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final CadastroService cadastroService;

    public LoginService(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    public void Login(Usuario usuario) {
        for(int i = 0; i< cadastroService.getUsuarios().size(); i++){
            if(usuario.getEmail().equals(cadastroService.getUsuarios().get(i).getEmail()) && usuario.getSenha().equals(cadastroService.getUsuarios().get(i).getSenha())){
                System.out.println("Login com sucesso");
            }
        }

    }
}

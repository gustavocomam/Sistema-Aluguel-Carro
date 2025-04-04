package com.example.aluguel_carros.service;

import com.example.aluguel_carros.model.UsuarioModel;
import com.example.aluguel_carros.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final CadastroService cadastroService;

    public LoginService(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @Autowired
    private UsuarioRepository usuarioRepository;



    public String Login(UsuarioModel usuarioModelParametrer) {
    UsuarioModel usuarioModelFind = usuarioRepository.findByEmail(usuarioModelParametrer.getEmail());
     if(usuarioModelFind.getTipo().equals(UsuarioModel.TipoUsuario.AGENTE)) {
         if (usuarioModelParametrer.getSenha().equals(usuarioModelFind.getSenha())) {
                 return "redirect:/agente";
         }

     } else if(usuarioModelFind.getTipo().equals(UsuarioModel.TipoUsuario.CLIENTE)){
         if (usuarioModelParametrer.getSenha().equals(usuarioModelFind.getSenha())) {
             return "redirect:/cliente";
         }
        }

       return "usuario nao encontrado";
    }

}

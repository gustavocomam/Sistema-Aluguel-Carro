package com.example.aluguel_carros.controller;

import com.example.aluguel_carros.model.UsuarioModel;
import com.example.aluguel_carros.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


@GetMapping
    public String mostrarLogin(){
        return "Login";
    }

@PostMapping
  public String Login(@ModelAttribute UsuarioModel usuario) {
     return loginService.Login(usuario);
  }

}

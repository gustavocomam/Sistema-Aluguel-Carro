package com.example.aluguel_carros.controller;
import com.example.aluguel_carros.model.UsuarioModel;
import com.example.aluguel_carros.service.CadastroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    private final CadastroService cadastroService;

    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }


    @GetMapping()
    public String mostrarCadastro() {
        return "Cadastro";
    }
  @PostMapping()
    public String Cadastro(@ModelAttribute UsuarioModel usuario) {

     cadastroService.cadastrarUsuario(usuario);



      return "redirect:/login";
    }



}

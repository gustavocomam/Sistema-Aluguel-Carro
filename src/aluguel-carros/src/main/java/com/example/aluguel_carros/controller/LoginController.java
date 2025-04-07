package com.example.aluguel_carros.controller;

import com.example.aluguel_carros.model.UsuarioModel;
import com.example.aluguel_carros.service.CadastroService;
import com.example.aluguel_carros.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/usuario")
public class LoginController {

    private final LoginService loginService;
    private final CadastroService cadastroService;

    public LoginController(LoginService loginService, CadastroService cadastroService) {
        this.loginService = loginService;
        this.cadastroService = cadastroService;
    }

    // Página de login
    @GetMapping("/login")
    public String mostrarLogin(@RequestParam(required = false) String erro, Model model) {
        model.addAttribute("usuario", new UsuarioModel());
        model.addAttribute("erro", erro != null);
        return "Login";
    }

    // Processar login
    @PostMapping("/login")
    public String login(@ModelAttribute UsuarioModel usuarioForm, HttpSession session) {
        UsuarioModel usuario = loginService.autenticar(usuarioForm.getEmail(), usuarioForm.getSenha());

        if (usuario == null) {
            return "redirect:/usuario/login?erro=true";
        }

        session.setAttribute("usuario", usuario);
        session.setAttribute("clienteId", usuario.getId()); // Salvando ID na sessão

        if (usuario.getTipo() == UsuarioModel.TipoUsuario.AGENTE) {
            return "redirect:/adm";
        } else {
            return "redirect:/cliente";
        }
    }

    // Página de cadastro
    @GetMapping("/cadastro")
    public String mostrarCadastro(Model model) {
        model.addAttribute("usuario", new UsuarioModel()); // necessário pro th:object
        return "Cadastro";
    }

    // Processar cadastro
    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute UsuarioModel usuario) {
        cadastroService.cadastrarUsuario(usuario);
        return "redirect:/usuario/login";
    }
    @GetMapping("/logout")
    public String sair() {
        return "redirect:/";
    }
    @GetMapping("/reserva")
    public String mostrarReserva() {
        return "Reserva";
    }
}


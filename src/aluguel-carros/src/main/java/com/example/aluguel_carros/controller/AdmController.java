package com.example.aluguel_carros.controller;

import com.example.aluguel_carros.model.CarroModel;
import com.example.aluguel_carros.model.PedidoModel;
import com.example.aluguel_carros.service.CarroService;
import com.example.aluguel_carros.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/adm")
public class AdmController {

    private final CarroService carroService;
    private final PedidoService pedidoService;

    public AdmController(CarroService carroService, PedidoService pedidoService) {
        this.carroService = carroService;
        this.pedidoService = pedidoService;
    }

    // Exibe o painel do admin com as 3 caixas
    @GetMapping
    public String painelAdmin(Model model) {
        model.addAttribute("pedidosPendentes", pedidoService.listarPendentes());
        model.addAttribute("pedidosFinalizados", pedidoService.listarTodos());
        return "Agente"; // HTML já criado
    }

    // Cadastrar novo carro
    @PostMapping("/cadastrar-carro")
    public String cadastrarCarro(@ModelAttribute CarroModel carro) {
        carroService.cadastrar(carro);
        return "redirect:/adm";
    }

    // Aprovar pedido
    @PostMapping("/aprovar/{id}")
    public String aprovarPedido(@PathVariable Long id) {
        pedidoService.aprovarPedido(id);
        return "redirect:/adm";
    }

    // Recusar pedido
    @PostMapping("/recusar/{id}")
    public String recusarPedido(@PathVariable Long id) {
        pedidoService.recusarPedido(id);
        return "redirect:/adm";
    }
}

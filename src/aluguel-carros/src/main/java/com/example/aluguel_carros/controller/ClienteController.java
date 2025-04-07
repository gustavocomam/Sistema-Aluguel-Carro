package com.example.aluguel_carros.controller;

import com.example.aluguel_carros.model.PedidoModel;
import com.example.aluguel_carros.service.CarroService;
import com.example.aluguel_carros.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private CarroService carroService;

    @Autowired
    private PedidoService pedidoService;

    // Página inicial do cliente
    @GetMapping
    public String clienteHome() {
        return "cliente"; // cliente.html
    }

    // Página para nova reserva
    @GetMapping("/realizar-pedido")
    public String novaReserva(Model model) {
        model.addAttribute("carros", carroService.ListarCarros());
        model.addAttribute("pedido", new PedidoModel()); // necessário para o form
        return "realizarPedido";
    }

    // Processar reserva (pedido)
    @PostMapping("/reservar")
    public String fazerReserva(@ModelAttribute PedidoModel pedido) {
        pedidoService.salvarPedido(pedido);
        return "redirect:/cliente";
    }

    // Página para visualizar reservas do cliente
    @GetMapping("/minhas-reservas")
    public String minhasReservas(Model model) {
        model.addAttribute("pedidos", pedidoService.listarTodos()); // você pode filtrar por cliente futuramente
        return "cliente/minhas-reservas";
    }

}

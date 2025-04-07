package com.example.aluguel_carros.controller;

import java.util.List;
import com.example.aluguel_carros.model.PedidoModel;
import com.example.aluguel_carros.model.UsuarioModel;
import com.example.aluguel_carros.service.CarroService;
import com.example.aluguel_carros.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;

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
    public String fazerReserva(@ModelAttribute PedidoModel pedido, HttpSession session) {
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/usuario/login";
        }

        pedido.setClienteId(usuario.getId()); // ✅ Setando o ID do cliente
        pedido.setNomeCliente(usuario.getNome()); // opcional, se você estiver usando também
        pedidoService.salvarPedido(pedido);

        return "redirect:/cliente";
    }

    // Página para visualizar reservas do cliente
    @GetMapping("/minhas-reservas")
    public String minhasReservas(Model model, HttpSession session) {
        Long clienteId = (Long) session.getAttribute("clienteId");
        if (clienteId == null) {
            return "redirect:/usuario/login";
        }
        List<PedidoModel> pedidos = pedidoService.buscarPedidosPorClienteId(clienteId);
        model.addAttribute("pedidos", pedidos);
        return "historicoPedido";
    }
}

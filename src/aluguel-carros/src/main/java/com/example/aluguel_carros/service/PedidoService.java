package com.example.aluguel_carros.service;

import com.example.aluguel_carros.model.PedidoModel;
import com.example.aluguel_carros.model.PedidoModel.Status;
import com.example.aluguel_carros.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // Criar novo pedido
    public void salvarPedido(PedidoModel pedido) {
        pedido.setStatus(Status.PENDENTE); // define como pendente ao criar
        pedidoRepository.save(pedido);
    }

    // Listar pedidos pendentes
    public List<PedidoModel> listarPendentes() {
        return pedidoRepository.findByStatus(Status.PENDENTE);
    }

    // Listar todos os pedidos (histórico)
    public List<PedidoModel> listarTodos() {
        return pedidoRepository.findAll();
    }

    // Aprovar pedido
    public void aprovarPedido(Long id) {
        Optional<PedidoModel> pedido = pedidoRepository.findById(id);
        pedido.ifPresent(p -> {
            p.setStatus(Status.APROVADO);
            pedidoRepository.save(p);
        });
    }

    // Recusar pedido
    public void recusarPedido(Long id) {
        Optional<PedidoModel> pedido = pedidoRepository.findById(id);
        pedido.ifPresent(p -> {
            p.setStatus(Status.RECUSADO);
            pedidoRepository.save(p);
        });
    }

    public List<PedidoModel> buscarPedidosPorClienteId(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }
}

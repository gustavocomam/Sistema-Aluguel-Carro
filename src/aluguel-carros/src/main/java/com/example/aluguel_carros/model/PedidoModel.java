package com.example.aluguel_carros.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;

    private String nomeCliente;

    private String modeloVeiculo;

    private LocalDate dataRetirada;

    private LocalDate dataDevolucao;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDENTE,
        APROVADO,
        RECUSADO
    }
}

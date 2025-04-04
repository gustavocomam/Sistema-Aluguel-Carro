package com.example.aluguel_carros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "carros")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula;


    private int ano;
    private String marca;
    private String modelo;
    private String placa;
    @Column(nullable = false)
    private boolean disponivel = true;


}

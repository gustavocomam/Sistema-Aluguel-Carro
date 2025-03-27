package com.example.aluguel_carros.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Car {
    private int matricula;
    private int ano;
    private String marca;
    private String modelo;
    private String placa;
}

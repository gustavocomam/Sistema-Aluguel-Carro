package com.example.aluguel_carros.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@Entity
@Table(name = "aluguel")
public class AluguelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String profissao;
    private double Rendimento1;
    private double Rendimento2;
    private double Rendimento3;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private CarModel carro;

}

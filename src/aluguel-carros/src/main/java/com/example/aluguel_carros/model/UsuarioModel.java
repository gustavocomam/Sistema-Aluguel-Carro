    package com.example.aluguel_carros.model;

    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;

    @Setter
    @Getter
    @Entity
    @Table(name = "usuarios")
    public class UsuarioModel {

        // Getters e Setters = lombok
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;
        private String email;
        private String senha;

        @Enumerated(EnumType.STRING)
        private TipoUsuario tipo;

        public enum TipoUsuario {
            CLIENTE,
            AGENTE
        }
    }

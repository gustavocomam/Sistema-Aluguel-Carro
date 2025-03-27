package com.example.aluguel_carros.service;

import com.example.aluguel_carros.DTO.Usuario;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CadastroService {
    @Getter
    private final List<Usuario> usuarios = new ArrayList<>();
    private final File arquivo = new File("usuarios.txt");

    public void cadastrarUsuario(Usuario usuario) {
    usuarios.add(usuario);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
        writer.write(usuario.getNome() + ";" + usuario.getEmail() + ";" + usuario.getSenha());
        writer.newLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    @PostConstruct
    public void carregarUsuarios() {
        if (!arquivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    Usuario usuario = new Usuario(partes[0], partes[1], partes[2]);
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

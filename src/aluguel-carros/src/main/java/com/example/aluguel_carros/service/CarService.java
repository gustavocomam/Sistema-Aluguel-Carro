package com.example.aluguel_carros.service;

import com.example.aluguel_carros.DTO.Car;
import com.example.aluguel_carros.DTO.Usuario;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final List<Car> carros = new ArrayList<>();
    private final File arquivo = new File(System.getProperty("user.dir") + "/data/car.txt");

    public void cadastrarCarro(Car car) {
        carros.add(car);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write(car.getMatricula()+";"+ car.getModelo()+";"+ car.getPlaca()+";"+car.getMarca()+";"+car.getAno());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void carregarcarros() {
        if (!arquivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 5) {
                    Car car = new Car(Integer.parseInt(partes[0]) , Integer.parseInt(partes[1]), partes[2],partes[3],partes[4]);
                    carros.add(car);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

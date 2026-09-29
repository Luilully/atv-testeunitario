package com.example.testeunitario.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraDeDesconto {

    public double aplicarDesconto(double valor, double percentual) {
        // Validação adicionada para evitar valores inconsistentes
        if (valor < 0 || percentual < 0) {
            throw new IllegalArgumentException("Valores não podem ser negativos");
        }
        return valor - (valor * percentual / 100.0);
    }
}
package com.example.testeunitario.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraDeDescontoTest {

    @Test
    @DisplayName("Deve calcular o valor final com desconto com sucesso")
    void deveAplicarDescontoCorretamente() {
        // Arrange
        CalculadoraDeDesconto calc = new CalculadoraDeDesconto();

        // Act
        double resultado = calc.aplicarDesconto(200.0, 25.0);

        // Assert (150.0 esperado, margem de erro delta de 0.001 para tipos double)
        assertEquals(150.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando valores forem negativos")
    void deveLancarExcecaoQuandoValoresNegativos() {
        // Arrange
        CalculadoraDeDesconto calc = new CalculadoraDeDesconto();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calc.aplicarDesconto(-100.0, 10.0);
        });
    }
}
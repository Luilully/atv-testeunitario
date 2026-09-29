package com.example.testeunitario.service;

import com.example.testeunitario.util.EmailService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class NotificacaoServiceTest {

    @Test
    @DisplayName("Deve enviar o e-mail de boas-vindas quando o endereço for válido")
    void deveNotificarUsuarioComSucesso() {
        // Arrange: cria um mock para a interface EmailService
        EmailService mockEmail = Mockito.mock(EmailService.class);
        NotificacaoService notificacao = new NotificacaoService(mockEmail);

        // Act
        notificacao.notificarUsuario("usuario@teste.com");

        // Assert: verifica se o método enviar() do mock foi disparado com os parâmetros corretos
        verify(mockEmail, times(1)).enviar(
                "usuario@teste.com", 
                "Bem-vindo!", 
                "Sua conta foi criada com sucesso!"
        );
    }

    @Test
    @DisplayName("Deve lançar exceção quando o e-mail for vazio ou nulo")
    void deveLancarErroParaEmailInvalido() {
        // Arrange
        EmailService mockEmail = Mockito.mock(EmailService.class);
        NotificacaoService notificacao = new NotificacaoService(mockEmail);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            notificacao.notificarUsuario("");
        });

        // Garante que nenhum e-mail foi disparado diante do erro
        Mockito.verifyNoInteractions(mockEmail);
    }
}
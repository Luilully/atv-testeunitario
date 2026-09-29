package com.example.testeunitario.util;

public interface EmailService {
    void enviar(String destinatario, String assunto, String corpo);
}
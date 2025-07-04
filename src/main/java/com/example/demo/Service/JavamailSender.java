package com.example.demo.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavamailSender {

    @PostMapping
    public ResponseEntity<String> enviar(@RequestBody ContatoDTO dto) {
        // Envia o e-mail com JavaMailSender
        return ResponseEntity.ok("Mensagem enviada com sucesso!");
    }
}
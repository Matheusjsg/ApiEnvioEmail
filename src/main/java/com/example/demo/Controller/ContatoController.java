package com.example.demo.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Service.ContatoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.http.ResponseEntity;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/contato")
public class ContatoController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping
    public ResponseEntity<String> enviarEmail(@RequestBody ContatoDTO dto) {
        try {
            SimpleMailMessage mensagem = new SimpleMailMessage();
            mensagem.setTo("matheussantos930@gmail.com"); // destino final
            mensagem.setSubject("Nova mensagem do site");
            mensagem.setText(
                "Nome: " + dto.getNome() + "\n" +
                "Email: " + dto.getEmail() + "\n\n" +
                "Mensagem:\n" + dto.getMensagem()
            );

            mailSender.send(mensagem);
            return ResponseEntity.ok("Mensagem enviada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao enviar email: " + e.getMessage());
        }
    }
}

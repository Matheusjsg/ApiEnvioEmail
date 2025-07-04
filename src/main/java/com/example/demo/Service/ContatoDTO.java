package com.example.demo.Service;
public class ContatoDTO {
    private String nome;
    private String email;
    private String mensagem;


public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}

public String getMensagem() {
    return mensagem;
}

public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}
}
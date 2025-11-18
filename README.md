# 📧 API de Envio de E-mails com JavaMailSender

> **Deploy:** [AWS EC2](#) *(adicione o IP público ou domínio da instância quando disponível)*
> **Uso:** Backend de contato do portfólio pessoal hospedado no **Amazon S3**

---

## 📋 Descrição do Projeto

API REST desenvolvida em **Java + Spring Boot** para **envio de e-mails de contato** de forma segura e escalável, utilizando o **JavaMailSender**.
O backend é responsável por processar mensagens enviadas a partir do **formulário de contato do portfólio**, hospedado em um bucket **Amazon S3**, e repassá-las por e-mail para o destinatário configurado.

A aplicação roda em uma instância **EC2 da AWS**, configurada manualmente com ambiente Java, Maven e regras de segurança liberando a porta 8080.

Não há **frontend acoplado** — a aplicação funciona como um **serviço backend independente** consumido via **requisições HTTP**.

---

## 🚀 Tecnologias Utilizadas

* ☕ **Java 17+**
* 🌱 **Spring Boot**
* 💌 **Spring Mail (JavaMailSender)**
* 🧰 **Maven**
* ☁️ **AWS EC2** (deploy e configuração manual)
* 🪣 **Amazon S3** (frontend do portfólio)
* 📬 **SMTP (Gmail, AWS SES, etc.)**
* 🧪 **Postman** *(testes e validação da API)*

---

## ⚙️ Funcionalidades

✅ Envio de e-mails via SMTP (com suporte a HTML ou texto puro)
✅ Integração direta com formulários externos (ex: portfólio em S3)
✅ Configuração segura via **variáveis de ambiente na EC2**
✅ Log e tratamento de erros em tempo real
✅ Totalmente independente de frontend

---

## 🧩 Endpoint Principal

### **POST /api/contato**

#### Request Body:

```json
{
  "to": "destinatario@exemplo.com",
  "subject": "Mensagem via portfólio",
  "message": "Olá, visitei seu portfólio e gostaria de conversar!"
}
```

#### Response (200 OK):

```json
{
  "status": "success",
  "message": "E-mail enviado com sucesso!"
}
```

#### Exemplo de erro:

```json
{
  "status": "error",
  "message": "Falha ao enviar e-mail. Verifique as configurações SMTP."
}
```

---

## 🔧 Configuração SMTP

Defina as credenciais no arquivo `application.properties` ou como **variáveis de ambiente na EC2**:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=*********930@gmail.com
spring.mail.password=**** **** **** ****
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

```

## 💻 Configuração da Instância EC2

* Sistema: **Amazon Linux 2**
* Configurações manuais realizadas:

  * Instalação do **Java 17**
  * Instalação do **Maven**
  * Upload do `.jar` via SSH/SCP
  * Execução da aplicação com:

    ```bash
    java -jar emailservice.jar
    ```
  * Liberação da **porta 8080** no Security Group
  * Variáveis de ambiente definidas via terminal ou arquivo `.env`
  * Serviço configurado com `nohup` para execução contínua:

    ```bash
    nohup java -jar emailservice.jar > app.log 2>&1 &
    ```

---


## 🌐 Fluxo de Integração com o Portfólio

> 1️⃣ Usuário preenche o formulário no site (S3)
> 2️⃣ Frontend faz POST → API no EC2
> 3️⃣ API envia o e-mail com JavaMailSender
> 4️⃣ Log do envio é registrado no servidor

---

## 🧠 Boas Práticas Aplicadas

* **Injeção de dependência (IoC)** com `@Service` e `@Autowired`
* **DTOs** para desacoplamento de dados entre camadas
* **Tratamento global de exceções** com `@ControllerAdvice`
* **Logs e auditoria** de envio com `Slf4j`
* **Variáveis de ambiente seguras** na EC2

---

## 🧾 Licença

Projeto licenciado sob **MIT License** — livre para uso, modificação e contribuição.
Desenvolvido com 💛 e hospedado na **AWS EC2**.


# Usa Java 17 leve e confiável
FROM eclipse-temurin:17-jdk-alpine

# Define diretório de trabalho
WORKDIR /app

# Copia tudo para dentro do container
COPY . .

# Dá permissão ao mvnw (evita erro de permissão no Linux)
RUN chmod +x mvnw

# Constrói o projeto
RUN ./mvnw clean install

# Exponha a porta do Spring Boot
EXPOSE 8080

# Executa o app
CMD ["java", "-jar", "target/app.jar"]

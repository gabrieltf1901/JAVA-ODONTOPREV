# GABRIEL TORRES FERNANDES - RM553635
# LINK DO VÍDEO --> https://youtu.be/nbm-BXhq48k

# Odontoprev

## Descrição do Projeto

O **Odontoprev** é um sistema de gerenciamento para clínica odontológica, desenvolvido em Java com Spring Boot, Thymeleaf e Oracle Database. O objetivo principal é controlar usuários, autenticação, cadastros de pacientes, agendamentos e histórico de tratamentos.

#### IMPORTANTE ---> Descomentar a API Key no application.properties
#### IMPORTANTE ---> TESTE DA APLICAÇÃO ---> Usuário - admin@odontoprev.com / Senha - admin123

## Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3.4.5**

    * Spring MVC
    * Spring Data JPA
    * Spring Security
    * Spring AMQP (RabbitMQ)
    * Spring Actuator
* **Thymeleaf** para renderização de templates
* **Bootstrap 5** para estilização
* **Oracle Database** (via HikariCP)
* **RabbitMQ** para mensageria
* **Lombok** para redução de boilerplate
* **MapStruct** para mapeamentos entre DTOs e entidades

## Estrutura do Projeto

```
src/
├─ main/
│  ├─ java/
│  │  └─ com/odontoprev/
│  │     ├─ ai
│  │     ├─ config
│  │     ├─ controller
│  │     ├─ dto
│  │     ├─ messaging
│  │     ├─ model
│  │     ├─ repository
│  │     ├─ security
│  │     ├─ service
│  │     └─ web
│  │     └─ OdontoprevApplication.java
│  └─ resources/
│     ├─ consulta/
│     ├─ static/
│     ├─ templates/
│     ├─ application.properties
│     └─ messages.properties
└─ test/
   └─ java/

```

## Instalação e Configuração

1. **Pré-requisitos**:

    * Java 17 ou superior
    * Oracle Database configurado e acessível (jdbc:oracle:thin:@oracle.fiap.com.br:1521/ORCL - rm553635 - 190101)
    * RabbitMQ em execução
    * Git

2. **Clone o repositório**:

   ```bash
   git clone https://github.com/gabrieltf1901/JAVA-ODONTOPREV.git
   cd odontoprev
   ```

3. **Configurar propriedades**:

    * Renomeie `src/main/resources/application.properties.example` para `application.properties`.
    * Ajuste a conexão com o banco de dados (URL, usuário, senha).
    * Configure as credenciais do RabbitMQ, se necessário.

4. **Build do projeto**:

   ```bash
   ./gradlew clean build
   ```

## Executando a Aplicação

* Pelo terminal:

  ```bash
  java -jar build/libs/odontoprev-0.0.1-SNAPSHOT.jar
  ```

* Ou via IntelliJ IDEA:

    1. Abra o projeto.
    2. Clique em **Run** no `OdontoprevApplication`.

A aplicação ficará disponível em `http://localhost:8080`.

## Funcionalidades Principais

* **Autenticação e autorização** via Spring Security
* **Cadastro de usuários** com diferentes perfis
* **Gerenciamento de pacientes** e seus históricos de tratamento
* **Agendamento de consultas**
* **Mensageria** para notificações via RabbitMQ
* **Monitoramento** com Spring Actuator

## Endpoints Importantes

| Método | URL                | Descrição                      |
| ------ | ------------------ | ------------------------------ |
| GET    | `/login`           | Página de login                |
| POST   | `/login`           | Processa autenticação          |
| GET    | `/usuarios/novo`   | Formulário de cadastro usuário |
| POST   | `/usuarios/salvar` | Salva novo usuário             |
| GET    | `/home`            | Área restrita após login       |

## Segurança

* As senhas estão armazenadas em texto puro para fins didáticos (NoOpPasswordEncoder).

* URLs públicas estão configuradas em `SecurityConfig`.



---------------------------------------------------------------------------------------------------

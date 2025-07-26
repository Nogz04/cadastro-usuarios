# 📘 Cadastro de Usuários - API REST com Spring Boot

Este é um projeto backend desenvolvido com **Java + Spring Boot**, que oferece uma API RESTful para realizar o **cadastro, listagem, busca, atualização e exclusão de usuários**. O projeto segue o padrão **MVC** e boas práticas como uso de **DTOs**, **Camada de Serviço** e **Spring Data JPA**.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Banco de Dados MySQL
- Maven
- Postman (para testes)

---

## 📦 Endpoints Disponíveis

| Método | Endpoint         | Descrição                    |
|--------|------------------|------------------------------|
| POST   | `/usuarios`      | Cadastra um novo usuário     |
| GET    | `/usuarios`      | Lista todos os usuários      |
| GET    | `/usuarios/{id}` | Busca usuário por ID         |
| PUT    | `/usuarios/{id}` | Atualiza usuário por ID      |
| DELETE | `/usuarios/{id}` | Deleta usuário por ID        |

---

## 📬 Como usar com Postman

### ▶️ 1. Inicie a aplicação
- Inicie a aplicação na IDEA

### ▶️ 2. Instale o Postman e execute-o
 - Vá em New -> HTTP Request <br>
 - Vá em Body -> raw -> JSON

### ✅ 3. Teste os endpoints

#### 🔸 POST `/usuarios` (Cadastrar)
- **Body (JSON):**
```json
{
  "nome": "Matheus Nogueira Albuquerque",
  "email": "matheus@gmail.com",
  "cpf": "12345678901"
}

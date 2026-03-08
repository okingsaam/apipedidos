# 📦 API de Pedidos

API REST desenvolvida com **Spring Boot** para gerenciamento de pedidos.

Este projeto implementa um **CRUD completo**, utilizando boas práticas de desenvolvimento backend como **DTO, validação, paginação e documentação com Swagger**.

---

# 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Bean Validation
- Swagger / OpenAPI
- Maven

---

# 📂 Estrutura do Projeto

```
src/main/java/com/douglas/apipedidos

controller   -> Endpoints da API
service      -> Regras de negócio
repository   -> Acesso ao banco de dados
dto          -> Objetos de transferência de dados
entity       -> Entidades JPA
mapper       -> Conversão entre Entity e DTO
exception    -> Tratamento global de erros
```

---

# 📌 Funcionalidades

- Criar pedido
- Listar pedidos com paginação
- Buscar pedido por ID
- Atualizar pedido
- Deletar pedido
- Validação de dados
- Tratamento global de exceções
- Documentação automática com Swagger

---

# 📡 Endpoints

| Método | Endpoint | Descrição |
|------|------|------|
| POST | /pedidos | Criar pedido |
| GET | /pedidos | Listar pedidos |
| GET | /pedidos/{id} | Buscar pedido por ID |
| PUT | /pedidos/{id} | Atualizar pedido |
| DELETE | /pedidos/{id} | Deletar pedido |

---

# 📄 Exemplo de requisição

### Criar Pedido

```json
{
  "cliente": "Douglas",
  "valor": 200
}
```

### Resposta da API

```json
{
  "id": 1,
  "cliente": "Douglas",
  "valor": 200,
  "dataCriacao": "2026-03-07T20:39:48"
}
```

---

# 📖 Documentação Swagger

Após iniciar o projeto, acesse:

```
http://localhost:8080/swagger-ui/index.html
```

---

# ⚙️ Como executar o projeto

### 1. Clonar o repositório

```
git clone https://github.com/seu-usuario/apipedidos.git
```

### 2. Entrar na pasta do projeto

```
cd apipedidos
```

### 3. Rodar a aplicação

```
mvn spring-boot:run
```

---

# 🗄 Banco de Dados

O projeto utiliza **PostgreSQL**.

Exemplo de configuração no `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/apipedidos
spring.datasource.username=postgres
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
```

---

# 👨‍💻 Autor

Desenvolvido por **Douglas**  
Projeto criado para prática de desenvolvimento backend com **Spring Boot**.
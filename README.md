# 📚 Biblioteca API

API REST para gerenciamento de biblioteca desenvolvida com Spring Boot, permitindo cadastro de autores, livros, usuários e empréstimos.

---

## Tecnologias

- Java 17
- Spring Boot 4.0.5
- Spring Data JPA
- MySQL
- Lombok
- Maven

---

## Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado:

- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- [MySQL 8+](https://dev.mysql.com/downloads/mysql/)

---

## Configurando o banco de dados

### 1. Acesse o MySQL

```bash
mysql -u root -p
```

### 2. Crie o banco de dados

```sql
CREATE DATABASE biblioteca;
```

### 3. Confirme que o banco foi criado

```sql
SHOW DATABASES;
```

> O JPA com `ddl-auto=update` vai criar as tabelas automaticamente na primeira execução. Você não precisa criar nenhuma tabela manualmente.

---

## Configuração da aplicação

As configurações de conexão ficam em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca?allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=123456

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Se o seu MySQL usar usuário ou senha diferente, altere os campos `username` e `password` antes de rodar.

---

## Rodando o projeto

### Via Maven (terminal)

Na raiz do projeto, execute:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

### Via IntelliJ IDEA

1. Abra o projeto pela pasta raiz
2. Aguarde o Maven baixar as dependências
3. Abra `BibliotecaApplication.java`
4. Clique no botão **Run** (▶) ao lado do método `main`

A aplicação sobe na porta **8080** por padrão.

---

## Endpoints disponíveis

### Autores — `/biblioteca/autores`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/biblioteca/autores` | Criar autor |
| GET | `/biblioteca/autores` | Listar todos |
| GET | `/biblioteca/autores/{id}` | Buscar por ID |
| PUT | `/biblioteca/autores/{id}` | Atualizar |
| DELETE | `/biblioteca/autores/{id}` | Deletar |

**Exemplo de body (POST/PUT):**
```json
{
  "name": "Machado de Assis",
  "birthDate": "1839-06-21",
  "nationality": "Brasileiro",
  "active": true
}
```

---

### Livros — `/biblioteca/livros`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/biblioteca/livros` | Criar livro |
| GET | `/biblioteca/livros` | Listar todos |
| GET | `/biblioteca/livros/{id}` | Buscar por ID |
| GET | `/biblioteca/livros/buscar-por-titulo?title=` | Buscar por título |
| PUT | `/biblioteca/livros/{id}` | Atualizar |
| DELETE | `/biblioteca/livros/{id}` | Deletar |

**Exemplo de body (POST/PUT):**
```json
{
  "title": "Dom Casmurro",
  "releaseDate": "1899-01-01",
  "synopsis": "A história de Bentinho e Capitu, marcada por ciúme e dúvida.",
  "publisher": "Garnier",
  "authorId": 1
}
```

---

### Usuários — `/biblioteca/usuarios`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/biblioteca/usuarios` | Criar usuário |
| GET | `/biblioteca/usuarios` | Listar todos |
| GET | `/biblioteca/usuarios/{id}` | Buscar por ID |
| PUT | `/biblioteca/usuarios/{id}` | Atualizar |
| DELETE | `/biblioteca/usuarios/{id}` | Deletar |
| POST | `/biblioteca/usuarios/alugar-livros` | Realizar empréstimo |

**Exemplo de body — criar usuário:**
```json
{
  "name": "Ana Silva",
  "email": "ana.silva@email.com",
  "birthDate": "1995-03-15"
}
```

**Exemplo de body — alugar livro:**
```json
{
  "userId": 1,
  "bookTitle": "Dom Casmurro"
}
```

---

## Estrutura do projeto

```
src/main/java/br/com/fiap/biblioteca/
├── author/
│   ├── api/          # Controller
│   ├── dto/          # Request e Response
│   ├── model/        # Entidade JPA
│   ├── repository/   # Interface JPA
│   └── service/      # Regras de negócio
├── book/
│   ├── api/
│   ├── dto/
│   ├── model/
│   ├── repository/
│   └── service/
└── user/
    ├── api/
    ├── dto/
    ├── model/
    ├── repository/
    └── service/
```

---

## Solução de problemas comuns

**Erro de conexão com o banco:**
Verifique se o MySQL está rodando e se as credenciais em `application.properties` estão corretas.

**Tabelas não criadas:**
Confirme que o banco `biblioteca` existe e que `spring.jpa.hibernate.ddl-auto=update` está no `application.properties`.

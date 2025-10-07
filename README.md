# Player API

Este projeto é uma API RESTful desenvolvida em Java com Spring Boot para gerenciar jogadores. A estrutura foi organizada seguindo boas práticas de desenvolvimento orientado a objetos, utilizando arquitetura em camadas e integração com DynamoDB.

## 🧱 Tecnologias Utilizadas

- Java 24 (LTS)
- Spring Boot 3.5.6
- AWS SDK v2 (DynamoDB)
- Maven
- Lombok
- Postman (para testes de requisição)

## 📁 Estrutura do Projeto

- `business`: regras de negócio para CRUD de jogadores
- `controller`: endpoints REST  
- `infrastructure/entities`: entidades DynamoDB  
- `infrastructure/repository`: acesso ao banco  

## 🚀 Funcionalidades

- Criar jogador
- Buscar jogador por ID
- Listar todos os jogadores
- Substituir jogador (PUT)
- Atualizar parcialmente jogador (PATCH)
- Deletar jogador
- Camada de serviço desacoplada com interfaces

## 🔧 Como Executar

1. Clone o projeto:
```bash
git clone https://github.com/Daniel-Macedo-dev/playerAPI.git
```

2. Acesse o diretório:
```bash
cd playerAPI
```

3. Compile e execute:
```bash
./mvnw spring-boot:run
```

4. Teste os endpoints usando o Postman ou outro cliente HTTP:
```bash
* `POST /player` → criar jogador
* `GET /player` → listar todos os jogadores
* `GET /player/{id}` → buscar jogador por ID
* `PUT /player/{id}` → substituir jogador
* `PATCH /player/{id}` → atualizar parcialmente jogador
* `DELETE /player/{id}` → deletar jogador
```

📄 Licença

Este projeto está licenciado sob a MIT License.

# Organização do Projeto

## Estrutura de Diretórios
Seguiremos o padrão standard do Spring Boot Gradle/Maven, mas com pacotes semânticos para separar as abordagens.

```text
src/main/java/com/example/poc
├── config/             # Configurações (CORS, Swagger, GraphQL Scalar)
├── domain/             # Entidades JPA (Movie, Actor)
├── repository/         # Interfaces Repository
├── service/            # Lógica de Negócio (Loaders, Services)
├── api/
│   ├── rest/           # REST Controllers
│   │   ├── inputs/     # DTOs de Entrada REST
│   │   └── outputs/    # DTOs de Saída REST (ModelMapper)
│   └── graphql/        # GraphQL Resolvers
│       └── inputs/     # Inputs GraphQL mapeados
└── middleware/         # Logging e Monitoramento
```

## Recursos
```text
src/main/resources/
├── graphql/
│   └── schema.graphqls # Contrato da API GraphQL
├── application.properties # Configuração DB, Log Level
└── data.sql (Opcional, se não usarmos o Loader Java)
```

## Dependências (Build)
- **Spring Boot Starter Web**: REST API.
- **Spring Boot Starter GraphQL**: GraphQL API.
- **Spring Boot Starter Data JPA**: Camada de dados.
- **H2 ou SQLite Dialect**: Driver de banco (definido: SQLite).
- **Lombok**: Redução de boilerplate (Getters/Setters).
- **Spring Boot DevTools**: Hot reload.

## Pipeline Local (Development)
1.  **Build**: `./mvnw clean install`
2.  **Run**: `./mvnw spring-boot:run`
3.  **Logs**: Acompanhamento direto no terminal do `run`.

# Arquitetura de Componentes - PoC REST vs GraphQL

## Contexto (C4 Nível 1)
O sistema é uma aplicação monolítica simples (`MovieCatalogApp`) que expõe duas interfaces de comunicação distintas (REST e GraphQL) para consumo por clientes HTTP (Console/Insomnia).

```mermaid
C4Context
    title Diagrama de Contexto - Sistema Catálogo de Filmes

    Person(student, "Estudante/Dev", "Consome as APIs para entender as diferenças")
    System(movieApp, "Movie Catalog App", "Gerencia filmes, atores e reviews. Expõe REST e GraphQL")
    
    Rel(student, movieApp, "Busca dados via", "HTTP/JSON")
```

## Containers (C4 Nível 2)
A aplicação é construída sobre o Spring Boot, com separação lógica entre os controladores REST e os Resolvers GraphQL, ambos acessando a mesma camada de serviço e dados.

```mermaid
C4Container
    title Diagrama de Containers - Movie Catalog App

    Container_Boundary(c1, "Spring Boot Application") {
        Component(restCtrl, "REST Controllers", "Spring MVC", "Expõe endpoints REST (/api/v1/movies)")
        Component(gqlResolver, "GraphQL Resolvers", "Spring for GraphQL", "Resolve queries e mutations (/graphql)")
        
        Component(service, "Movie Service", "Spring Service", "Regras de negócio e orquestração")
        
        Component(repo, "JPA Repository", "Spring Data", "Acesso a dados")
        
        Component(loader, "Data Loader", "CommandLineRunner", "Popula o banco ao iniciar")
    }

    ContainerDb(sqlite, "SQLite Database", "File/Memory", "Armazena filmes e atores")

    Rel(restCtrl, service, "Chama")
    Rel(gqlResolver, service, "Chama")
    Rel(service, repo, "Usa")
    Rel(repo, sqlite, "Lê/Escreve", "JDBC")
    Rel(loader, repo, "Popula dados")
```

## Decisões Arquiteturais
1.  **Separação de Interfaces**: As camadas de entrada (`controller` vs `resource/resolver`) estarão em pacotes distintos (`api.rest` e `api.graphql`) para evidenciar a diferença de tratamento da requisição.
2.  **Schema First**: O contrato GraphQL será definido explicitamente em `src/main/resources/graphql/schema.graphqls`.
3.  **Logging**: Um `OncePerRequestFilter` será configurado para interceptar e logar todas as requisições, fundamental para a demonstração de "N requests no REST".

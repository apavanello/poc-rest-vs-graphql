# Fluxos e Casos de Uso - PoC REST vs GraphQL

## Fluxo 1: Leitura de Catálogo (Comparativo)

Este fluxo demonstra a principal diferença de "round-trips" entre as tecnologias.

### Cenário REST (Múltiplas Chamadas)
O cliente precisa exibir o título do filme e nomes dos atores.

```mermaid
sequenceDiagram
    participant Client
    participant RestController
    participant Database

    Note over Client: Precisa de Filmes + Atores

    Client->>RestController: GET /movies (Lista Filmes)
    RestController->>Database: SELECT * FROM movies
    Database-->>RestController: [Movie A, Movie B]
    RestController-->>Client: JSON [Movie A, Movie B]

    loop Para cada Filme (Overhead do Cliente)
        Client->>RestController: GET /movies/{id}/actors
        RestController->>Database: SELECT * FROM actors WHERE movie_id = ?
        Database-->>RestController: [Actor 1, Actor 2]
        RestController-->>Client: JSON [Actor list]
    end
```

### Cenário GraphQL (Single Request)
O cliente pede exatamente o que precisa em uma chamada.

```mermaid
sequenceDiagram
    participant Client
    participant GraphQLResolver
    participant Database

    Note over Client: Precisa de Filmes + Atores

    Client->>GraphQLResolver: POST /graphql { query { movies { title, actors { name } } } }
    
    GraphQLResolver->>Database: SELECT * FROM movies
    Note right of GraphQLResolver: O DataFetcher resolve os atores (pode ser Batch)
    GraphQLResolver->>Database: SELECT * FROM actors WHERE movie_id IN (...)
    
    GraphQLResolver-->>Client: JSON { data: { movies: [...] } }
```

## Fluxo 2: Criação de Conteúdo

Demonstra que para operações de escrita, a complexidade é similar.

```mermaid
flowchart LR
    subgraph REST
    R_Input[JSON Body] --> R_POST[POST /movies]
    R_POST --> R_Save[Service.save()]
    end

    subgraph GraphQL
    G_Input[Mutation Input] --> G_Mut[mutation createMovie]
    G_Mut --> G_Save[Service.save()]
    end

    R_Save --> DB[(Database)]
    G_Save --> DB
```

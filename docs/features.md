# Funcionalidades (Features) - PoC REST vs GraphQL

## Domínio: Catálogo de Filmes

### 1. Visualização de Catálogo (Leitura)
Funcionalidades focadas na obtenção de dados para demonstração de consumo.

-   **[F01] Listar Filmes (REST)**
    -   Endpoint para retornar listagem simples de filmes.
    -   Demonstrar payload fixo.
-   **[F02] Detalhar Filme (REST)**
    -   Endpoint para retornar detalhes de um filme específico pelo ID.
-   **[F03] Listar Atores de um Filme (REST)**
    -   Endpoint separado (sub-recurso) para buscar atores de um filme.
    -   Demonstrar a necessidade de chamadas adicionais.
-   **[F04] Consultar Catálogo Unificado (GraphQL)**
    -   Query única capaz de buscar filmes, detalhes e atores em uma só requisição.
    -   Demonstrar flexibilidade de seleção de campos (burlar overfetching).

### 2. Gestão de Conteúdo (Escrita)
Funcionalidades básicas de cadastro para comparar métodos de escrita.

-   **[F05] Cadastrar Filme (REST)**
    -   Endpoint `POST` padrão.
-   **[F06] Cadastrar Filme (GraphQL)**
    -   Mutation para criação de registro equivalente.

### 3. Cenários Didáticos (Prova de Conceito)
Cenários específicos desenhados para falhar ou mostrar ineficiência em um dos lados.

-   **[F07] Simulação de Overfetching (REST)**
    -   Endpoint REST que retorna objeto 'pesado' (todos os campos) mesmo quando não necessário.
-   **[F08] Simulação de Underfetching/N+1 (Comparativo)**
    -   Script ou caso de teste executando a busca de "Top 10 Filmes + Atores Protagonistas".
    -   Medir/Mostrar quantidade de requests REST vs GraphQL.

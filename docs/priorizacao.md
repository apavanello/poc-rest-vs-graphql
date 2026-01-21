# Priorização e Estimativa de Features

| ID | Feature | Domínio | Skills Necessárias | Esforço | Prioridade (MosCoW) | Justificativa |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| F01 | Listar Filmes (REST) | Leitura | Backend REST | Simples | **Must Have** | Base para comparação REST. |
| F02 | Detalhar Filme (REST) | Leitura | Backend REST | Simples | **Must Have** | Necessário para navegação básica. |
| F03 | Listar Atores (REST) | Leitura | Backend REST | Simples | **Must Have** | Essencial para demonstrar N+1 requests. |
| F04 | Consultar Catálogo (GraphQL) | Leitura | Backend GraphQL | Médio | **Must Have** | O "coração" da demonstração do GraphQL. |
| F07 | Simulação Overfetching (REST) | Didático | Backend REST | Simples | **Must Have** | Prova visual de tráfego desnecessário. |
| F08 | Simulação N+1 (Comparativo) | Didático | Fullstack/Script | Médio | **Must Have** | A "bala de prata" da apresentação. |
| F05 | Cadastrar Filme (REST) | Escrita | Backend REST | Simples | Should Have | Importante, mas leitura é o foco da aula. |
| F06 | Cadastrar Filme (GraphQL) | Escrita | Backend GraphQL | Simples | Should Have | Importante, mas leitura é o foco da aula. |

## Legenda de Esforço
-   **Simples**: < 4 horas dev
-   **Médio**: 1-2 dias dev
-   **Complexo**: > 3 dias dev

## Skills Envolvidas
-   **Backend REST**: Conhecimento em rotas, verbos HTTP, status codes.
-   **Backend GraphQL**: Conhecimento em Schema, Resolvers, Types.

# Priorização de Requisitos Não-Funcionais

| ID | Requisito | Categoria | Esforço | Prioridade |
| :--- | :--- | :--- | :--- | :--- |
| RNF-01 | Java + Spring Boot | Stack | Médio | **Must Have** |
| RNF-03 | SQLite + JPA | Dados | Simples | **Must Have** |
| RNF-06 | Logging de Requisições | Observabilidade | Simples | **Must Have** |
| RNF-05 | Configuração GraphQL | Stack | Médio | **Must Have** |


# Plano: Visualização de Catálogo (Leitura)

## Features
- [F01] Listar Filmes (REST)
- [F02] Detalhar Filme (REST)
- [F03] Listar Atores (REST)
- [F04] Consultar Catálogo Completo (GraphQL)

## Tarefas

### 1. Backend REST (Controller)
- [ ] Criar `MovieRestController` (`/api/v1/movies`) <!-- id: 0 -->
- [ ] Implementar `GET /` (Listar filmes resumo) [F01] <!-- id: 1 -->
- [ ] Implementar `GET /{id}` (Detalhar filme) [F02] <!-- id: 2 -->
- [ ] Implementar `GET /{id}/actors` (Listar atores de um filme) [F03] <!-- id: 3 -->
- [ ] Criar DTOs de resposta (`MovieResponseDTO`, `ActorResponseDTO`) <!-- id: 4 -->

### 2. Backend GraphQL (Schema First)
- [ ] Definir `schema.graphqls` (`type Movie`, `type Actor`, `Query`) <!-- id: 5 -->
- [ ] Criar `MovieGraphQLController` (@Controller) <!-- id: 6 -->
- [ ] Implementar `@QueryMapping movies` (Listar todos) <!-- id: 7 -->
- [ ] Implementar `@QueryMapping movieById` (Buscar um) [F04] <!-- id: 8 -->
- [ ] Implementar `@SchemaMapping actors` (Resolver atores para um filme - Lazy Load) <!-- id: 9 -->

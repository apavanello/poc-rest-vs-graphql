# Plano: Gestão de Conteúdo (Escrita)

## Features
- [F05] Cadastrar Filme (REST)
- [F06] Cadastrar Filme (GraphQL)

## Tarefas

### 1. Escrita REST
- [ ] Adicionar endpoint `POST /api/v1/movies` em `MovieRestController` [F05] <!-- id: 0 -->
- [ ] Criar `MovieCreateRequestDTO` <!-- id: 1 -->
- [ ] Validar e persistir via Service <!-- id: 2 -->

### 2. Escrita GraphQL
- [ ] Adicionar `type Mutation` em `schema.graphqls` <!-- id: 3 -->
- [ ] Definir `input MovieInput` <!-- id: 4 -->
- [ ] Implementar `@MutationMapping createMovie` em `MovieGraphQLController` [F06] <!-- id: 5 -->

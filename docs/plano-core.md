# Plano Core (Fundação do Projeto)

## Visão Geral
Implementação da estrutura base, configuração de banco de dados e camadas compartilhadas (Service/Repository).

## Tarefas

### 1. Scaffolding (Spring Initializr)
- [ ] Gerar projeto Spring Boot (Web, Data JPA, GraphQL, Lombok, DevTools) <!-- id: 0 -->
- [ ] Ajustar `pom.xml` para Java 25 <!-- id: 1 -->
- [ ] Adicionar dependência SQLite Dialect <!-- id: 2 -->

### 2. Camada de Dados (JPA)
- [ ] Criar entidade `Movie` (id, title, genre, year) <!-- id: 3 -->
- [ ] Criar entidade `Actor` (id, name) <!-- id: 4 -->
- [ ] Criar entidade `Review` (id, comment, rating, movie_id) <!-- id: 5 -->
- [ ] Mapear relacionamentos (@ManyToMany Movie-Actor, @OneToMany Movie-Review) <!-- id: 6 -->
- [ ] Criar Repositories (`MovieRepository`, `ActorRepository`) <!-- id: 7 -->

### 3. Carga Inicial (Data Loader)
- [ ] Implementar `DataInitializer` (CommandLineRunner) <!-- id: 8 -->
- [ ] Gerar 20 Filmes fictícios <!-- id: 9 -->
- [ ] Gerar 50 Atores e vincular aleatoriamente <!-- id: 10 -->

### 4. Observabilidade Base
- [ ] Implementar `RequestLoggingFilter` <!-- id: 11 -->
  - Interceptar requisições HTTP
  - Logar: `[METHOD] /path`
  - Garantir visibilidade no Console

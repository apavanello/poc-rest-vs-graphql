# Plano: Cenários Didáticos (Prova de Conceito)

## Features
- [F07] Simulação de Overfetching (REST)
- [F08] Simulação de Underfetching/N+1 (Comparativo)

## Tarefas

### 1. Cenário Overfetching (REST)
- [ ] Criar endpoint REST `GET /api/v1/movies/heavy` [F07] <!-- id: 0 -->
  - Retornar objeto "inflado" (com reviews e metadados desnecessários).
  - Demonstrar no console o tamanho do payload ou campos inúteis.

### 2. Simulação N+1 (Comparativo)
- [ ] Criar script de teste `test-scenario-n1.sh` (ou `.bat`) [F08] <!-- id: 1 -->
  - Executar via Curl: Obter lista de 10 filmes.
  - Executar via Curl: Para cada filme, obter lista de atores (Loop).
  - Finalidade: Gerar ~11 requests no log do console REST.
- [ ] Criar query GraphQL equivalente em arquivo `n1-query.graphql` <!-- id: 2 -->
  - Executar e verificar que gera apenas 1 request no log do console.
- [ ] Documentar o passo-a-passo da demo em `docs/DEMO-GUIDE.md` <!-- id: 3 -->

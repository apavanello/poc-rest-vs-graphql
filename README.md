# PoC: REST vs GraphQL - Guia de Demonstração

Este projeto é uma Prova de Conceito (PoC) didática para demonstrar as diferenças fundamentais entre APIs REST e GraphQL, focando mimos problemas de *Overfetching* e *N+1 Requests*.

## 🚀 Como Rodar a Aplicação

### Pré-requisitos
- Java 21+ instalado.
- Terminal (PowerShell ou Bash).

### Passo 1: Iniciar o Servidor
No terminal, execute:

```powershell
# Windows
.\mvnw.cmd spring-boot:run
```

O servidor iniciará na porta `8080`.
**Dica**: Mantenha este terminal visível para acompanhar os logs de requisição (`>>> INCOMING REQUEST`).

---

## 🧪 Cenários de Teste (Demo)

### Cenário 1: O Problema N+1 (A "Polêmica")
Situação: Precisamos listar os filmes e os nomes de seus atores.

#### Abordagem REST (Ineficiente)
Execute o script de demonstração que simula um frontend "navegando" pela lista:

```powershell
powershell -ExecutionPolicy Bypass -File demo-n1-rest.ps1
```

**O que observar:**
- O script fará **1 chamada** para pegar a lista de filmes.
- E depois fará **N chamadas** (uma para cada filme) para pegar os atores.
- Olhe no terminal do servidor: Você verá uma "chuva" de logs de requisições.

#### Abordagem GraphQL (Eficiente)
Execute a query que pede tudo de uma vez:

```powershell
curl.exe -X POST -H "Content-Type: application/json" -d "@query-n1.json" http://localhost:8080/graphql
```

**O que observar:**
- Você receberá todos os dados (Filmes + Atores aninhados).
- Olhe no terminal do servidor: Apenas **1 requisição** chegou.

---

### Cenário 2: Overfetching (Dados em Excesso)
Situação: O frontend precisa apenas do `Título` do filme.

#### Abordagem REST
```powershell
curl.exe -v http://localhost:8080/api/v1/movies
```
**Resultado**: Você recebe ID, Título, Gênero, Ano... tudo. O servidor decide o que manda.

#### Abordagem REST Extreme (Endpoint "Pesado")
```powershell
curl.exe -v http://localhost:8080/api/v1/movies/heavy
```
**Resultado**: Payload gigante com metadados inúteis e listas completas.

#### Abordagem GraphQL
```powershell
curl.exe -X POST -H "Content-Type: application/json" -d "@query-overfetching.json" http://localhost:8080/graphql
```
**Resultado**: Um JSON limpo contendo APENAS o título. O cliente decide o que recebe.

---

## 🛠️ Endpoints Disponíveis

| Tipo | Método | URL | Descrição |
| :--- | :--- | :--- | :--- |
| REST | GET | `/api/v1/movies` | Lista filmes (Simples) |
| REST | GET | `/api/v1/movies/{id}` | Detalhes do filme |
| REST | GET | `/api/v1/movies/{id}/actors` | Atores de um filme |
| REST | POST | `/api/v1/movies` | Cria filme |
| GQL | POST | `/graphql` | Endpoint único (Query/Mutation) |

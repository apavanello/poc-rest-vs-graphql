# Requisitos Não-Funcionais (RNF)

## 1. Tecnologias e Stack (RNF-01 a RNF-05)
- **[RNF-01] Linguagem**: Java (Preferência por JDK mais recente, ex: 25/21).
- **[RNF-02] Framework**: Spring Boot (Ecossistema padrão de mercado).
- **[RNF-03] Banco de Dados**: SQLite.
- **[RNF-04] ORM**: Spring Data JPA / Hibernate (Para facilitar mapeamento e permitir demonstração do problema N+1).
- **[RNF-05] API GraphQL**: Spring for GraphQL ou DGS Framework.

## 2. Observabilidade e Monitoramento (RNF-06 a RNF-08)
- **[RNF-06] Logging de Requisições**: Implementar filtro/interceptor para registrar no console cada requisição HTTP recebida (Method + URI).
  - *Objetivo*: Evidenciar volume de chamadas.
- **[RNF-07] Performance**: Tempo de resposta não é crítico, mas o *overhead* de conexão deve ser visível.
- **[RNF-08] Console limpo**: Garantir que logs do framework (Spring startup) não poluilam a demonstração das requests.

## 3. Interface e Usabilidade (RNF-09)
- **[RNF-09] Interface**: Sem Frontend gráfico. Demonstração via Console/Logs e chamadas via ferramenta de API (Curl/Insomnia) ou Testes de Integração.

## 4. Ambiente e Integração (RNF-10)
- **[RNF-10] Portabilidade**: O projeto deve rodar localmente com configuração mínima (banco em arquivo local).

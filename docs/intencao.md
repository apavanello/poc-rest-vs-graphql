# Intenção do Projeto: PoC Comparativa REST vs GraphQL

## Visão Geral
Criação de uma Prova de Conceito (PoC) com fins didáticos para demonstrar, na prática, as diferenças fundamentais entre arquiteturas REST e GraphQL. O objetivo é elucidar para estudantes (nível Junior/Trainee) como o REST tende a ser mais rígido (múltiplos endpoints, overfetching/underfetching) enquanto o GraphQL oferece flexibilidade na consulta de dados.

## Objetivos Principais
1.  **Comparação Prática**: Exibir lado a lado o código e o comportamento de endpoints REST e queries GraphQL.
2.  **Demonstração de Flexibilidade**: Focar na capacidade do GraphQL de obter diferentes formatos de resposta com uma única chamada, contrastando com a necessidade de múltiplos endpoints ou endpoints fixos no REST.
3.  **Código Apartado**: Manter uma estrutura clara e separada para facilitar o entendimento das diferenças de implementação.

## Público-Alvo
-   Desenvolvedores Juniors
-   Trainees
-   Estudantes de desenvolvimento web

## Detalhes Técnicos Iniciais
-   **Tipo**: Aplicação de demonstração / PoC Educacional.
-   **Dados**: Utilização de Mock ou banco de dados simples (SQLite) para evitar complexidade de infraestrutura.
-   **Cenário de Uso**: Sala de aula / Treinamento técnico.

## Escopo Recomendado (Sugestão do Consultor)
Para atingir o objetivo didático, recomenda-se um cenário de domínio simples, como um "Catálogo de Filmes" ou "Usuários e Tarefas", onde seja fácil visualizar relacionamentos (ex: Usuário tem Tarefas) para demonstrar o problema de N+1 ou overfetching no REST vs a query aninhada no GraphQL.

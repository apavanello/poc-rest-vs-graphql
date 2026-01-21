# Plano de Setup de Desenvolvimento

## Visão Geral
Preparação do ambiente local para desenvolvimento da Prova de Conceito.

## Tarefas

- [ ] Instalar JDK 25 (ou verificar instalação existente) <!-- id: 0 -->
  - `java -version`
- [ ] Clonar/Inicializar Repositório Git <!-- id: 1 -->
- [ ] Configurar IDE (IntelliJ IDEA / VS Code / Eclipse) <!-- id: 2 -->
  - Importar projeto como "Maven/Gradle Project"
  - Instalar plugins: "Lombok", "GraphQL"
- [ ] Validar Maven Wrapper (mvnw) <!-- id: 3 -->
  - Executar `./mvnw -version` para garantir compatibilidade.

## Ferramentas Necessárias
- JDK 25
- Maven (via Wrapper)
- Git
- Cliente HTTP (Curl, Insomnia ou Postman)

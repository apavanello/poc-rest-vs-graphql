# Plano de Setup de Infraestrutura (Local/PoC)

## Visão Geral
Como é uma PoC local, o "setup de infra" foca na automação de build e execução local.

## Tarefas

- [ ] Criar Script de Build e Run (Windows) `run-poc.bat` <!-- id: 0 -->
  - Deve compilar (`mvn clean package`) e rodar o jar.
- [ ] Configurar Perfil de Spring `application-dev.properties` <!-- id: 1 -->
  - Habilitar logs detalhados
  - Configurar caminho do banco SQLite (`jdbc:sqlite:movie-catalog.db`)
- [ ] Configurar `application.properties` para Console H2 (Opcional, se usar H2 para debug rápido) <!-- id: 2 -->
- [ ] Testar Build via Terminal <!-- id: 3 -->

# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# Build
mvn clean install

# Run (development)
mvn spring-boot:run

# Run the built jar
java -jar target/sistema-patrimonial-1.0.0.jar

# Compile only
mvn compile
```

There are no tests in this project.

## Prerequisites

- Java 17
- PostgreSQL running on `localhost:5432` with database `patrimonio`, user `postgres`, password `postgres`
- Schema is auto-managed by Hibernate (`spring.jpa.hibernate.ddl-auto=update`)

On first startup, `DataInitializer` creates an admin user if none exists: `login=admin / senha=admin123`.

## Architecture

Standard Spring Boot 3.2.3 layered architecture — no service layer except for `RelatorioService`. Controllers call repositories directly.

```
model/       → JPA entities (Bem, Usuario, Movimentacao)
repository/  → Spring Data JPA repositories with custom JPQL queries
controller/  → REST controllers under /api/**
service/     → RelatorioService (PDF/Excel generation), EmailService (password reset)
config/      → SecurityConfig (Spring Security), DataInitializer (seed admin user)
```

The frontend is a single `static/index.html` SPA served by Spring Boot.

## Domain Model

- **`Bem`** — the core asset entity. Has `Categoria` (NOTEBOOK, DESKTOP, DRONE, MONITOR, IMPRESSORA, PERIFERICO, OUTRO) and `Status` (ATIVO, MANUTENCAO, EMPRESTADO, BAIXADO).
- **`Usuario`** — application users with `Perfil` (ADMIN, OPERADOR). Inactive users (`ativo=false`) cannot log in.
- **`Movimentacao`** — tracks asset loans/returns (`Tipo`: SAIDA, DEVOLUCAO). A `Movimentacao` is considered returned when `dataDevolucao != null`.

## Security

Session-based authentication (no JWT). CSRF is disabled.

- `/api/auth/**` — public (login, logout, esqueci-senha)
- `GET /api/bens/**` — any authenticated user
- `/api/movimentacoes/**` — any authenticated user
- `/api/usuarios/**` — ADMIN only
- `/api/relatorios/**` — ADMIN only

Roles are stored as `ROLE_ADMIN` / `ROLE_OPERADOR` in Spring Security, sourced from `Usuario.Perfil`.

## Reports

`RelatorioService` generates both PDF (via OpenPDF/iText) and Excel (via Apache POI XSSF). The `RelatorioController` exposes endpoints that stream the file bytes with appropriate `Content-Disposition` headers. Filtering by categoria, responsavel, CPF, and date range is done via a custom JPQL query in `BemRepository`.

## Email

`EmailService` handles password reset emails via SMTP. Configuration is in `application.properties` — Gmail SMTP is the active provider. The password reset flow lives in `PasswordResetController`.

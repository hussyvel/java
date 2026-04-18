# Plano de Implementação — Classe Círculo

## Grafo de Dependências

```
Circulo.java (entities)
    └── CirculoTest.java (test)
    └── Main.java (atualizar)
```

`Circulo` não depende de nada existente. `Main` e os testes dependem de `Circulo`.

## Fatias Verticais (ordem de execução)

### Tarefa 1 — Criar `src/entities/Circulo.java`
- Campos: `private double raio`
- Construtor: `Circulo(double raio)`
- Métodos: `diametro()`, `area()`, `perimetro()`
- **Verificação:** compila sem erros (`javac`)

### Tarefa 2 — Escrever `test/entities/CirculoTest.java`
- Testes JUnit 5 para `diametro()`, `area()`, `perimetro()` com raio 5.0 e 1.0
- **Verificação:** testes executam e passam

### CHECKPOINT A — Entidade + Testes verdes ✓

### Tarefa 3 — Atualizar `src/application/Main.java`
- Adicionar bloco que lê raio do teclado e imprime diâmetro, área e perímetro do círculo
- **Verificação:** execução manual com raio `5` exibe valores corretos

### CHECKPOINT B — Fluxo completo funcionando ✓

### Tarefa 4 — Revisão e simplificação
- `/review` → `/code-simplify`
- **Verificação:** sem issues de correção, legibilidade ou segurança

### Tarefa 5 — Commit e ship
- Commit atômico com mensagem descritiva
- **Verificação:** `git log` mostra commit limpo

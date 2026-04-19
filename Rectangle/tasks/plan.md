# Plano de Implementação — Rectangle (Evolução Profissional)

## Grafo de Dependências

```
TAREFA-1 (Encapsulamento + Construtor + toString)
    │
    ├── TAREFA-2 (Validação + Exceções)
    │       │
    │       └── TAREFA-3 (Main.java — tratamento de erro + separação)
    │                   │
    │                   └── CHECKPOINT-A ✓ (código funcional e profissional)
    │
TAREFA-4 (Estrutura de pastas lib/ e test/)
    │
    └── TAREFA-5 (RectangleTest.java — 9 casos de teste)
                │
                └── CHECKPOINT-B ✓ (todos os testes passando)
```

**Regra:** cada tarefa só começa após a anterior estar verificada e compilando.

---

## FASE 1 — Classe Rectangle

---

### TAREFA-1 — Encapsulamento, Construtor e toString()

**O que fazer:**
- Tornar `width` e `height` `private`
- Adicionar `getWidth()`, `getHeight()`, `setWidth(double)`, `setHeight(double)`
- Adicionar construtor `Rectangle(double width, double height)`
- Manter construtor padrão `Rectangle()`
- Sobrescrever `toString()`

**Por que essa ordem:**
O encapsulamento é a fundação. Sem ele, validação e testes não fazem sentido —
qualquer código externo poderia contornar os setters acessando o campo direto.

**Critérios de aceite:**
- [ ] `width` e `height` são `private`
- [ ] `new Rectangle(4.0, 3.0)` cria objeto com valores corretos
- [ ] `getWidth()` retorna `4.0`, `getHeight()` retorna `3.0`
- [ ] `toString()` retorna `"Rectangle [width=4.0, height=3.0]"`
- [ ] Compila sem erros: `javac src/entities/Rectangle.java`

**Verificação:**
```bash
javac src/entities/Rectangle.java
# Sem erros = OK
```

---

### TAREFA-2 — Validação com IllegalArgumentException

**Depende de:** TAREFA-1

**O que fazer:**
- `setWidth(double v)`: lança `IllegalArgumentException("Width must be positive")` se `v <= 0`
- `setHeight(double v)`: lança `IllegalArgumentException("Height must be positive")` se `v <= 0`
- Construtor `Rectangle(double w, double h)` chama os setters (herda a validação automaticamente)

**Por que chamar os setters no construtor:**
Evita duplicação da lógica de validação. O construtor não precisa saber as regras —
ele delega para os setters que já as conhecem.

**Critérios de aceite:**
- [ ] `setWidth(-1)` lança `IllegalArgumentException`
- [ ] `setWidth(0)` lança `IllegalArgumentException`
- [ ] `setHeight(-5)` lança `IllegalArgumentException`
- [ ] `new Rectangle(-1, 3)` lança `IllegalArgumentException`
- [ ] `new Rectangle(4, 3)` não lança exceção

---

### TAREFA-3 — Main.java: separação de responsabilidades + tratamento de erro

**Depende de:** TAREFA-2

**O que fazer:**
- `Main.java` lê entrada do usuário e cria `Rectangle` via construtor com parâmetros
- Envolve a criação em `try/catch(IllegalArgumentException)`
- Exibe mensagem amigável em caso de erro: `"Erro: " + e.getMessage()`
- Remove qualquer lógica de cálculo do `main` (já estava correto, mas garantir)

**Por que try/catch no main:**
A exceção deve ser lançada na camada de negócio (Rectangle) e tratada na camada
de apresentação (Main). Essa separação é o padrão profissional.

**Critérios de aceite:**
- [ ] `Main.java` usa `new Rectangle(width, height)` (construtor com parâmetros)
- [ ] Entrada negativa exibe `"Erro: Width must be positive"` e não trava
- [ ] Entrada válida exibe área, perímetro e diagonal corretamente
- [ ] Nenhum cálculo dentro do `main`

**Verificação:**
```bash
javac -cp src src/application/Main.java src/entities/Rectangle.java
java -cp src application.Main
# Testar com: 4.0 e 3.0  → ÁREA=12.00, PERÍMETRO=14.00, Diagonal=5.00
# Testar com: -1 e 3     → "Erro: Width must be positive"
```

---

### CHECKPOINT-A — Código funcional e profissional ✓

Antes de avançar para os testes, verificar:
- [ ] Projeto compila sem warnings
- [ ] Execução manual funciona com valores válidos
- [ ] Execução manual trata valores inválidos sem `Exception` não capturada
- [ ] Nenhum atributo `public` na classe `Rectangle`

---

## FASE 2 — Testes JUnit

---

### TAREFA-4 — Estrutura de pastas e JARs do JUnit

**Depende de:** CHECKPOINT-A

**O que fazer:**
- Criar pasta `test/entities/`
- Criar pasta `lib/`
- Baixar os JARs:
  - `junit-4.13.2.jar`
  - `hamcrest-core-1.3.jar`
- Colocar ambos em `lib/`

**Por que dois JARs:**
JUnit 4 depende do Hamcrest para os matchers (`assertThat`, `equalTo`, etc.).
Sem o hamcrest, o JUnit não compila.

**Critérios de aceite:**
- [ ] `lib/junit-4.13.2.jar` existe
- [ ] `lib/hamcrest-core-1.3.jar` existe
- [ ] `test/entities/` existe

**Verificação:**
```bash
ls lib/
# junit-4.13.2.jar  hamcrest-core-1.3.jar
```

---

### TAREFA-5 — RectangleTest.java: 9 casos de teste

**Depende de:** TAREFA-4

**O que fazer:**
Criar `test/entities/RectangleTest.java` com os 9 casos de teste:

| # | Método de teste                    | O que prova                                      |
|---|------------------------------------|--------------------------------------------------|
| 1 | `testArea`                         | `area()` = `width * height`                      |
| 2 | `testPerimeter`                    | `perimeter()` = `2 * (width + height)`           |
| 3 | `testDiagonal`                     | `diagonal()` = `sqrt(w² + h²)` (Pitágoras)       |
| 4 | `testConstructorSetsValues`        | Construtor inicializa `width` e `height`          |
| 5 | `testNegativeWidthThrows`          | `setWidth(-1)` lança `IllegalArgumentException`  |
| 6 | `testNegativeHeightThrows`         | `setHeight(-1)` lança `IllegalArgumentException` |
| 7 | `testZeroWidthThrows`              | `setWidth(0)` lança `IllegalArgumentException`   |
| 8 | `testConstructorWithInvalidValues` | `new Rectangle(-1, 3)` lança exceção             |
| 9 | `testToString`                     | `toString()` retorna formato correto             |

**Anatomia de um teste JUnit 4:**
```java
@Test                              // anotação obrigatória
public void testArea() {
    Rectangle r = new Rectangle(4.0, 3.0);
    assertEquals(12.0, r.area(), 0.001);  // valor esperado, valor real, delta
}
```
O `delta` (0.001) existe porque `double` tem imprecisão de ponto flutuante —
não comparamos igualdade exata, mas "próximo o suficiente".

**Para exceções esperadas:**
```java
@Test(expected = IllegalArgumentException.class)  // JUnit espera essa exceção
public void testNegativeWidthThrows() {
    Rectangle r = new Rectangle(4.0, 3.0);
    r.setWidth(-1);  // deve lançar a exceção
}
```

**Critérios de aceite:**
- [ ] Arquivo compila sem erros
- [ ] Todos os 9 testes passam (0 falhas, 0 erros)
- [ ] Saída final: `OK (9 tests)`

**Compilação:**
```bash
javac -cp src:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar \
      -d test \
      test/entities/RectangleTest.java src/entities/Rectangle.java
```

**Execução:**
```bash
java -cp src:test:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar \
     org.junit.runner.JUnitCore entities.RectangleTest
```

---

### CHECKPOINT-B — Todos os testes passando ✓

- [ ] `OK (9 tests)` na saída do JUnit
- [ ] Zero falhas, zero erros
- [ ] Código pronto para `/review` e `/code-simplify`

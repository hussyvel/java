# SPEC — Rectangle (Evolução Profissional)

## 1. Objetivo

Evoluir o exercício acadêmico `Rectangle` para um projeto Java com qualidade profissional,
aplicando os princípios de OOP: encapsulamento, validação, construtores, cobertura de testes
e separação de responsabilidades — mantendo a estrutura de pacotes existente.

**Usuário-alvo:** desenvolvedor Java em formação, aprendendo boas práticas reais de mercado.

---

## 2. Melhorias Planejadas (todas obrigatórias)

### a) Encapsulamento
- `width` e `height` passam de `public` para `private`
- Acesso via `getWidth()`, `getHeight()`, `setWidth(double)`, `setHeight(double)`
- Os setters validam: valor deve ser `> 0`, caso contrário lançam `IllegalArgumentException`

### b) Construtor
- Adicionar `Rectangle(double width, double height)` que valida os valores na criação
- Manter também construtor padrão `Rectangle()` para compatibilidade

### c) toString()
- Sobrescrever `toString()` para retornar uma representação legível:
  `Rectangle [width=4.0, height=3.0]`

### d) Tratamento de erros
- Valores `<= 0` lançam `IllegalArgumentException` com mensagem clara
- O `Main.java` captura a exceção e exibe mensagem amigável ao usuário

### e) Testes unitários com JUnit
- Cobertura de todos os métodos: `area()`, `perimeter()`, `diagonal()`
- Testes de validação: valores negativos, zero, construtor inválido
- Testes de `toString()`
- Usar JUnit 4 (compatível com Java 8+) — sem Maven/Gradle (jar manual)

### f) Separação de responsabilidades
- `Main.java` não contém lógica de negócio — apenas leitura, delegação e impressão
- Toda lógica fica na classe `Rectangle`

---

## 3. Estrutura de Pacotes (preservada)

```
Rectangle/
├── src/
│   ├── entities/
│   │   └── Rectangle.java          ← entidade principal (modificada)
│   └── application/
│       └── Main.java               ← ponto de entrada (modificado)
├── test/
│   └── entities/
│       └── RectangleTest.java      ← testes unitários (novo)
├── lib/
│   ├── junit-4.13.2.jar            ← JUnit (adicionar manualmente)
│   └── hamcrest-core-1.3.jar       ← dependência do JUnit
└── SPEC.md
```

---

## 4. Estilo de Código (Java 8/11)

- Java 8 como baseline; compatível com Java 11
- Sem uso de `record`, `var`, `sealed` (features pós-11)
- Nomes em inglês, camelCase para métodos e atributos
- Constantes em UPPER_SNAKE_CASE se necessário
- Sem comentários óbvios; apenas onde o "porquê" não é evidente
- Cada método faz uma coisa só (Single Responsibility)
- `printf` com `Locale.US` para garantir ponto como separador decimal

---

## 5. Estratégia de Testes (JUnit 4 — sem build tool)

### Por que JUnit?
JUnit permite **provar automaticamente** que cada método funciona corretamente,
em vez de testar manualmente rodando o programa. Um teste escrito uma vez
pode ser re-executado infinitas vezes sem esforço humano.

### Como usar sem Maven/Gradle
1. Baixar `junit-4.13.2.jar` e `hamcrest-core-1.3.jar`
2. Colocar na pasta `lib/`
3. Compilar: `javac -cp src:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar test/entities/RectangleTest.java`
4. Executar: `java -cp src:test:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore entities.RectangleTest`

### Casos de teste planejados

| Teste                              | O que verifica                              |
|------------------------------------|---------------------------------------------|
| `testArea`                         | `area()` retorna `width * height`           |
| `testPerimeter`                    | `perimeter()` retorna `2*(w+h)`             |
| `testDiagonal`                     | `diagonal()` usa Pitágoras corretamente     |
| `testConstructorSetsValues`        | Construtor define width e height            |
| `testNegativeWidthThrows`          | Setter lança exceção para width <= 0        |
| `testNegativeHeightThrows`         | Setter lança exceção para height <= 0       |
| `testZeroWidthThrows`              | Valor zero também é inválido                |
| `testConstructorWithInvalidValues` | Construtor rejeita valores inválidos        |
| `testToString`                     | `toString()` retorna formato esperado       |

---

## 6. Limites (Boundaries)

### Sempre fazer
- Validar entradas nos setters e construtores
- Lançar `IllegalArgumentException` com mensagem descritiva
- Manter separação `entities` / `application`
- Usar `Locale.US` em saídas numéricas

### Perguntar antes
- Adicionar novos métodos não previstos neste spec
- Alterar nomes de pacotes ou classes
- Adicionar dependências além de JUnit

### Nunca fazer
- Usar features Java > 11 (records, sealed classes, var em campos)
- Colocar lógica de negócio no `Main.java`
- Deixar atributos `public` na classe `Rectangle`
- Ignorar entradas inválidas sem tratar

---

## 7. Critérios de Aceite

- [ ] `Rectangle` compila sem warnings com `javac`
- [ ] Atributos `width` e `height` são `private`
- [ ] Construtor com parâmetros funciona e valida
- [ ] `setWidth(-1)` lança `IllegalArgumentException`
- [ ] `setHeight(0)` lança `IllegalArgumentException`
- [ ] `area()`, `perimeter()`, `diagonal()` retornam valores corretos
- [ ] `toString()` retorna `Rectangle [width=X.X, height=Y.Y]`
- [ ] `Main.java` captura exceção e exibe mensagem amigável
- [ ] Todos os testes JUnit passam
- [ ] Código não contém lógica de negócio fora de `entities/`

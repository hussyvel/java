# TODO — Rectangle (Evolução Profissional)

## FASE 1 — Classe Rectangle

- [ ] **TAREFA-1** — Encapsulamento + Construtor + toString()
  - Tornar `width` e `height` private
  - Adicionar getters e setters
  - Adicionar construtor `Rectangle(double width, double height)`
  - Manter construtor padrão `Rectangle()`
  - Sobrescrever `toString()`

- [ ] **TAREFA-2** — Validação com IllegalArgumentException
  - Setters lançam exceção para valores <= 0
  - Construtor delega validação para os setters

- [ ] **TAREFA-3** — Main.java: separação + tratamento de erro
  - Usar construtor com parâmetros
  - try/catch para IllegalArgumentException
  - Mensagem amigável ao usuário

- [ ] **CHECKPOINT-A** — Verificar compilação e execução manual

## FASE 2 — Testes JUnit

- [ ] **TAREFA-4** — Criar estrutura lib/ e test/, baixar JARs
  - lib/junit-4.13.2.jar
  - lib/hamcrest-core-1.3.jar
  - test/entities/

- [ ] **TAREFA-5** — RectangleTest.java com 9 casos de teste
  - testArea
  - testPerimeter
  - testDiagonal
  - testConstructorSetsValues
  - testNegativeWidthThrows
  - testNegativeHeightThrows
  - testZeroWidthThrows
  - testConstructorWithInvalidValues
  - testToString

- [ ] **CHECKPOINT-B** — OK (9 tests) na saída do JUnit

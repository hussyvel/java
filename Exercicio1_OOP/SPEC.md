# SPEC.md — Classe Círculo

## 1. Objetivo

Adicionar a classe `Circulo` ao projeto `Exercicio1_OOP`, seguindo o mesmo padrão da classe `Retangulo`. O programa deve ler o raio do teclado e exibir diâmetro, área e perímetro do círculo.

## 2. Critérios de Aceite

- [ ] Classe `Circulo` criada em `src/entities/Circulo.java`
- [ ] Métodos: `diametro()`, `area()`, `perimetro()`
- [ ] `Main.java` atualizado para ler raio e exibir os três resultados
- [ ] Testes JUnit para os três métodos com valores conhecidos
- [ ] Todos os testes passam

## 3. Estrutura do Projeto

```
src/
  entities/
    Retangulo.java   (existente)
    Circulo.java     (novo)
  application/
    Main.java        (atualizar)
test/
  entities/
    CirculoTest.java (novo)
```

## 4. Estilo de Código

- Mesmo padrão de `Retangulo`: classe com campos `private`, construtor com parâmetros, sem setters
- `Locale.US` para formatação decimal
- Saída com `printf("%.2f%n", ...)`
- Fórmulas: diâmetro = 2r, área = π·r², perímetro = 2·π·r
- Usar `Math.PI` para π

## 5. Estratégia de Testes (JUnit 5)

| Método       | Entrada (raio) | Esperado       |
|--------------|----------------|----------------|
| diametro()   | 5.0            | 10.0           |
| area()       | 5.0            | 78.54 (≈)      |
| perimetro()  | 5.0            | 31.42 (≈)      |
| diametro()   | 1.0            | 2.0            |
| area()       | 1.0            | 3.14159... (≈) |

Usar `assertEquals` com delta `1e-9` para doubles exatos e `0.01` para valores arredondados.

## 6. Limites

- **Sempre:** seguir o estilo de `Retangulo`
- **Nunca:** usar setters ou campos públicos
- **Fora do escopo:** validação de raio negativo

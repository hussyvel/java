# Plan: Exercicio2_OOP — Employee Salary

## State at Planning Time
- `src/entities/Employee.java` — implemented ✅
- `src/application/Program.java` — implemented ✅
- `SPEC.md` — written ✅
- Tests — not written ❌
- Code review — not done ❌
- Simplification — not done ❌
- Ship (commit) — not done ❌

## Dependency Graph
```
[Employee.java] ──→ [Program.java]
      │
      ▼
[Tests] ──→ [Review] ──→ [Simplify] ──→ [Ship]
```

## Implementation Order
1. **Test** — verify Employee logic with unit tests (no dependencies)
2. **Review** — five-axis review of both files
3. **Simplify** — apply code-simplification improvements found in review
4. **Ship** — commit with clean message

## Risks
| Risk | Mitigation |
|------|-----------|
| No test framework configured | Use plain Java assertions or JUnit if available |
| `Double` vs `double` inconsistency | Flag in review |
| `Scanner` not closed on exception | Flag in review |

## Checkpoints
- After test: all assertions pass
- After review: issues listed and prioritized
- After simplify: no behavior change, code shorter/cleaner
- After ship: clean git commit on master

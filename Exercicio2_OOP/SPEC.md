# Spec: Exercicio2_OOP — Employee Salary

## Objective
Console program in Java that reads employee data (name, gross salary, and tax), applies a percentage increase to the gross salary only, and displays the updated data.

**User:** student practicing Java OOP — encapsulation, constructors, and business methods.

**Acceptance criteria:**
- Read name, gross salary, and tax from console
- Read a percentage and apply it only to gross salary
- Tax is not affected by the increase
- Display updated name, gross salary, tax, and net salary formatted to 2 decimal places

## Tech Stack
- Java 17+
- IntelliJ IDEA
- No external dependencies

## Commands
```
Compile: javac -d out src/entities/Employee.java src/application/Program.java
Run:     java -cp out application.Program
```

## Project Structure
```
src/
  entities/
    Employee.java       → Domain class (name, grossSalary, tax)
  application/
    Program.java        → Entry point: input, processing, output
```

## Code Style
```java
// Example interaction:
Enter employee name: Alex
Enter gross salary: 6000.00
Enter tax: 1000.00
What percentage to increase salary? 10.0

Updated employee data:
Name: Alex
Gross salary: R$ 6600.00
Tax: R$ 1000.00
Net salary: R$ 5600.00
```

Conventions:
- `private` attributes, `public` methods
- No setters — salary changed only via `increaseSalary(double percentage)`
- `toString()` on the entity for display
- `Locale.US` for decimal formatting

## Testing Strategy
- Manual console test with the example above
- Verify tax does not change after salary increase
- Verify net salary = gross salary − tax after increase
- Verify output uses 2 decimal places

## Boundaries
- **Always:** encapsulate attributes; use `increaseSalary()` to modify salary
- **Ask first:** change tax to a percentage-based value instead of fixed amount
- **Never:** modify `tax` inside `increaseSalary()`

## Success Criteria
- [ ] `Employee` class compiles with no errors
- [ ] `Program.java` reads all inputs correctly
- [ ] After 10% increase on R$ 6000.00 → gross salary = R$ 6600.00
- [ ] Tax remains unchanged after increase
- [ ] Net salary displayed correctly: gross − tax
- [ ] Output formatted to 2 decimal places

## Open Questions
None — requirements confirmed by user.

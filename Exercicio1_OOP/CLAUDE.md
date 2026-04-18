# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Java OOP exercise implementing a `Retangulo` (Rectangle) class that computes area, perimeter, and diagonal. This is an IntelliJ IDEA project (see `Exercicio1_OOP.iml`).

## Build & Run

Compile from `src/` with both packages on the source path:

```bash
javac -d out/production/Exercicio1_OOP src/entities/Retangulo.java src/application/Main.java
```

Run (expects two doubles on stdin: height then width):

```bash
java -cp out/production/Exercicio1_OOP application.Main
```

Or use IntelliJ IDEA's built-in run configuration.

## Architecture

```
src/
  entities/Retangulo.java     — domain model: width, height, area(), perimetro(), diagonal()
  application/Main.java       — entry point: reads two doubles from stdin, prints results
```

- `Retangulo` is a plain value class with no setters; constructed with `(largura, altura)` (width, height).
- `Main` reads `altura` first, then `largura` from stdin (note: prompt says "width and height" but input order is height then width).
- Output uses `Locale.US` for decimal formatting.

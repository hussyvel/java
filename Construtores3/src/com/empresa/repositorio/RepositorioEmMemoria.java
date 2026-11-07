package com.empresa.repositorio;

import com.empresa.dominio.Entidade;
import com.empresa.dominio.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioEmMemoria<T extends Entidade<ID>, ID> implements RepositorioGenerico<T, ID> {

    // O armazenamento interno baseia-se num ArrayList
    private final List<T> dados = new ArrayList<>();

    @Override
    public void guardar(Produto entidade) {
        dados.add(entidade);
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        // Uso da Stream API do Java 8 para uma busca limpa e funcional
        return dados.stream()
                .filter(elemento -> elemento.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<T> buscarTodos() {
        // Retorna uma cópia defensiva para proteger os dados internos (Encapsulamento)
        return new ArrayList<>(dados);
    }
}
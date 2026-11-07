package com.empresa.repositorio;

import com.empresa.dominio.Produto;

import java.util.List;
import java.util.Optional;

public interface RepositorioGenerico<T, ID> {
    void guardar(Produto entidade);
    Optional<T> buscarPorId(ID id);
    List<T> buscarTodos();
}

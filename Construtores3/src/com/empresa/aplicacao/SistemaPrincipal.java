package com.empresa.aplicacao;

import com.empresa.dominio.Produto;
import com.empresa.repositorio.RepositorioEmMemoria;
import com.empresa.repositorio.RepositorioGenerico;
import java.math.BigDecimal;

public class SistemaPrincipal {

    public static void main(String[] args) {
        System.out.println("--- A iniciar o Sistema de Catálogo ---");

        // 1. Instanciamos o Repositório Genérico tipado para 'Produto' e ID 'Long'
        RepositorioGenerico<Produto, Long> repositorio = new RepositorioEmMemoria<>();

        // 2. Uso do 'var' do Java 11 e dos Métodos Fábrica Estáticos
        var portatil = Produto.criarNovo(1L, "Portátil Profissional", new BigDecimal("1250.00"));
        var rato = Produto.criarNovo(2L, "Rato sem fios", new BigDecimal("45.99"));

        // 3. Guardar no repositório
        repositorio.guardar(portatil);
        repositorio.guardar(rato);

        System.out.println("\nLista de todos os produtos guardados:");
        // Uso de Streams e Method Reference (Java 8) para iteração
        repositorio.buscarTodos().forEach(System.out::println);

        System.out.println("\nA procurar produto pelo ID 1:");
        repositorio.buscarPorId(1L).ifPresentOrElse(
                produtoEncontrado -> System.out.println("Encontrado: " + produtoEncontrado),
                () -> System.out.println("Produto não encontrado.")
        );
    }
}
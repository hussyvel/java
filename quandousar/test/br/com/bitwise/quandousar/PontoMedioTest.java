package br.com.bitwise.quandousar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PontoMedioTest {

    @Test
    void calculaOMeioDeValoresPequenos() {
        assertEquals(5, PontoMedio.entre(0, 10));
    }

    @Test
    void arredondaParaBaixo() {
        assertEquals(4, PontoMedio.entre(3, 6));
    }

    @Test
    void naoEstouraComValoresGrandes() {
        assertEquals(1_750_000_000, PontoMedio.entre(1_500_000_000, 2_000_000_000));
    }

    @Test
    void funcionaNoLimiteDoInt() {
        assertEquals(Integer.MAX_VALUE, PontoMedio.entre(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void aDivisaoComumEstouraNoMesmoCaso() {
        int low = 1_500_000_000;
        int high = 2_000_000_000;

        assertTrue((low + high) / 2 < 0, "a soma passa de Integer.MAX_VALUE e vira negativa");
    }

    @Test
    void rejeitaIndiceNegativo() {
        assertThrows(IllegalArgumentException.class, () -> PontoMedio.entre(-1, 10));
    }
}

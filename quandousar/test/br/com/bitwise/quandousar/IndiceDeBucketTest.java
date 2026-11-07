package br.com.bitwise.quandousar;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IndiceDeBucketTest {

    /** Chave com hashCode ruim: múltiplo de 1024, então os 10 bits de baixo são sempre zero. */
    private record ChaveRuim(int id) {
        @Override
        public int hashCode() {
            return id * 1024;
        }
    }

    @Test
    void indiceFicaDentroDaCapacidade() {
        for (String chave : new String[] {"Bloch", "Goetz", "Kabutz", "Thompson"}) {
            int indice = IndiceDeBucket.de(chave, 16);

            assertTrue(indice >= 0 && indice < 16, chave + " -> " + indice);
        }
    }

    @Test
    void espalharTrazOsBitsAltosParaBaixo() {
        int hash = 0x0001_0000; // único bit ligado está na posição 16

        assertEquals(0x0001_0001, IndiceDeBucket.espalhar(hash));
    }

    @Test
    void semEspalharUmHashRuimCaiTodoNoMesmoBucket() {
        Set<Integer> buckets = new HashSet<>();
        for (int id = 0; id < 1000; id++) {
            buckets.add(new ChaveRuim(id).hashCode() & (1024 - 1));
        }

        assertEquals(1, buckets.size());
    }

    @Test
    void espalharAjudaMasNaoConsertaUmHashRuim() {
        Set<Integer> buckets = new HashSet<>();
        for (int id = 0; id < 1000; id++) {
            buckets.add(IndiceDeBucket.de(new ChaveRuim(id), 1024));
        }

        assertEquals(16, buckets.size()); // melhor que 1, longe de 1000
    }

    @Test
    void rejeitaCapacidadeQueNaoEPotenciaDeDois() {
        assertThrows(IllegalArgumentException.class, () -> IndiceDeBucket.de("x", 10));
    }

    @Test
    void rejeitaChaveNula() {
        assertThrows(NullPointerException.class, () -> IndiceDeBucket.de(null, 16));
    }
}

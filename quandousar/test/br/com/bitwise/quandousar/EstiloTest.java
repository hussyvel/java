package br.com.bitwise.quandousar;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** EVITAR 1 (Bloch, Effective Java, Item 36): EnumSet no lugar de campos de bits. */
class EstiloTest {

    @Test
    void enumSetDizQuaisEstilosEstaoAtivos() {
        Set<Estilo> estilos = EnumSet.of(Estilo.NEGRITO, Estilo.ITALICO);

        assertTrue(estilos.contains(Estilo.NEGRITO));
        assertFalse(estilos.contains(Estilo.SUBLINHADO));
    }

    @Test
    void enumSetSeImprimeDeFormaLegivel() {
        assertEquals("[NEGRITO, ITALICO]", EnumSet.of(Estilo.ITALICO, Estilo.NEGRITO).toString());
    }

    @Test
    void campoDeBitsViraUmNumeroSemSignificado() {
        int negrito = 1 << 0;
        int italico = 1 << 1;

        assertEquals(3, negrito | italico); // "3" não diz nada sem olhar as constantes
    }
}

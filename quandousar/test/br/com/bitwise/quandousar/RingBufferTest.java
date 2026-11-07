package br.com.bitwise.quandousar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RingBufferTest {

    @Test
    void aceitaTamanhoPotenciaDeDois() {
        assertEquals(8, new RingBuffer<String>(8).capacidade());
    }

    @Test
    void rejeitaTamanhoQueNaoEPotenciaDeDois() {
        assertThrows(IllegalArgumentException.class, () -> new RingBuffer<String>(10));
    }

    @Test
    void rejeitaZero() {
        assertThrows(IllegalArgumentException.class, () -> new RingBuffer<String>(0));
    }

    @Test
    void rejeitaMenorIntMesmoTendoUmUnicoBitLigado() {
        assertThrows(IllegalArgumentException.class, () -> new RingBuffer<String>(Integer.MIN_VALUE));
    }

    @Test
    void mascaraDaOMesmoSlotQueORestoDaDivisao() {
        RingBuffer<String> anel = new RingBuffer<>(1024);

        for (long sequencia = 0; sequencia < 100_000; sequencia++) {
            assertEquals(sequencia % 1024, anel.slotDe(sequencia));
        }
    }

    @Test
    void sequenciaNovaSobrescreveOMesmoSlot() {
        RingBuffer<String> anel = new RingBuffer<>(8);

        anel.publicar(3, "evento-3");
        anel.publicar(11, "evento-11");

        assertEquals("evento-11", anel.ler(3));
    }

    @Test
    void slotNuncaUsadoDevolveNull() {
        assertNull(new RingBuffer<String>(4).ler(0));
    }
}

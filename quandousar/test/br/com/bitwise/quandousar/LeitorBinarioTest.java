package br.com.bitwise.quandousar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LeitorBinarioTest {

    @Test
    void leDoisBytesComoNumeroSemSinal() {
        byte[] pacote = {(byte) 0xC3, (byte) 0x50};

        assertEquals(50_000, LeitorBinario.uint16BigEndian(pacote, 0));
    }

    @Test
    void oByteMaisSignificativoVemPrimeiro() {
        byte[] pacote = {0x01, 0x02};

        assertEquals(0x0102, LeitorBinario.uint16BigEndian(pacote, 0));
    }

    @Test
    void leOMaiorValorPossivel() {
        byte[] pacote = {(byte) 0xFF, (byte) 0xFF};

        assertEquals(65_535, LeitorBinario.uint16BigEndian(pacote, 0));
    }

    @Test
    void respeitaAPosicaoInicial() {
        byte[] pacote = {0x00, 0x00, 0x12, 0x34};

        assertEquals(0x1234, LeitorBinario.uint16BigEndian(pacote, 2));
    }

    @Test
    void semMascaraOByteNegativoEstragaOResultado() {
        byte[] pacote = {(byte) 0xC3, (byte) 0x50};

        assertEquals(-15_536, (pacote[0] << 8) | pacote[1]);
    }

    @Test
    void rejeitaPosicaoSemDoisBytesDisponiveis() {
        byte[] pacote = {0x01, 0x02};

        assertThrows(IndexOutOfBoundsException.class, () -> LeitorBinario.uint16BigEndian(pacote, 1));
    }
}

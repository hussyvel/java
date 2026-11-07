package br.com.bitwise.quandousar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Comportamentos da linguagem que justificam os itens "EVITAR".
 * Não testam código nosso: documentam, de forma executável, como o Java se comporta.
 */
class ArmadilhasTest {

    // EVITAR 2 - Bloch / Goetz: o shift "esperto" não ganha nada

    @Test
    void shiftEMultiplicacaoPor31DaoOMesmoResultado() {
        int[] valores = {0, 7, -7, 1_000_000, Integer.MAX_VALUE, Integer.MIN_VALUE};

        for (int r : valores) {
            assertEquals(31 * r + 3, ((r << 5) - r) + 3, "r = " + r);
        }
    }

    // EVITAR 3 - Java Puzzlers / CERT NUM14-J: shifts perigosos

    @Test
    void distanciaDoShiftEmIntUsaApenasOsCincoBitsDeBaixo() {
        int distancia = 32;

        assertEquals(1, 1 << distancia); // 32 & 31 == 0, então é 1 << 0
    }

    @Test
    void shiftSemSinalEmShortContinuaNegativo() {
        short s = -1;
        s >>>= 10; // promove para int, desloca e corta de volta para 16 bits

        assertEquals(-1, s);
    }

    @Test
    void shiftSemSinalEmIntFuncionaComoEsperado() {
        assertEquals(4_194_303, -1 >>> 10); // 22 bits ligados
    }

    // EVITAR 5 - Horstmann: & e | não fazem curto-circuito

    @Test
    void eLogicoDuploParaAntesDeAvaliarOLadoDireito() {
        String nome = null;

        assertFalse(nome != null && nome.length() > 3);
    }

    @Test
    void eBitABitAvaliaOsDoisLadosELancaExcecao() {
        String nome = null;

        assertThrows(NullPointerException.class, () -> {
            boolean ignorado = nome != null & nome.length() > 3;
        });
    }
}

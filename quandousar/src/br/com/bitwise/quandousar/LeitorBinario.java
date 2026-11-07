package br.com.bitwise.quandousar;

import java.util.Objects;

/**
 * USAR 4 - Horstmann / Kabutz: formatos binários e bytes sem sinal.
 * <p>
 * {@code byte} em Java tem sinal: 0xC3 vale -61. Ao virar int, ganha 24 bits 1
 * à esquerda. O {@code & 0xFF} apaga esses bits e recupera o valor 0..255.
 */
public final class LeitorBinario {

    private static final int MASCARA_DO_BYTE = 0xFF;
    private static final int BITS_POR_BYTE = 8;
    private static final int BYTES_DO_UINT16 = 2;

    private LeitorBinario() {
    }

    /** Lê 2 bytes a partir de {@code posicao}, o mais significativo primeiro (ordem de rede). */
    public static int uint16BigEndian(byte[] dados, int posicao) {
        Objects.requireNonNull(dados, "dados são obrigatórios");
        Objects.checkFromIndexSize(posicao, BYTES_DO_UINT16, dados.length);

        int alto = semSinal(dados[posicao]);
        int baixo = semSinal(dados[posicao + 1]);
        return (alto << BITS_POR_BYTE) | baixo;
    }

    private static int semSinal(byte valor) {
        return valor & MASCARA_DO_BYTE;
    }
}

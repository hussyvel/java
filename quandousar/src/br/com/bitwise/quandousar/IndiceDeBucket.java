package br.com.bitwise.quandousar;

import java.util.Objects;

/**
 * USAR 3 - Bloch e Doug Lea (HashMap) / Kabutz: escolha de bucket por máscara.
 * <p>
 * Igual ao HashMap do Java 8+: primeiro espalha os bits altos do hash nos baixos,
 * depois usa {@code hash & (capacidade - 1)} no lugar de {@code %}.
 */
public final class IndiceDeBucket {

    private static final int METADE_DOS_BITS = Integer.SIZE / 2;

    private IndiceDeBucket() {
    }

    public static int de(Object chave, int capacidade) {
        Objects.requireNonNull(chave, "chave é obrigatória");
        PotenciaDeDois.exigir(capacidade, "capacidade");
        return espalhar(chave.hashCode()) & (capacidade - 1);
    }

    /**
     * Mistura os 16 bits altos nos 16 baixos. Sem isso, a máscara só enxerga
     * os bits baixos e hashes que diferem só no alto colidem sempre.
     */
    public static int espalhar(int hash) {
        return hash ^ (hash >>> METADE_DOS_BITS);
    }
}

package br.com.bitwise.quandousar;

/**
 * EVITAR 1 - Bloch, Effective Java, Item 36.
 * <p>
 * Em vez de constantes {@code int} combinadas com {@code |}, use um enum com
 * {@code EnumSet}: é tipado, legível e, por dentro, continua sendo um vetor de bits.
 */
public enum Estilo {
    NEGRITO,
    ITALICO,
    SUBLINHADO
}

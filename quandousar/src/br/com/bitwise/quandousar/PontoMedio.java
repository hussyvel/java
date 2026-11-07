package br.com.bitwise.quandousar;

/**
 * USAR 2 - Joshua Bloch: ponto médio sem estouro.
 * <p>
 * {@code (low + high) / 2} estoura quando a soma passa de {@code Integer.MAX_VALUE}
 * (bug que ficou anos no {@code Arrays.binarySearch}). Tratando a soma como
 * número sem sinal com {@code >>> 1}, o bit que "vazou" para o sinal volta a contar.
 */
public final class PontoMedio {

    private PontoMedio() {
    }

    /** Meio entre dois índices não negativos, arredondado para baixo. */
    public static int entre(int low, int high) {
        if (low < 0 || high < 0) {
            throw new IllegalArgumentException("índices devem ser não negativos: " + low + ", " + high);
        }
        return (low + high) >>> 1;
    }
}

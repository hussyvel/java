package br.com.bitwise.quandousar;

/**
 * Validação compartilhada por quem troca {@code %} por máscara:
 * a troca só é correta quando o divisor é potência de 2.
 */
final class PotenciaDeDois {

    private PotenciaDeDois() {
    }

    /** Potência de 2 positiva tem exatamente um bit ligado (8 = 0b1000). */
    static boolean verifica(int valor) {
        return valor > 0 && Integer.bitCount(valor) == 1;
    }

    static void exigir(int valor, String nome) {
        if (!verifica(valor)) {
            throw new IllegalArgumentException(nome + " deve ser potência de 2 positiva: " + valor);
        }
    }
}

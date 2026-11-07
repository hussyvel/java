package br.com.bitwise.quandousar;

/**
 * USAR 1 - Martin Thompson (LMAX Disruptor).
 * <p>
 * Buffer circular de tamanho fixo indexado por uma sequência que só cresce.
 * Com tamanho potência de 2, {@code sequencia & (tamanho - 1)} substitui
 * {@code sequencia % tamanho} sem a divisão, que é cara para a CPU.
 */
public final class RingBuffer<E> {

    private final Object[] slots;
    private final long mascara;

    public RingBuffer(int tamanho) {
        PotenciaDeDois.exigir(tamanho, "tamanho");
        this.slots = new Object[tamanho];
        this.mascara = tamanho - 1; // 8 -> 0b0111
    }

    public void publicar(long sequencia, E evento) {
        slots[slotDe(sequencia)] = evento;
    }

    @SuppressWarnings("unchecked") // seguro: só entra no array o que passou por publicar(E)
    public E ler(long sequencia) {
        return (E) slots[slotDe(sequencia)];
    }

    public int capacidade() {
        return slots.length;
    }

    public int slotDe(long sequencia) {
        return (int) (sequencia & mascara);
    }
}

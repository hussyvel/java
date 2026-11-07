package br.com.bitwise.quandousar;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Demonstração: quando usar e quando evitar operadores bitwise,
 * segundo Java Champions e especialistas. Cada seção é um método.
 */
public class Main {

    public static void main(String[] args) {
        secao("QUANDO USAR");
        usarRingBuffer();
        usarPontoMedio();
        usarIndiceDeBucket();
        usarLeitorBinario();

        secao("QUANDO EVITAR");
        evitarCamposDeBits();
        evitarShiftNoLugarDeMultiplicacao();
        evitarShiftsPerigosos();
        evitarHashCodeRuimComMascara();
        evitarAndSemCurtoCircuito();
    }

    private static void usarRingBuffer() {
        topico("[USAR 1] Thompson / Disruptor - ring buffer com sequência & máscara");
        RingBuffer<String> anel = new RingBuffer<>(8);
        for (long sequencia = 0; sequencia < 12; sequencia++) {
            anel.publicar(sequencia, "evento-" + sequencia);
        }
        linha("seq 11 -> slot " + anel.slotDe(11) + " = " + anel.ler(11) + " (11 % 8 = " + (11 % 8) + ")");
        try {
            new RingBuffer<String>(10);
        } catch (IllegalArgumentException e) {
            linha("new RingBuffer(10) -> " + e.getMessage());
        }
    }

    private static void usarPontoMedio() {
        topico("[USAR 2] Bloch - ponto médio seguro");
        int low = 1_500_000_000;
        int high = 2_000_000_000;
        linha("(low + high) / 2   = " + ((low + high) / 2) + "  <- bug");
        linha("(low + high) >>> 1 = " + PontoMedio.entre(low, high) + "  <- correto");
    }

    private static void usarIndiceDeBucket() {
        topico("[USAR 3] HashMap - bucket = espalhar(hash) & (n - 1)");
        for (String chave : new String[] {"Bloch", "Goetz", "Kabutz", "Thompson"}) {
            linha(chave + " -> bucket " + IndiceDeBucket.de(chave, 16));
        }
    }

    private static void usarLeitorBinario() {
        topico("[USAR 4] Formatos binários - ler uint16 big-endian");
        byte[] pacote = {(byte) 0xC3, (byte) 0x50};
        linha("bytes C3 50 -> " + LeitorBinario.uint16BigEndian(pacote, 0)
                + "  (sem & 0xFF daria " + ((pacote[0] << 8) | pacote[1]) + ")");
    }

    private static void evitarCamposDeBits() {
        topico("[EVITAR 1] Bloch, Item 36 - campos de bits em APIs");
        int negrito = 1 << 0;
        int italico = 1 << 1;
        linha("int estilos = " + (negrito | italico) + "  (o que é 3? só olhando as constantes)");
        linha("EnumSet     = " + EnumSet.of(Estilo.NEGRITO, Estilo.ITALICO) + "  (legível e tipado)");
    }

    private static void evitarShiftNoLugarDeMultiplicacao() {
        topico("[EVITAR 2] Bloch / Goetz - micro-otimização com shift");
        int r = 7;
        int c = 3;
        linha("(r << 5) - r + c = " + (((r << 5) - r) + c) + " | 31 * r + c = " + (31 * r + c)
                + "  -> mesmo resultado; a JVM já otimiza, prefira o legível");
    }

    private static void evitarShiftsPerigosos() {
        topico("[EVITAR 3] Java Puzzlers / CERT NUM14-J - shifts perigosos");
        int distancia = 32;
        linha("1 << 32 = " + (1 << distancia) + "  (a distância é usada módulo 32)");
        short s = -1;
        s >>>= 10;
        linha("short -1 >>>= 10 -> " + s + "  (continua -1 por causa do estreitamento)");
        linha("int -1 >>> 10    -> " + (-1 >>> 10) + "  (use int/long para shift sem sinal)");
    }

    private static void evitarHashCodeRuimComMascara() {
        topico("[EVITAR 4] Kabutz, Newsletter 054 - máscara com hashCode ruim");
        int capacidade = 1024;
        Set<Integer> bucketsSemEspalhar = new HashSet<>();
        Set<Integer> bucketsEspalhados = new HashSet<>();
        for (int id = 0; id < 1000; id++) {
            int hashRuim = id * 1024; // os 10 bits de baixo são sempre zero
            bucketsSemEspalhar.add(hashRuim & (capacidade - 1));
            bucketsEspalhados.add(IndiceDeBucket.espalhar(hashRuim) & (capacidade - 1));
        }
        linha("1000 chaves, máscara pura     -> " + bucketsSemEspalhar.size() + " bucket(s)");
        linha("1000 chaves, com espalhamento -> " + bucketsEspalhados.size() + " bucket(s)");
        linha("espalhar ameniza, mas só um hashCode bom resolve");
    }

    private static void evitarAndSemCurtoCircuito() {
        topico("[EVITAR 5] Horstmann - & e | com boolean não fazem curto-circuito");
        String nome = null;
        linha("nome != null && nome.length() > 3 -> " + (nome != null && nome.length() > 3));
        try {
            boolean ignorado = nome != null & nome.length() > 3;
            linha(String.valueOf(ignorado));
        } catch (NullPointerException e) {
            linha("nome != null &  nome.length() > 3 -> NullPointerException");
        }
    }

    private static void secao(String titulo) {
        System.out.println();
        System.out.println("=============== " + titulo + " ===============");
    }

    private static void topico(String titulo) {
        System.out.println();
        System.out.println(titulo);
    }

    private static void linha(String texto) {
        System.out.println("  " + texto);
    }
}

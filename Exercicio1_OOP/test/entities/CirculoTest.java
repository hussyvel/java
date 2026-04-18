package entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CirculoTest {

    private static final double DELTA = 1e-9;
    private static final double DELTA_APROX = 0.01;

    @Test
    public void diametroComRaioCinco() {
        Circulo c = new Circulo(5.0);
        assertEquals(10.0, c.diametro(), DELTA);
    }

    @Test
    public void diametroComRaioUm() {
        Circulo c = new Circulo(1.0);
        assertEquals(2.0, c.diametro(), DELTA);
    }

    @Test
    public void areaComRaioCinco() {
        Circulo c = new Circulo(5.0);
        assertEquals(78.54, c.area(), DELTA_APROX);
    }

    @Test
    public void areaComRaioUm() {
        Circulo c = new Circulo(1.0);
        assertEquals(Math.PI, c.area(), DELTA);
    }

    @Test
    public void perimetroComRaioCinco() {
        Circulo c = new Circulo(5.0);
        assertEquals(31.42, c.perimetro(), DELTA_APROX);
    }

    @Test
    public void perimetroComRaioUm() {
        Circulo c = new Circulo(1.0);
        assertEquals(2 * Math.PI, c.perimetro(), DELTA);
    }
}

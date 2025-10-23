import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora = new Calculadora();

    //caminho 1 e 3
    @Test
    void testeInicioIntervaloNegativo() {
        int[] vetor = {1,2,3,4,5};
        var res = calculadora.calcularMedia(vetor,-3,10);
        assertEquals(-1, res);
    }

    //caminho 1,2,4,6,7,9,10,11,8,7,9,10,11,8,7,12
    @Test
    void testeInicioIntervaloZero() {
        int[] vetor = {4,5};
        var res = calculadora.calcularMedia(vetor,0,10);
        assertEquals(4.5, res,0.0001);
    }

    //caminho 1,2,4,5
    @Test
    void testeInicioIntervaloMaiorQueFimIntervalo() {
        int[] vetor = {4,5};
        var res = calculadora.calcularMedia(vetor,10,5);
        assertEquals(-1, res);
    }

}
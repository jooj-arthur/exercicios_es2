import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SomatoriaTest2 {

    MathOps mockMathOps;
    Somatoria2 somatoria;
    Primo mockPrimo;

    @BeforeEach
    void setup(){
        mockMathOps = mock(MathOps.class);
        somatoria = new Somatoria2(mockMathOps);
        mockPrimo = mock(Primo.class);
    }

    @Test
    void testeVetor5_10() {
        when(mockPrimo.ehPrimo(5)).thenReturn(true);
        when(mockPrimo.ehPrimo(10)).thenReturn(false);
        when(mockMathOps.fatorial(10)).thenReturn(3628800);



        int [] numeros = {5,10};
        int resultado = somatoria.somaDeFatoriais(numeros, mockPrimo);
        assertEquals(3628800,resultado);
        verify(mockMathOps, never()).fatorial(5);
        verify(mockMathOps, times(1)).fatorial(10);
        verify(mockMathOps, times(1)).fatorial((anyInt()));
    }

    @Test
    void testeVetor3_4_4_5() {
        when(mockPrimo.ehPrimo(3)).thenReturn(true);
        when(mockPrimo.ehPrimo(4)).thenReturn(false);
        when(mockPrimo.ehPrimo(5)).thenReturn(true);
        when(mockMathOps.fatorial(4)).thenReturn(24);



        int [] numeros = {3,4,4,5};
        int resultado = somatoria.somaDeFatoriais(numeros, mockPrimo);
        assertEquals(48,resultado);
        verify(mockMathOps, never()).fatorial(5);
        verify(mockMathOps, never()).fatorial(3);
        verify(mockMathOps, times(2)).fatorial(4);
        verify(mockMathOps, times(2)).fatorial((anyInt()));
    }

}
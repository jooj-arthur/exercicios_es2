import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SomatoriaTest {

    MathOps mockMathOps;
    Somatoria somatoria;


    @BeforeEach
    void setup(){
        mockMathOps = mock(MathOps.class);
        somatoria = new Somatoria(mockMathOps);
    }

    @Test
    void testeVetor3_4() {

        when(mockMathOps.fatorial(3)).thenReturn(6);
        when(mockMathOps.fatorial(4)).thenReturn(24);

        int [] numeros = {3,4};
        int resultado = somatoria.somaDeFatoriais(numeros);
        assertEquals(30,resultado);
        verify(mockMathOps, times(1)).fatorial(3);
        verify(mockMathOps, times(1)).fatorial(4);
        verify(mockMathOps, times(2)).fatorial((anyInt()));
    }

    @Test
    void testeVetor0_1_2_3_4() {
        when(mockMathOps.fatorial(0)).thenReturn(1);
        when(mockMathOps.fatorial(1)).thenReturn(1);
        when(mockMathOps.fatorial(2)).thenReturn(2);
        when(mockMathOps.fatorial(3)).thenReturn(6);
        when(mockMathOps.fatorial(4)).thenReturn(24);


        int [] numeros = {0,1,2,3,4};
        int resultado = somatoria.somaDeFatoriais(numeros);
        assertEquals(34,resultado);
        verify(mockMathOps, times(1)).fatorial(0);
        verify(mockMathOps, times(1)).fatorial(1);
        verify(mockMathOps, times(1)).fatorial(2);
        verify(mockMathOps, times(1)).fatorial(3);
        verify(mockMathOps, times(1)).fatorial(4);
        verify(mockMathOps, times(5)).fatorial((anyInt()));
    }

}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MutanteTest {

    @Test
    void testeMutante1(){
        Original original = new Original();
        int[] vetor = {10,5};
        assertEquals(10, original.getMaior(vetor));

        Mutante1 mutante1 = new Mutante1();
        assertEquals(10, mutante1.getMaior(vetor));
    }

    @Test
    void testeMutante2(){
        Original original = new Original();
        int[] vetor = {1,10,5};
        assertEquals(10, original.getMaior(vetor));

        Mutante2 mutante2 = new Mutante2();
        assertEquals(10, mutante2.getMaior(vetor));
    }

    @Test
    void testeMutante3(){
        // Este mutante é equivalente!
    }


}
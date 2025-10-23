
public class Mutante3 {

    public int getMaior(int vetor[]) {
        int maior = vetor[0];
        for (int i = 0; i < vetor.length; i++) { // 1 por 0
            if(vetor[i] > maior)
                maior = vetor[i];
        }
        return maior;
    }
}

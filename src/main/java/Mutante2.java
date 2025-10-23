
public class Mutante2 {

    public int getMaior(int vetor[]) {
        int maior = vetor[0];
        for (int i = 2; i < vetor.length; i++) { // 1 por 2
            if(vetor[i] > maior)
                maior = vetor[i];
        }
        return maior;
    }
}

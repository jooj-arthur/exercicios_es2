
public class Mutante1 {
    public int getMaior(int vetor[]) {
        int maior = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if(vetor[i] != maior)  // maior por diferente
                maior = vetor[i];
        }
        return maior;
    }
}

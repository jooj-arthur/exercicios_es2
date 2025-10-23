public class Original {

    public int getMaior(int vetor[]) {
        int maior = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if(vetor[i] > maior)
                maior = vetor[i];
        }
        return maior;
    }
}

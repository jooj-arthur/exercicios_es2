public class Calculadora {
    /**
     * @param vetor
     * @param inicioInterv deve ser >= 0 e menor que fimInterv
     * @param fimInterv deve ser >= 0 e maior que inicioInterv
     * @return (i) media dos inteiros do vetor que estão no intervalo [inicioInterv, fimInterv]
     * (ii) -1 se os parametros forem invalidos
     */
    public float calcularMedia(int vetor[], int inicioInterv, int fimInterv) {
        if (/*1*/inicioInterv < 0 || /*2*/fimInterv < 0)
            /*3*/return -1;

        if (/*4*/inicioInterv >= fimInterv)
            /*5*/return -1;

        /*6*/float soma = 0, n = 0;
        for (/*6*/int i = 0;/*7*/ i < vetor.length;/*8*/ i++) {
            if(/*9*/vetor[i] >= inicioInterv && /*10*/vetor[i] <= fimInterv) {
                /*11*/soma = soma + vetor[i];
                /*11*/n++;
            }
        }
        /*12*/return soma/n;
    }
}
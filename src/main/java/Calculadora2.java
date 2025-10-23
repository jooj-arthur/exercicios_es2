public class Calculadora2 {
    /**
     * @param n - inteiro
     * @param valorMaximo - valor maximo que pode ter o somatorio
     * @return - o somatorio de 0 ate |n|, caso somatorio seja <= valorMaximo
     * @throws Exception - caso o somatorio seja > valorMaximo
     */
    public int somatoriaLimitada(int n, int valorMaximo) throws Exception {
        int resultado = 0, i = 0; /*1*/
        if(/*1*/n < 0) {
            /*2*/ n = -n;
        }

        while(/*3*/i<=n && /*4*/resultado <= valorMaximo) {
            /*5*/resultado = resultado + i;
            /*5*/i++;
        }

        if(/*6*/resultado > valorMaximo)
            /*7*/throw new Exception("valor maximo foi ultrapassado");
        else
            /*8*/return resultado;
    }
}
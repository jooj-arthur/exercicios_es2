public class PessoaDao {

    private RHService rhService;
    public PessoaDao(RHService rhService){
        this.rhService = rhService;
    }

    public boolean existePessoa(String nome){
        /*1*/var pessoas = rhService.getAllPessoas();
        /*2*/for (Pessoa pessoa: pessoas){
            /*3*/if (pessoa.nome().equals(nome)){
                /*4*/return true;
            }
        }
        /*5*/return false;
    }
}

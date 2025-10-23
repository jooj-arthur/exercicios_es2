public class Emissario {
    private UsuarioDAO usuarioDAO;
    private ServidorDeEmail servidorEmail;
    private Criptografia criptografia;

    public Emissario(UsuarioDAO usuarioDAO, ServidorDeEmail servidorEmail) {
        this.usuarioDAO = usuarioDAO;
        this.servidorEmail = servidorEmail;
    }
    public void setCriptografia(Criptografia criptografia) {
        this.criptografia = criptografia;
    }
    public String enviarPara(ArrayList<String> nomes) {
        if(/*1*/nomes == null)
            /*2*/return "nomes nao informados";

        /*3*/ArrayList<Usuario> usuarios = usuarioDAO.getAllUsuarios();
        if(/*3*/usuarios == null || /*4*/usuarios.size() == 0)
            /*5*/return "nao ha usuarios";

        /*6*/boolean msgsEnviadas = false;
        for(/*7*/String nome : nomes) {
            for (/*8*/Usuario usuario : usuarios) {
                if(/*9*/usuario.getNome().equals(nome)) {
                    /*10*/String mensagem = criptografia.criptografar("mensagem secreta");
                    /*10*/boolean foiEnviado = servidorEmail.enviar("TO: " + usuario.getEmail() +
                            " " + mensagem);
                    if(/*10*/foiEnviado) {
                        /*11*/msgsEnviadas = true;
                        /*11*/break;
                    }
                     else
                        /*12*/return "servidor de email offline";
                }
            }
        }

        if(/*13*/msgsEnviadas)
            /*14*/return "mensagens enviadas";
        else /*15*/
            /*15*/return "usuarios nao encontrados";
    }
}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PessoaDaoTest {

    PessoaDao pessoaDao;
    RHService rhServiceMock;

    @BeforeEach // test fixture
    void beforeEach(){
        // moggar as dependencias
        rhServiceMock = mock(RHService.class);
        // simular o comportamento
        var pessoa = List.of(
                new Pessoa(1,20,"Andre"),
                new Pessoa(2,30,"Juarez"),
                new Pessoa(3,40,"Juan"),
                new Pessoa(4,50,"Joana")
        );
        when(rhServiceMock.getAllPessoas()).thenReturn(pessoa);

        // cria o objeto sob teste
        pessoaDao = new PessoaDao(rhServiceMock);
    }

    @Test
    void testeExistePessoa() {
        var resultado = pessoaDao.existePessoa("Joana");
        assertTrue(resultado);
        // verificar se algum metodo do mock foi chamado
        verify(rhServiceMock, times(1)).getAllPessoas();
    }

    @Test
    void testeNaoExistePessoa() {
        var resultado = pessoaDao.existePessoa("Pedro");
        assertFalse(resultado);
        // verificar se algum metodo do mock foi chamado
        verify(rhServiceMock, times(1)).getAllPessoas();
    }
}
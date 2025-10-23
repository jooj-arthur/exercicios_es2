import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RelatorioDeFuncionariosTest {

    FuncionarioDAO mockFuncionarioDAO;
    ReceitaFederal mockRf;

    RelatorioDeFuncionarios relatorio;


    @BeforeEach
    void setup(){
        mockFuncionarioDAO = mock(FuncionarioDAO.class);
        mockRf = mock(ReceitaFederal.class);
        relatorio = new RelatorioDeFuncionarios(mockFuncionarioDAO);
        relatorio.setRf(mockRf);
    }

    @Test
    void teste2TecnicosComCPFNaoBloqueado() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Funcionario f1 = new Funcionario(); f1.setCpf("111111111-11");
        Funcionario f2 = new Funcionario(); f2.setCpf("222222222-22");
        funcionarios.add(f1);
        funcionarios.add(f2);

        when(mockFuncionarioDAO.getFuncionariosBy("tecnico")).thenReturn(funcionarios);
        when(mockRf.isCPFBloqueado("111111111-11")).thenReturn(false);
        when(mockRf.isCPFBloqueado("222222222-22")).thenReturn(false);

        int resultado = relatorio.getFuncComCPFBloqueado("tecnico");

        assertEquals(0,resultado);

        verify(mockFuncionarioDAO, times(1)).getFuncionariosBy("tecnico");
        verify(mockRf, times(1)).isCPFBloqueado("111111111-11");
        verify(mockRf, times(1)).isCPFBloqueado("222222222-22");
    }

    @Test
    void teste1AnalistaComCPFBloqueado() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Funcionario f1 = new Funcionario(); f1.setCpf("333333333-33");
        funcionarios.add(f1);

        when(mockFuncionarioDAO.getFuncionariosBy("analista")).thenReturn(funcionarios);
        when(mockRf.isCPFBloqueado("333333333-33")).thenReturn(true);

        int resultado = relatorio.getFuncComCPFBloqueado("analista");

        assertEquals(1,resultado);

        verify(mockFuncionarioDAO, times(1)).getFuncionariosBy("analista");
        verify(mockRf, times(1)).isCPFBloqueado("333333333-33");
    }

    @Test
    void teste4Gerentes2ComCPFBloqueado() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Funcionario f1 = new Funcionario(); f1.setCpf("123456789-00");
        Funcionario f2 = new Funcionario(); f2.setCpf("111222333-44");
        Funcionario f3 = new Funcionario(); f3.setCpf("654321987-23");
        Funcionario f4 = new Funcionario(); f4.setCpf("098876654-99");
        funcionarios.add(f1);
        funcionarios.add(f2);
        funcionarios.add(f3);
        funcionarios.add(f4);

        when(mockFuncionarioDAO.getFuncionariosBy("gerente")).thenReturn(funcionarios);
        when(mockRf.isCPFBloqueado("123456789-00")).thenReturn(false);
        when(mockRf.isCPFBloqueado("111222333-44")).thenReturn(true);
        when(mockRf.isCPFBloqueado("654321987-23")).thenReturn(false);
        when(mockRf.isCPFBloqueado("098876654-99")).thenReturn(true);

        int resultado = relatorio.getFuncComCPFBloqueado("gerente");

        assertEquals(2,resultado);

        verify(mockFuncionarioDAO, times(1)).getFuncionariosBy("gerente");
        verify(mockRf, times(1)).isCPFBloqueado("123456789-00");
        verify(mockRf, times(1)).isCPFBloqueado("111222333-44");
        verify(mockRf, times(1)).isCPFBloqueado("654321987-23");
        verify(mockRf, times(1)).isCPFBloqueado("098876654-99");

    }

}
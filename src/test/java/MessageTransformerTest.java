import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MessageTransformerTest {
    Logger loggerMock;
    Helper helperMock;
    MessageTransformer transformer;
    @BeforeEach
    void setUp(){
        loggerMock =  mock(Logger.class);
        helperMock = mock(Helper.class);
        transformer = new MessageTransformer(loggerMock,helperMock);

        String [] censoredWords = {"abobora","BBB","guarana"};
        when(helperMock.getCensoredWords()).thenReturn(censoredWords);
    }

    @Test
    void contemDuasPalavrasCensuradas() {
        when(loggerMock.logTransformation(anyString(),anyString())).thenReturn(true);
        var res = transformer.transform("Ontem eu vi BBB, alguém tomava guarana e gritava BBB!!!");
        assertEquals("Ontem eu vi ???, alguém tomava ??? e gritava ???!!!", res);
    }

    @Test
    void lancarExcecaoConexao() {
        when(loggerMock.logTransformation(anyString(),anyString())).thenReturn(false);
        assertThrows(RuntimeException.class, () -> transformer.transform("Eu vi BBB!!!"));
    }
    @ParameterizedTest
    @CsvSource({
            "'Ontem eu vi BBB, alguém tomava guarana e gritava BBB!!!','Ontem eu vi ???, alguém tomava ??? e gritava ???!!!'",
            "'ola pessoal','ola pessoal'",
            "'hoje tem abobora com camarao','hoje tem ??? com camarao'"
    })
    void testTransformMessageSuccessfully(String inputMessage, String expectedMessage){
    when(loggerMock.logTransformation(anyString(),anyString())).thenReturn(true);
    var res = transformer.transform(inputMessage);
    assertEquals(expectedMessage, res);

    }
}
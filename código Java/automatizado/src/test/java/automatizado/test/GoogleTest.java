package automatizado.test;

import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import automatizado.page.GooglePO;

public class GoogleTest extends BaseTest {

    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://www.google.com.br/");
        googlePage = new GooglePO(driver);
    }
    

    /**
     * Método de teste para pesquisar no campo de pesquisa do google "batata frita", então
     * após abrir a página de termos buscados encontrar a palavra "Aproximadamente" 
     *  */ 

    @Test
    public void TC001_deveSerPossivelPesquisarGoogleNoGoogleOTextoBatataFrita(){

        /* Encontra um campo de pesquisa da página que contém o identificador name 'q' */
        /* Escrevendo "batata frita" no campo de pesquisa da página e dando Enter*/
        googlePage.pesquisar("batata frita");

        /* Encontra um campo que usa o identificador id 'result-stats' e recebe o valor dele*/
        String resultado = googlePage.obterResultadoDaPesquisa();
        
        /* Verificar se resultado contém o termo "Aproximadamente*/
        assertTrue(resultado, resultado.contains("Aproximadamente"));

    }

    /**
     * Método de teste para pesquisar no campo de pesquisa do google "nutella", então
     * após abrir a página de termos buscados encontrar a palavra "Aproximadamente" 
     *  */ 
    @Test
    public void TC002_deveSerPossivelPesquisarGoogleNoGoogleOTextoNutella(){

        /* Encontra um campo de pesquisa da página que contém o identificador name 'q' */
        /* Escrevendo "nutella" no campo de pesquisa da página e dando Enter*/
        googlePage.pesquisar("nutella");

        /* Encontra um campo que usa o identificador id 'result-stats' e recebe o valor dele*/
        String resultado = googlePage.obterResultadoDaPesquisa();
        
        /* Verificar se resultado contém o termo "Aproximadamente*/
        assertTrue(resultado, resultado.contains("Aproximadamente"));

    }

}


package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest{
    
    private static LoginPO loginPage;
    
    /* Instanciando loginPage */
    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }
    

    @Test
    public void TC001_naoDeveLogarNoSitemaComEmailESenhaVazios(){

        loginPage.executarAcaoDeLogar("", "");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");

    }

    
    @Test
    public void TC002_naoDeveLogarNoSitemaComEmailIncorretoESenhaVazio(){

        loginPage.executarAcaoDeLogar("teste", "");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");

    }


    @Test
    public void TC003_naoDeveLogarNoSitemaComEmailVazioESenhaIncorreta(){

        loginPage.executarAcaoDeLogar("", "teste");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");

    }


    @Test
    public void TC004_naoDeveLogarNoSitemaComEmailESenhaIncorretos(){

        loginPage.executarAcaoDeLogar("teste", "teste");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem,"E-mail ou senha inválidos");

    }

    @Test
    public void TC005_naoDeveLogarNoSitemaComEmailESenhaIncorretos(){

        loginPage.executarAcaoDeLogar("admin@admin.com", "teste");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem,"E-mail ou senha inválidos");

    }

    
    @Test
    public void TC006_naoDeveLogarNoSitemaComEmailIncorretoESenhaCorreta(){

        loginPage.executarAcaoDeLogar("Aadmin@admin.com", "admin@123");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem,"E-mail ou senha inválidos");

    }

    @Test
    public void TC007_deveLogarNoSitemaComEmailESenhaCorretos(){

        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        String tituloPagina = loginPage.obterTituloPagina();

        assertEquals(tituloPagina,"Controle de Produtos");

    }
}

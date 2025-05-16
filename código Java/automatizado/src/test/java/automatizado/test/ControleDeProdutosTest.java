package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutosTest extends BaseTest {
    
    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleProdutoPage;
    
    /* Instanciando produtoPage */
    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);

        /* Logar na página de login */
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controleProdutoPage = new ControleDeProdutoPO(driver);
            
        /* Verificar se entrou na página de "Controle de Produtos" após fazer login */
        assertEquals(controleProdutoPage.obterTituloPagina(),"Controle de Produtos");

    }


    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        controleProdutoPage.buttonAdicionar.click();
        // TODO: remover esse clique após o sistema ser corrigido.
        controleProdutoPage.buttonAdicionar.click();   
        String titulo = controleProdutoPage.tituloModal.getText();

        /* Verifica se a janela ou modal abriu */
        assertEquals("Produto", titulo);

        controleProdutoPage.buttonSair.click();
        // TODO: remover esse clique após o sistema ser corrigido.
        controleProdutoPage.buttonSair.click();

    }



    @Test
    public void TC002_naoDeveSerPossivelCadastrarProdutoSemPreencherTodosOsCampos(){
        controleProdutoPage.buttonAdicionar.click();
 
        controleProdutoPage.cadastrarProduto("0001","martelo", 10, 59.90, "");

        /* Capturar a mensagem de erro */
        String mensagem = controleProdutoPage.spanMensagem.getText();

        assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
        
        controleProdutoPage.buttonSair.click();

    }



    @Test
    public void TC003_naoDeveSerPossivelCadastrarProdutoSemPreencherTodosOsCampos(){
       
        String mensagem = "Todos os campos são obrigatórios para o cadastro!";

        controleProdutoPage.buttonAdicionar.click();

        //Aqui cria o Objeto para adicionar na tela
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

        //Aqui estamos testando se o produto é adicionado sem preencher o campo de código
        produtoBuilder
        .adicionarCodigo("")
        .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        
        //Aqui estamos testando se o produto é adicionado sem preencher o campo de quantidade
        produtoBuilder
        .adicionarCodigo("00005")
        .adicionarQuantidade(null)
        .builder();

        mensagem = controleProdutoPage.spanMensagem.getText();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

       
        //Aqui estamos testando se o produto é adicionado sem preencher o campo de nome
        produtoBuilder
        .adicionarQuantidade(15)
        .adicionarNome("")
        .builder();

        mensagem = controleProdutoPage.spanMensagem.getText();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());


        //Aqui estamos testando se o produto é adicionado sem preencher o campo valor
        produtoBuilder
        .adicionarNome("Cimento")
        .adicionarValor(null)
        .builder();
 
        mensagem = controleProdutoPage.spanMensagem.getText();
 
        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());
         
    
        //Aqui estamos testando se o produto é adicionado sem preencher o campo data
         produtoBuilder
         .adicionarValor(50.0)
         .adicionarData("")
         .builder();
  
        mensagem = controleProdutoPage.spanMensagem.getText();
  
        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());
                  
        controleProdutoPage.buttonSair.click();

    }
}

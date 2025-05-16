package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automatizado.builder.ProdutoBuilder;

public class ControleDeProdutoPO extends BasePO{

    /*Criar um WebElement para capturar botão com 'id' igual a 'btn-adicionar' */
    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdicionar;


    /*Criar um WebElement para capturar elemento com 'classe' igual a 'ul>li>a.nav-link' */
    @FindBy(css = "ul>li>a.nav-link")
    public WebElement linkVoltar;

    /*Criar um WebElement para capturar elemento com 'classe' igual a div.modal-header>h4' */
    @FindBy(css = "div.modal-header>h4")
    public WebElement tituloModal;

    /*Criar um WebElement para capturar elemento com 'id' igual a 'codigo' */
    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    /*Criar um WebElement para capturar elemento com 'id' igual a 'nome' */
    @FindBy(id = "nome")
    public WebElement inputNome;

    /*Criar um WebElement para capturar elemento com 'id' igual a 'quantidade' */
    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    /*Criar um WebElement para capturar elemento com 'id' igual a 'valor' */
    @FindBy(id = "valor")
    public WebElement inputValor;

    /*Criar um WebElement para capturar elemento com 'id' igual a 'data' */
    @FindBy(id = "data")
    public WebElement inputData;

    /*Criar um WebElement para capturar elemento com 'id' igual a 'btn-salvar' */
    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    /*Criar um WebElement para capturar elemento com 'id' igual a 'btn-sair' */
    @FindBy(id = "btn-sair")
    public WebElement buttonSair;
        
    /*Criar um WebElement para capturar elemento com 'id' igual a 'mensagem' */
    @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }

    public void cadastrarProduto(
        String codigo, 
        String nome, 
        Integer quantidade, 
        Double valor, 
        String data){

            escrever(inputCodigo, codigo);
            escrever(inputNome, nome);
            escrever(inputQuantidade, quantidade.toString());
            escrever(inputValor, valor.toString());
            escrever(inputData, data); 

            buttonSalvar.click();

    }

/* 
    public void cadastrarProduto(ProdutoBuilder produtoBuilder){

        produtoBuilder.builder();
    }
    
   */ 
}

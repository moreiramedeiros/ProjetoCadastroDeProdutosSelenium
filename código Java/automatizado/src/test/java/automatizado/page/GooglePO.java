package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

    /*Criar um WebElement para capturar elementos com 'name' igual a 'q' */
    @FindBy(name = "q")
    public WebElement inputPesquisa;

    /*Criar um WebElement para capturar elementos de 'id' igual a "result-stats" */
    @FindBy(id = "result-stats")
    public WebElement divResultadoPesquisado;

    
    /**
     * Construtor para a crição da página do google
     * @param driver Driver da página do google
     */
    public GooglePO(WebDriver driver) {
        super(driver);
    }

    /**
     * Método que fará pesquisa no google baseando no texto informado e
     * concluindo com Enter
     * @param texto Texto a ser pesquisado
     */
    public void pesquisar(String texto){
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    /** 
     * Método que retorna o resultado "Aproximado" da pesquisa
     * @return Retorna o resultado da pesquisa
     */
    public String obterResultadoDaPesquisa(){
       return divResultadoPesquisado.getText();
    }

}

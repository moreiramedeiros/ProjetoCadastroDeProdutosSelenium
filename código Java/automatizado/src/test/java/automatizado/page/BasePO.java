package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação da novas pagesObjects.
 * Todas as pages devem ser herdadas nesta classes
 */

public abstract class BasePO {

    /** Driver base que será usado pelas pages */
    protected WebDriver driver;

    /**
     * Construtor base da criação da fábrica de elementos (PageFactory).
     * @param driver Driver da página atual
     */
    protected BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Método que retorna o título da página atual
     * @return Título da página atual
     */
    public String obterTituloPagina(){
        return driver.getTitle();
    }

    /**
     * Método que sabe escrever em qualquer WebElement do tipo input e da um TAB ao final
     * @param input Input a qual será escrito
     * @param texto Texto que será escrito no input
     */
    public void escrever(WebElement input, String texto){
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }
}

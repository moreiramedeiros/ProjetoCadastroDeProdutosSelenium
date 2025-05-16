package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    //#region Região dos WebElements
    /*Criar um WebElement para capturar campo com 'id' igual a 'email' */
    @FindBy(id = "email")
    public WebElement inputEmail;

    /*Criar um WebElement para capturar campo  com 'id' igual a 'senha' */
    @FindBy(id = "senha")
    public WebElement inputSenha;

     /*Criar um WebElement para capturar botão  com 'id' igual a 'btn-entrar' */
    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

     /*Criar um WebElement para capturar mensagem de alerta dentro um formulário */
     @FindBy(css = "form.form-login>div.alert>span")
     public WebElement spanMensagem;
    //#endregion Região dos WebElements

    //#region Região do construtor
    /**
     * Construtor padrão para criação de uma nova instancia da página de Login.
     * @param driver Driver da página login.
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }
    //#endregion Região do construtor

    //#region Região dos métodos
    /**
     * Método que obtem mensagem disparada na tela
     * @return Texto da mensagem
     */
    public String obterMensagem(){
        return this.spanMensagem.getText();
    }
    
    /**
     * Método que tenta executar a ação de logar no sistema
     * @param email Email para tentativa de logim 
     * @param senha Email para tentativa de senha
     */
    public void executarAcaoDeLogar(String email, String senha){
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        buttonEntrar.click();
    }
    //#endregion Região dos métodos

}

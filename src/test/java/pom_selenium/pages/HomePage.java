import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    String EMAIL = "//input[@id='inputEmail']";  //nome em maiusculo significa que é uma variavel q não vai sofrer alteração, por isso deixamos em maisculo
    String NOME = "//input[@id='inputName']";
    String SENHA = "//input[@id='inputPassword']";
    String CONFIRM_SENHA = "//input[@id='inputPasswordConfirmation']";
    String CRIAR_SALDO = "//input[@id='toggleAddBalance']";
    String CADASTRAR = "//input[@id='btnRegister']";

    public HomePage(WebDriver driverParametro){
        this.driver = driverParametro;
    }
    
    public void preencherEmail(){
        driver.findElement(By.xpath(EMAIL)).sendKeys("teste@gmail.com");
    }

    public void preencherNome(){
        driver.findElement(By.xpath(NOME)).sendKeys("Teste Qa");
    }

    public void preencherSenha(){
        driver.findElement(By.xpath(SENHA)).sendKeys("teste");
    }

    public void preencherConfirmaSenha(){
        driver.findElement(By.xpath(CONFIRM_SENHA)).sendKeys("teste");;
    }
    
    public void clicarCriarComSaldo(){
        driver.findElement(By.xpath(CRIAR_SALDO)).click();
    }

    public void clicarCadastrar(){
        driver.findElement(By.xpath(CADASTRAR)).click();
    }

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastramento {
    WebDriver driver;
    HomePage homePage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://localhost:3000/");

    }    

    @Test
    public void testePositivoCadastro(){
        homePage.clicarCadastrar();
        homePage.preencherEmail("teste@gmail.com");
        homePage.preencherNome("Teste Qa");
        homePage.preencherSenha("teste");
        homePage.preencherConfirmaSenha("teste");
        homePage.clicarCriarComSaldo();
        homePage.clicarCadastrar();
        validarMsgNaTela("foi criada com sucesso");

    }

    @Test
    public void testeCadastroVazio(){
        homePage.clicarCadastrar();
        homePage.clicarCadastrar();
        validarMsgNaTela("Nome não pode ser vazio");

    }

    @After
    public void finalizar(){
        Thread.sleep(5000);
        driver.quit();
    }

    public void validarMsgNaTela (String msg){
        Assert.assertTrue(driver.getPageSource().contains(msg));
    }

}

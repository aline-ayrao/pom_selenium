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
        homePage.preencherEmail();
        homePage.preencherNome();
        homePage.preencherSenha();
        homePage.preencherConfirmaSenha();
        homePage.clicarCriarComSaldo();
        homePage.clicarCadastrar();
        Assert.assertTrue(driver.getPageSource().contains("foi criada com sucesso"));

    }

    @After
    public void finalizar(){
        Thread.sleep(5000);
        driver.quit();
    }

}

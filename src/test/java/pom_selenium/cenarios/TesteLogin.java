import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginpage;
    String email = "teste@gmail.com";
    String senha = "teste";

    @Before
    public void setup(){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginpage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://localhost:3000/");
        cadastrarUsuario();
    }    

    @Test
    public void testeLoginComSucesso(){
        loginpage.preencherEmail(email);
        loginpage.preencherSenha(senha);
        loginpage.clicarAcessar();
        validarMsgNaTela("bem vindo ao BugBank");
        validarUrl("/home");
    }
    public void validarUrl (String pagina){
        Assert.assertTrue(driver.getCurrentUrl().contains(pagina));
    }

    @After
    public void finalizar(){
        Thread.sleep(5000);
        driver.quit();
    }

    public void validarMsgNaTela (String msg){
        Assert.assertTrue(driver.getPageSource().contains(msg));
    }

    public void cadastrarUsuario (){
        homePage.clicarCadastrar();
        homePage.preencherEmail("teste@gmail.com");
        homePage.preencherNome("Teste Qa");
        homePage.preencherSenha("teste");
        homePage.preencherConfirmaSenha("teste");
        homePage.clicarCriarComSaldo();
        homePage.clicarCadastrar();
        validarMsgNaTela("foi criada com sucesso");
        homePage.clicarFechar();

    }

}

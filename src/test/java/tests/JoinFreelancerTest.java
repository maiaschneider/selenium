package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import pages.HomePage;
import pages.JoinFreelancerPage;

public class JoinFreelancerTest {
	private String PATHDRIVER = "C:\\CursoSelenium\\com.tutorialselenium.pom\\src\\test\\resources\\drivers/";
    private String baseURL = "https://www.toptal.com/";
    WebDriver driver;
    
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver",PATHDRIVER+"chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
       // configureSelenide();
    }
    @Test
    public void signUp(){
        driver.get(baseURL);
        //Crear objeto de la clase Page
        HomePage homePage = new HomePage(driver);
      //Crear objeto de la clase JoinFreelancerPage
        JoinFreelancerPage joinFreelancer = new JoinFreelancerPage(driver);
        //Hacemos clic en el enlace "Apply as a Freelancer"
        homePage.clickLinkApplyFreelancer();
        //Verificamos que la página "Apply as a Freelancer" se haya abierto
        Assert.assertTrue(joinFreelancer.isPageOpened("Apply to Join our Network of"));
        //Llenamos el formulario usando el metodo que creamos en JoinFreelancerPage
        joinFreelancer.fillFormJoin("finance_experts","Tutorial Selenium","admin@tutorialselenium.com","tutorialselenium");
        //Comprobamos si se creó la cuenta exitosamente verificando que estamos en la url "Confirm Your Email"
        //Assert.assertTrue(driver.getCurrentUrl().contains("https://www.toptal.com/talent/check_confirmation"));
         
    }
  /* 
	private void configureSelenide() {
		System.setProperty("selenide.browser", "Chrome");
		WebDriverRunner.setWebDriver(driver);// Selenide is going to use the selenium webdriver
		Configuration.timeout = 15000; // timeout in milliseconds that Selenide
										// methods are going to use to wait for
										// elements on the UI
		Configuration.screenshots = false; // Disable Selenide screenshots
	}
	
    @AfterTest
    public void close(){
        driver.close();
    }
*/
}

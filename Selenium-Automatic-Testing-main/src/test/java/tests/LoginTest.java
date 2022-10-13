package tests;

import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium_jars_drivers\\" +
                "drivers\\chrome_drivers\\chromedriver.exe");
        return new ChromeDriver();
    }

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }

    @Test//T1
    public void canNotLoginWithInvalidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("fhari851@gmail.com", "wrong_password_test");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "Le mot de passe entré est incorrect. Vous l’avez oublié ?");

    }
    @Test//T2
    public void canNotLoginWithoutUserName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("", "");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "L’adresse e-mail ou le numéro de mobile que vous avez saisi(e) n’est pas associé(e) à un compte. Trouvez votre compte et connectez-vous.");

    }

    @Test//T3
    public void shouldLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("fhari851@gmail.com", "SaliSali123");
        assertTrue(new HomePage(driver).isLoaded());
    }



    @AfterTest
    public void teardown() {
        driver.quit();
    }
}

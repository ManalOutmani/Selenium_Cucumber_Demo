package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(1200);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("a8c37x1j")));
    }
}

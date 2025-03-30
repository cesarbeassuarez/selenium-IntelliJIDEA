package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    // Locators (identificadores de los elementos de la página)
    private By usernameField = By.id("StartSharp_Membership_LoginPanel0_Username");
    private By passwordField = By.id("StartSharp_Membership_LoginPanel0_Password");
    private By loginButton   = By.id("StartSharp_Membership_LoginPanel0_LoginButton");
    private By errorMessage  = By.cssSelector(".validation-summary-errors li");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Acciones sobre la página
    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String obtenerMensajeError() {
        WebElement mensaje = driver.findElement(errorMessage);
        return mensaje.getText();
    }
}

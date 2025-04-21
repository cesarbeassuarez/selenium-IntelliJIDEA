package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import io.qameta.allure.Step;
import utils.DriverManager;


public class LoginPage {
    DriverManager driverManager;

    // Locators (identificadores de los elementos de la página)
    private By usernameField = By.cssSelector("div.field.Username input[name='Username']");
    private By passwordField = By.cssSelector("div.field.Password input[name='Password']");
    private By loginButton = By.cssSelector("button[type='submit'].btn.btn-primary");
    private By errorMessage = By.cssSelector(".toast-message");
    //private By sad = By.cssSelector("input[id='s2id_autogen3']");

    // Constructor
    public LoginPage(DriverManager driverManager) {
        this.driver = driverManager;
    }
 
    // Acciones sobre la página
    @Step("Ingresar usuario: {username}")
    public void enterUsername(String username) {
        driverManager.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    @Step("Ingresar contraseña")
    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Hacer clic en el botón de Login")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    @Step("Obtener mensaje de error de login")
    public String obtenerMensajeError() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return mensaje.getText();
    }
}

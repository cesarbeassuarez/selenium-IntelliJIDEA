package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import utils.DriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    // 🧭 Selectores (locators) de la página de login
    private final By usernameField = By.cssSelector("div.field.Username input[name='Usernames']");
    private final By passwordField = By.cssSelector("div.field.Password input[name='Password']");
    private final By loginButton = By.cssSelector("button[type='submit'].btn.btn-primary");
    private final By errorMessage = By.cssSelector(".toast-message");

    // ✅ Constructor sin WebDriver: usamos DriverManager.getDriver() internamente
    public LoginPage() {}

    // 📥 Ingresar usuario
    @Step("Ingresar usuario: {username}")
    public void enterUsername(String username) {
        WebElement usernameInput = DriverManager.findElement(usernameField);
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    // 🔒 Ingresar contraseña
    @Step("Ingresar contraseña")
    public void enterPassword(String password) {
        WebElement passwordInput = DriverManager.findElement(passwordField);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    // 🖱️ Hacer clic en botón de login
    @Step("Hacer clic en el botón de Login")
    public void clickLogin() {
        DriverManager.findElement(loginButton).click();
    }

    // ⚠️ Obtener mensaje de error si login falla
    @Step("Obtener mensaje de error de login")
    public String obtenerMensajeError() {
        // Acá sí usamos WebDriverWait si queremos esperar un mensaje que aparece después de un evento
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        WebElement mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return mensaje.getText();
    }
}

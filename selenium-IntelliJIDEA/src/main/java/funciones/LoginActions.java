package funciones;

import config.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.DashBoardPage;
import org.testng.annotations.Test;
import org.testng.Assert;

import utils.CommonActions;
import io.qameta.allure.Step;

import java.time.Duration;


public class LoginActions {
    WebDriver driver;
    LoginPage loginPage;
    DashBoardPage dashBoardPage;

    public LoginActions(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.dashBoardPage = new DashBoardPage(driver);
    }

    // Login usando credenciales desde config.properties
    @Step("Login con credenciales por defecto")
    public void loginConCredencialesPorDefecto() {
        String username = PropertiesReader.getProperty("login.username");
        String password = PropertiesReader.getProperty("login.password");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    // Login con parámetros si querés hacerlo dinámico también
    @Step("Ingresar credenciales: usuario = {0}, clave = {1}")
    public void ingresarCredenciales(String usuario, String clave) {
        loginPage.enterUsername(usuario);
        loginPage.enterPassword(clave);
        loginPage.clickLogin();
    }

    @Step("Verificar que el Dashboard está visible")
    public void verificarDashboardVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(10000);
        wait.until(webDriver -> {
            try{
                driver.findElement(new By.ByCssSelector("sds"));
                return true;
            }
            catch(Exception e) {
                return false;
            }
        });
        driver.findElement(new By.ByCssSelector("sds")).click();

        boolean redirigido = wait.until(ExpectedConditions.urlContains("Dashboard"));
        Assert.assertTrue(redirigido, "No se redirigió al Dashboard correctamente");
    }

    @Step("Verificar mensaje de error: se espera '{0}'")
    public void verificarMensajeError(String mensajeEsperado) {
        String mensajeReal = loginPage.obtenerMensajeError();

        // Captura tradicional (guarda en disco)
        CommonActions.capturarPantalla(driver, "login_error");

        // Captura para reporte Allure (incrustado en el HTML)
        CommonActions.capturarPantallaAllure(driver);

        System.out.println("Mensaje recibido: " + mensajeReal);
        Assert.assertEquals(mensajeReal.trim(), mensajeEsperado.trim(), "El mensaje de error no coincide");
    }

    @Step("Realizar logout")
    public void realizarLogout() {
        dashBoardPage.hacerLogout();
    }
}

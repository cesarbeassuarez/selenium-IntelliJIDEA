package funciones;

import config.PropertiesReader;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import pages.DashBoardPage;
import org.testng.annotations.Test;
import org.testng.Assert;

import utils.CommonActions;
import io.qameta.allure.Step;


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
        String username = PropertiesReader.get("login.username");
        String password = PropertiesReader.get("login.password");

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
        Assert.assertTrue(driver.getCurrentUrl().contains("Dashboard"), "No se redirigió al Dashboard correctamente");
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

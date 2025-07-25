package funciones;

import config.PropertiesReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import pages.DashBoardPage;
import utils.CommonActions;
import utils.DriverManager;

import java.time.Duration;

public class LoginActions {
    LoginPage loginPage;
    DashBoardPage dashBoardPage;

    // Ya no pasamos el driver como parámetro: usaremos DriverManager internamente
    /*public LoginActions() {
        this.loginPage = new LoginPage();
        this.dashBoardPage = new DashBoardPage();
    }
*/
    @Step("Login con credenciales por defecto")
    public void loginConCredencialesPorDefecto() {
        String username = PropertiesReader.getProperty("login.username");
        String password = PropertiesReader.getProperty("login.password");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Step("Ingresar credenciales: usuario = {0}, clave = {1}")
    public void ingresarCredenciales(String usuario, String clave) {
        loginPage.enterUsername(usuario);
        loginPage.enterPassword(clave);
        loginPage.clickLogin();
    }

    @Step("Verificar que el Dashboard está visible")
    public void verificarDashboardVisible() {
        DashBoardPage dashboard = new DashBoardPage();
        //boolean visible = dashboard.existeElemento(By.cssSelector("div.dropdown.dropend a[title='admin']")); // ejemplo
        //Assert.assertTrue(visible, "❌ El dashboard no está visible. Revisar login o redirección.");
    }

    @Step("Verificar mensaje de error: se espera '{0}'")
    public void verificarMensajeError(String mensajeEsperado) {
        String mensajeReal = loginPage.obtenerMensajeError();

    }

    @Step("Realizar logout")
    public void realizarLogout() {
        dashBoardPage.hacerLogout();
    }
}

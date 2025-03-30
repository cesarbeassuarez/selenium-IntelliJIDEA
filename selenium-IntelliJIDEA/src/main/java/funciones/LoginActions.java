package funciones;

import config.PropertiesReader;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import org.testng.Assert;

public class LoginActions {
    WebDriver driver;
    LoginPage loginPage;

    public LoginActions(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    // Login usando credenciales desde config.properties
    public void loginConCredencialesPorDefecto() {
        String username = PropertiesReader.get("login.username");
        String password = PropertiesReader.get("login.password");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    // Login con parámetros si querés hacerlo dinámico también
    public void ingresarCredenciales(String usuario, String clave) {
        loginPage.enterUsername(usuario);
        loginPage.enterPassword(clave);
        loginPage.clickLogin();
    }

    public void verificarDashboardVisible() {
        Assert.assertTrue(driver.getCurrentUrl().contains("Dashboard"), "No se redirigió al Dashboard correctamente");
    }

    public void verificarMensajeError(String mensajeEsperado) {
        String mensaje = loginPage.obtenerMensajeError(); // Este método lo agregamos en LoginPage
        Assert.assertEquals(mensaje.trim(), mensajeEsperado.trim());
    }

    public void realizarLogout() {
        // Implementar más adelante si encontrás el botón de logout
    }
}

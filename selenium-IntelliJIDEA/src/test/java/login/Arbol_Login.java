package login;

import funciones.LoginActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import config.WebDriverManager;
import config.PropertiesReader;

public class Arbol_Login {
    WebDriver driver;
    LoginActions login;

    @BeforeClass
    public void setup() {
        driver = WebDriverManager.getDriver();
        String url = PropertiesReader.get("base.url");
        driver.get(url);
        login = new LoginActions(driver)
    }

    // 1 Login correcto
    @Test(priority = 1)
    public void LoginCorrecto_Admin(){
        login.ingresarCredenciales("admin","serenity");
        login.verificarDashboardVisible();
        login.realizarLogout();
    }

    // 2 Password incorrecto
    @Test(priority = 2)
    public void LoginPasswordIncorrecto(){
        login.ingresarCredenciales("admin", "clave_invalida");
        login.verificarMensajeError("Invalid username or password!");
    }

    // 3 Usuario incorrecto
    @Test(priority = 3)
    public void  LoginUsuarioIncorrecto(){
        login.ingresarCredenciales("usuario_falso", "serenity");
        login.verificarMensajeError("Invalid username or password!");
    }

    // 4 Ambos campos vacios
    @Test(priority = 4)
    public void LoginCamposVacios(){
        login.ingresarCredenciales("","");
        login.verificarMensajeError("Invalid username or password!");
    }

    // 5 Solo usuario cargado
    @Test(priority = 5)
    public void LoginSoloUsuario(){
        login.ingresarCredenciales("admin","");
        login.verificarMensajeError("Invalid username or password!");
    }

    // 6 Solo contraseña cargada
    @Test(priority = 6)
    public void LoginSoloPassword(){
        login.ingresarCredenciales("","serenity");
        login.verificarMensajeError("Invalid username or password!");
    }

    // 7 Validar visibilidad de campos
    @Test(priority = 7)
    public void ValidarVisibilidadCamposLogin(){
        login.verificarVisibilidadCamposLogin();
    }

    // 8️⃣ Validar que el campo contraseña esté oculto
    @Test(priority = 8)
    public void TC_ValidarCampoPasswordEsOculto() {
        login.validarCampoPasswordEsOculto();
    }

    // 9️⃣ Validar link "¿Olvidaste tu contraseña?"
    @Test(priority = 9)
    public void TC_ValidarOlvidasteTuContrasena() {
        login.validarLinkOlvidasteContrasena();
    }

    // 🔟 Validar link "Registrarse"
    @Test(priority = 10)
    public void TC_ValidarRegistrarse() {
        login.validarLinkRegistrarse();
    }

    // 🔟+1 Validar botones sociales
    @Test(priority = 11)
    public void TC_ValidarBotonesSociales() {
        login.validarBotonesSociales();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }



}


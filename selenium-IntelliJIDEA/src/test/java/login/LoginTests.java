package login;

import funciones.LoginActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import config.WebDriverManager;
import config.PropertiesReader;
import io.qameta.allure.*;

@Epic("Login")
@Feature("Validaciones del formulario de inicio de sesión")
public class LoginTests {
    WebDriver driver;
    LoginActions login;

    // Test data
    String url;
    String username;
    String password;

    @BeforeClass
    public void setup() {
        driver = WebDriverManager.getDriver();

        // Asignar a las variables de clase
        url = PropertiesReader.get("base.url");
        username = PropertiesReader.get("login.username");
        password = PropertiesReader.get("login.password");

        driver.get(url);
        login = new LoginActions(driver);
    }

    // 1 Login correcto
    @Test(priority = 1)
    @Story("Inicio de sesión exitoso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifica que el usuario admin pueda iniciar sesión con credenciales válidas")
    public void LoginCorrecto_Admin(){
        login.ingresarCredenciales(username,password);
        login.verificarDashboardVisible();
        login.realizarLogout();
    }

    // 2 Password incorrecto
    @Test(priority = 2)
    @Story("Password incorrecta")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifica que aparezca un mensaje de error al ingresar una contraseña incorrecta")
    public void LoginPasswordIncorrecto(){
        login.ingresarCredenciales(username, "clave_invalida");
        login.verificarMensajeError("Error de validación: ¡Nombre de usuario o contraseña inválidos!");
    }

    // 3 Usuario incorrecto
    @Test(priority = 3)
    @Story("Usuario incorrecto")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifica que aparezca un mensaje de error al ingresar un nombre de usuario incorrecto")
    public void  LoginUsuarioIncorrecto(){
        login.ingresarCredenciales("usuario_falso", password);
        login.verificarMensajeError("Error de validación: ¡Nombre de usuario o contraseña inválidos!");
    }

    // 4 Ambos campos vacios
    @Test(priority = 4)
    @Story("Campos vacíos")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifica que aparezca un mensaje de error al dejar ambos campos vacíos")
    public void LoginCamposVacios(){
        login.ingresarCredenciales("","");
        login.verificarMensajeError("Error de validación: ¡Nombre de usuario o contraseña inválidos!");
    }

    // 5 Solo usuario cargado
    @Test(priority = 5)
    @Story("Solo usuario cargado")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifica que aparezca un mensaje de error si se completa solo el campo usuario")
    public void LoginSoloUsuario(){
        login.ingresarCredenciales(username,"");
        login.verificarMensajeError("Error de validación: ¡Nombre de usuario o contraseña inválidos!");
    }

    // 6 Solo contraseña cargada
    @Test(priority = 6)
    @Story("Solo contraseña cargada")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifica que aparezca un mensaje de error si se completa solo el campo contraseña")
    public void LoginSoloPassword(){
        login.ingresarCredenciales("",password);
        login.verificarMensajeError("Error de validación: ¡Nombre de usuario o contraseña inválidos!");
    }

    /*
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

*/

}


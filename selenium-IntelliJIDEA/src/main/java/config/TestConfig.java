// Variables globales (URLs, credenciales de prueba, timeouts)
// Aquí defines valores generales que pueden cambiar con el tiempo (evitas hardcodear en los tests).
// e.g: Si cambia la URL base, solo editas aquí en un solo lugar, en vez de modificar cada prueba.

package config;
import listeners.TestExecutionControl;
import org.testng.annotations.BeforeSuite;

public class TestConfig {
    @BeforeSuite
    public void resetearFlag() {
        TestExecutionControl.shouldStop = false;
    }
    public static final String BASE_URL = "https://demo.serenity.is/";
    public static final String LOGIN_URL = BASE_URL + "Account/Login/?ReturnUrl=%2F";
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "serenity";
    public static final int DEFAULT_TIMEOUT = 10; // Segundos
}


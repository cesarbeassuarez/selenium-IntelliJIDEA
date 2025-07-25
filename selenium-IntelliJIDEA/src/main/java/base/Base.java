// WRAPPER

package base;

import listeners.TestExecutionControl;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class Base {

    private WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "D:\\Proyectos\\chrome_testing\\chromedriver-win64\\chromedriver.exe"); // Ruta de ChromeDriver
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void verificarFalloAnterior(Method metodo) {
        if (TestExecutionControl.enabled && TestExecutionControl.shouldStop) {
            System.out.println("⏭ Test '" + metodo.getName() + "' salteado por fallo anterior.");
            throw new SkipException("❌ Se detiene ejecución por fallo previo.");
        }
    }
}

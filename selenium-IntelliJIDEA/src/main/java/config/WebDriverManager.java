// Archivo Configuracion del navegador
// Esta clase se encarga de inicializar y cerrar el navegador en cada prueba.
// e.g: En lugar de crear un new ChromeDriver() en cada test, simplemente llamas a: WebDriver driver = WebDriverManager.getDriver();

package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class WebDriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.setBinary("D:\\Proyectos\\chrome_testing\\chrome-win64\\chrome.exe"); // Ruta de Chrome for Testing

            System.setProperty("webdriver.chrome.driver", "D:\\Proyectos\\chrome_testing\\chromedriver-win64\\chromedriver.exe"); // Ruta de ChromeDriver

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        return driver;
    }
}

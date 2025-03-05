package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SeleniumTest {
    public static void main(String[] args) {
        // Configurar la ruta de Chrome for Testing y ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.setBinary("D:\\Proyectos\\chrome_testing\\chrome-win64\\chrome.exe"); // Ruta de Chrome for Testing

        System.setProperty("webdriver.chrome.driver", "D:\\Proyectos\\chrome_testing\\chromedriver-win64\\chromedriver.exe"); // Ruta de ChromeDriver

        // Inicializar el navegador
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Abrir Google como prueba
        driver.get("https://www.google.com");
        System.out.println("Título de la página: " + driver.getTitle());

        // Cerrar el navegador
        // driver.quit();
    }
}


//https://demo.serenity.is/Account/Login/?ReturnUrl=%2F

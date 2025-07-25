package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DriverManager {

    // ✅ WebDriver compartido para todo el proyecto (no por hilo)
    private static WebDriver driver;

    // Setter del driver
    public static void setDriver(WebDriver driverParam) {
        driver = driverParam;
    }

    // Getter del driver
    public static WebDriver getDriver() {
        return driver;
    }

    // Cerrar sesión del driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // ⏱ Tiempo máximo de espera para encontrar elementos
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(60);

    // ✅ Encuentra un solo elemento esperando hasta 60s si es necesario
    public static WebElement findElement(By by) {
        //WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        System.out.println("🔍 Iniciando búsqueda de: " + by.toString());
        WebDriver driver = getDriver(); // breakpoint aquí
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        try {
            long start = System.currentTimeMillis();
            wait.until(ExpectedConditions.presenceOfElementLocated(by));    // ⏳ Espera hasta que esté en el DOM
            long end = System.currentTimeMillis();
            System.out.println("⏱ Tiempo esperado: " + (end - start) + "ms");
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));  // 👀 Espera hasta que sea visible
            wait.until(ExpectedConditions.elementToBeClickable(by));        // ✅ Espera hasta que pueda hacer click
            return driver.findElement(by);
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("🧪 DRIVER EN USO: " + DriverManager.getDriver());

            System.out.println("⏰ No se encontró el elemento dentro del tiempo de espera: " + by.toString());
            e.printStackTrace(); // para que veas la excepción exacta
            CommonActions.capturarPantallaAllure(driver); // opcional
            throw e;
        }
    }


    // ✅ Encuentra varios elementos esperando hasta 60s si es necesario
    public static List<WebElement> findElements(By by) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }
}

package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonActions {

    // Este es para guardar en disco (como ya hacías)
    public static void capturarPantalla(WebDriver driver, String nombreArchivo) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String ruta = "screenshots/" + nombreArchivo + "_" + timestamp + ".png";

        try {
            Files.createDirectories(new File("screenshots").toPath());
            Files.copy(screenshot.toPath(), new File(ruta).toPath());
            System.out.println("📸 Captura guardada: " + ruta);
        } catch (IOException e) {
            System.out.println("❌ Error al guardar captura: " + e.getMessage());
        }
    }

    // Este es para mostrar la captura en el reporte Allure
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] capturarPantallaAllure(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Verifica si un elemento está presente y visible en pantalla

    public static boolean existeElemento(WebDriver driver, By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }*/
}

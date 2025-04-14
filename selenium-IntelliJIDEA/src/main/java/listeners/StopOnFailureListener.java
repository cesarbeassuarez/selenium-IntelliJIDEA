package listeners;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverManager;

import java.io.ByteArrayInputStream;
import listeners.TestExecutionControl;

public class StopOnFailureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test fallido: " + result.getName());

        // Obtener el WebDriver actual (de tu clase DriverManager)
        WebDriver driver = DriverManager.getDriver();

        if (driver != null) {
            try {
                // Capturar screenshot como byte[]
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                // Adjuntar a Allure
                Allure.addAttachment("📸 Screenshot al fallar", new ByteArrayInputStream(screenshot));
                System.out.println("🖼️ Screenshot capturado y adjuntado al log de Allure");
            } catch (Exception e) {
                System.out.println("⚠️ No se pudo capturar el screenshot: " + e.getMessage());
            }
        } else {
            System.out.println("⚠️ WebDriver es null, no se pudo capturar screenshot");
        }

        System.out.println("🟡 Marcando ejecución para detener próximos tests.");
        TestExecutionControl.shouldStop = true;
    }
}

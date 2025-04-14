package base;

import listeners.TestExecutionControl;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void verificarFalloAnterior(Method metodo) {
        if (TestExecutionControl.shouldStop) {
            System.out.println("⏭️ Test '" + metodo.getName() + "' salteado por fallo anterior.");
            throw new SkipException("❌ Se detiene ejecución por fallo previo.");
        }
    }
}

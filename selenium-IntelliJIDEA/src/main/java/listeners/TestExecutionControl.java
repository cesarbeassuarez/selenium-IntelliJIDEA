package listeners;
import config.PropertiesReader;

public class TestExecutionControl {
    public static boolean shouldStop = false;
    public static boolean enabled = true;

    static {
        String valor = PropertiesReader.getProperty("stop.on.error");
        enabled = Boolean.parseBoolean(valor);
    }
}

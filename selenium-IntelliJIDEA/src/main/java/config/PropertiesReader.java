// Leer datos desde un archivo .properties
// Si necesitas manejar configuraciones externas sin tocar el código, usa archivos .properties.
/* e.g:
Ejemplo de un archivo config.properties:

base.url=https://demo.serenity.is/
login.username=admin
login.password=serenity

Cómo usarlo en un test:
String baseUrl = PropertiesReader.getProperty("base.url");
System.out.println("URL Base: " + baseUrl);

Ventaja: Puedes cambiar credenciales o URLs sin modificar el código.
*/

package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

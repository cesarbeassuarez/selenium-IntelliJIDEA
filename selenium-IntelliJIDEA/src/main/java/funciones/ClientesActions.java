package funciones;

import org.openqa.selenium.WebDriver;
import pages.ClientesPage;
// import utils.ExcelReader;

public class ClientesActions {
    private WebDriver driver;
    private ClientesPage clientesPage;

    public ClientesActions(WebDriver driver) {
        this.driver = driver;
        this.clientesPage = new ClientesPage(driver);
    }


}


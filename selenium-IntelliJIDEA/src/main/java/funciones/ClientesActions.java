package funciones;

import org.openqa.selenium.WebDriver;
import pages.ClientesPage;
import utils.ExcelReader;

public class ClientesActions {
    private WebDriver driver;
    private ClientesPage clientesPage;

    public ClientesActions(WebDriver driver) {
        this.driver = driver;
        this.clientesPage = new ClientesPage(driver);
    }

    public void crearClienteDesdeExcel(String rutaExcel, int fila) {
        String nombre = ExcelReader.leerDato(rutaExcel, fila, 0);
        String telefono = ExcelReader.leerDato(rutaExcel, fila, 1);
        String direccion = ExcelReader.leerDato(rutaExcel, fila, 2);

        clientesPage.irAClientes();
        clientesPage.clickNuevoCliente();
        clientesPage.ingresarNombre(nombre);
        clientesPage.ingresarTelefono(telefono);
        clientesPage.ingresarDireccion(direccion);
        clientesPage.guardarCliente();
    }
}


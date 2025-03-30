package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    public static String leerDato(String rutaArchivo, int fila, int columna) {
        try {
            FileInputStream file = new FileInputStream(new File(rutaArchivo));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(fila);
            Cell cell = row.getCell(columna);
            file.close();
            return cell.getStringCellValue();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

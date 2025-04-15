package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AllureReportGenerator {

    public static void generarReporte(String modulo) {
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm"));
        String outputDir = "reportes/" + modulo + "_" + fechaHora;

        String comandoGenerar = "cmd.exe /c allure generate allure-results --clean -o " + outputDir;
        String comandoAbrir = "cmd.exe /c start \"\" allure open \"" + outputDir + "\"";

        try {
            System.out.println("🛠️ Generando log Allure en: " + outputDir);
            Process generar = Runtime.getRuntime().exec(comandoGenerar);
            generar.waitFor();

            System.out.println("✅ Log generado. Abriendo reporte...");
            Process abrir = Runtime.getRuntime().exec(comandoAbrir);

        } catch (IOException | InterruptedException e) {
            System.out.println("❌ Error al generar o abrir el log: " + e.getMessage());
        }
    }
}

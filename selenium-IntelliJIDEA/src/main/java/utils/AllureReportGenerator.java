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

        String comando = "cmd.exe /c allure generate allure-results --clean -o " + outputDir;

        try {
            System.out.println("🛠️ Ejecutando: " + comando);
            Process proceso = Runtime.getRuntime().exec(comando);

            // Leer salida para debug
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println("▶ " + linea);
            }

            int exitCode = proceso.waitFor();
            if (exitCode == 0) {
                System.out.println("✅ Reporte generado en: " + outputDir);
            } else {
                System.out.println("❌ Error. Código de salida: " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("❌ Excepción al generar el reporte: " + e.getMessage());
        }
    }
}

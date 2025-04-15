@echo off
setlocal enabledelayedexpansion

:: -----------------------------
:: CONFIGURACIÓN
:: -----------------------------

set suite=testng-login.xml
set modulo=login

:: Obtener fecha y hora actual (formato YYYY-MM-DD_HH-MM)
for /f "tokens=1-3 delims=/" %%a in ("%date%") do (
    set dia=%%a
    set mes=%%b
    set anio=%%c
)

for /f "tokens=1-2 delims=:" %%a in ("%time%") do (
    set hora=%%a
    set minutos=%%b
)

:: Asegura dos dígitos en la hora
set hora=!hora: =0!
set fechaHora=!anio!-!mes!-!dia!_!hora!-!minutos!

:: Carpeta destino del reporte
set outputDir=reportes\%modulo%_%fechaHora%

:: -----------------------------
:: EJECUCIÓN
:: -----------------------------

echo.
echo =====================================
echo  Ejecutando suite: %suite%
echo =====================================
echo.


cmd /c mvn test -DsuiteXmlFile=%suite%


echo.
echo =====================================
echo  Generando reporte Allure
echo =====================================
echo.

where allure > nul 2>&1
if %errorlevel% neq 0 (
    echo ❌ ERROR: Allure no está instalado o no está en el PATH
    pause
    exit /b
)

allure generate allure-results --clean -o %outputDir%

echo.
echo ✅ Reporte generado en: %outputDir%

pause
endlocal

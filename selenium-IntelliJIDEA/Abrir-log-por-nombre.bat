@echo off
setlocal enabledelayedexpansion

echo.
echo ╔══════════════════════════════════════════════╗
echo ║         🧭 ABRIR LOG DE ALLURE INTERACTIVO    ║
echo ╚══════════════════════════════════════════════╝
echo.

echo 📁 Carpetas disponibles en /reportes:
echo ---------------------------------------
for /D %%f in (reportes\login_*) do (
    echo    - %%~nxf
)
echo.

:: INPUT REAL
set /p logName=✏️  Ingrese el nombre exacto del log a abrir:

set "ruta=reportes\%logName%"

if exist "%ruta%\index.html" (
    echo ✅ Abriendo reporte con Allure: %logName%
    allure open "%ruta%"
) else (
    echo ❌ No se encontró el archivo: %ruta%\index.html
)

pause
endlocal

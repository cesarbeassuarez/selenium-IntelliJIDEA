@echo off
set "reportFolder="

:: Buscar la última carpeta dentro de /reportes ordenada por fecha
for /f "delims=" %%a in ('dir /b /ad /o-d reportes\login_*') do (
    set "reportFolder=%%a"
    goto :found
)

:found
if defined reportFolder (
    echo 📂 Abriendo último reporte: %reportFolder%
    allure open "reportes\%reportFolder%"
) else (
    echo ❌ No se encontraron carpetas dentro de /reportes
)

pause

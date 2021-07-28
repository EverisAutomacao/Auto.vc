@echo off
dir /b /o:n *.apk > log.txt
set /p NOME_APK=<log.txt
echo Instalando %NOME_APK%
echo Aguarde...
cd platform-tools
adb install -i com.android.vending -r ../%NOME_APK%
echo Instalacao concluida.
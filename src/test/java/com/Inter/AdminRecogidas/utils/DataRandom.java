package com.Inter.AdminRecogidas.utils;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.math.BigInteger;
import java.util.Random;

public class DataRandom extends PageObject {

    InteractorTime interactorTime = new InteractorTime();
    public By cotizacionTpaquete = By.xpath("//div[@id='DatosCotizacion']/div[1]/div[1]/form/div[7]/select");

    public static String NumeroCelular() {
        String NumCel = "";
        String celu1 = "";
        String celu2 = "";
        String celu3 = "";
        int cel1 = (int) (1 + (Math.random() * 299));
        int cel2 = (int) (1 + (Math.random() * 999));
        int cel3 = (int) (1 + (Math.random() * 999));
        if (cel1<100 && cel1>=10){
            celu1 = ("0" + cel1);
        }else if (cel1<10){
            celu1 = ("00" + cel1);
        }else{
            celu1 = String.valueOf(cel1);
        }
        if (cel2<100 && cel2>=10){
            celu2 = ("0" + cel2);
        }else if (cel2<10){
            celu2 = ("00" + cel2);
        }else{
            celu2 = String.valueOf(cel2);
        }
        if (cel3<100 && cel3>=10){
            celu3 = ("0" + cel3);
        }else if (cel3<10){
            celu3 = ("00" + cel3);
        }else{
            celu3 = String.valueOf(cel3);
        }
        NumCel = ("3" + celu1 + celu2 + celu3);
        return NumCel;
    }

    public static String Cedula(){
        String cedula = "";
        long ced = 0;
        int longitud = (int) (5 + Math.random() * 18);
        switch (longitud){
            case 5:{
                ced = (long) (10000L + Math.random() * 99999L);
                break;
            }
            case 6:{
                ced = (long) (100000L + Math.random() * 999999L);
                break;
            }
            case 7:{
                ced = (long) (1000000L + Math.random() * 9999999L);
                break;
            }
            case 8:{
                ced = (long) (10000000L + Math.random() * 99999999L);
                break;
            }
            case 9:{
                ced = (long) (100000000L + Math.random() * 999999999L);
                break;
            }
            case 10:{
                ced = (long) (1000000000L + Math.random() * 9999999999L);
                break;
            }
            case 11:{
                ced = (long) (10000000000L + Math.random() * 99999999999L);
                break;
            }
            case 12:{
                ced = (long) (100000000000L + Math.random() * 999999999999L);
                break;
            }
            case 13:{
                ced = (long) (1000000000000L + Math.random() * 9999999999999L);
                break;
            }
            case 14:{
                ced = (long) (10000000000000L + Math.random() * 99999999999999L);
                break;
            }
            case 15:{
                ced = (long) (100000000000000L + Math.random() * 999999999999999L);
                break;
            }
            case 16:{
                ced = (long) (1000000000000000L + Math.random() * 9999999999999999L);
                break;
            }
            case 17:{
                ced = (long) (10000000000000000L + Math.random() * 99999999999999999L);
                break;
            }
            case 18:{
                ced = (long) (100000000000000000L + Math.random() * 999999999999999999L);
                break;
            }
        }
        cedula = Long.toString(ced);
        return cedula;
    }

    public static String CorreoElectronico() {
        Random Caracter = new Random();
        char letra1 = (char) (Caracter.nextInt(26) + 'a');
        char letra2 = (char) (Caracter.nextInt(26) + 'a');
        char letra3 = (char) (Caracter.nextInt(26) + 'a');
        String Correo = ("prueba" + letra1 + letra2 + letra3 + "@gmail.com");
        return Correo;
    }

    public  static  String Nombre(){
        Random Caracter = new Random();
        char letra1 = (char) (Caracter.nextInt(26) + 'A');
        char letra2 = (char) (Caracter.nextInt(26) + 'A');
        char letra3 = (char) (Caracter.nextInt(26) + 'A');
        String Nom = ("ESNEYDE"+ letra1 + letra2 + letra3);
        return Nom;
    }

    public  static  String Apellido(){
        Random Caracter = new Random();
        char letra1 = (char) (Caracter.nextInt(26) + 'A');
        char letra2 = (char) (Caracter.nextInt(26) + 'A');
        char letra3 = (char) (Caracter.nextInt(26) + 'A');
        String Apel = ("GUTIERRE"+ letra3 + letra2 + letra1);
        return Apel;
    }

    public static String Ciudad() {
        String Ciud = new String();
        int longitud = (int) (1 + (Math.random() * 32));
        switch (longitud) {
            case 1: {
                Ciud = ("MEDELLIN\\ANT\\COL");
                break;
            }
            case 2: {
                Ciud = ("ARAUCA ARAUCA\\ARAU\\COL");
                break;
            }
            case 3: {
                Ciud = ("BARRANQUILLA\\ATLA\\COL");
                break;
            }
            case 4: {
                Ciud = ("CARTAGENA BOLIVAR\\BOLI\\COL");
                break;
            }
            case 5: {
                Ciud = ("TUNJA\\BOYA\\COL");
                break;
            }
            case 6: {
                Ciud = ("MANIZALES\\CALD\\COL");
                break;
            }
            case 7: {
                Ciud = ("FLORENCIA CAQUETA\\CAQU\\COL");
                break;
            }
            case 8: {
                Ciud = ("YOPAL\\CASA\\COL");
                break;
            }
            case 9: {
                Ciud = ("POPAYAN\\CAUC\\COL");
                break;
            }
            case 10: {
                Ciud = ("VALLEDUPAR\\CESA\\COL");
                break;
            }
            case 11: {
                Ciud = ("QUIBDO\\CHOC\\COL");
                break;
            }
            case 12: {
                Ciud = ("MONTERIA\\CORD\\COL");
                break;
            }
            case 13: {
                Ciud = ("BOGOTA\\CUND\\COL");
                break;
            }
            case 14: {
                Ciud = ("INIRIDA\\GUAI\\COL");
                break;
            }
            case 15: {
                Ciud = ("SAN JOSE DEL GUAVIARE\\GUAV\\COL");
                break;
            }
            case 16: {
                Ciud = ("NEIVA\\HUIL\\COL");
                break;
            }
            case 17: {
                Ciud = ("RIOHACHA\\GUAJ\\COL");
                break;
            }
            case 18: {
                Ciud = ("SANTA MARTA\\MAGD\\COL");
                break;
            }
            case 19: {
                Ciud = ("VILLAVICENCIO\\META\\COL");
                break;
            }
            case 20: {
                Ciud = ("PASTO\\NARI\\COL");
                break;
            }
            case 21: {
                Ciud = ("CUCUTA\\NORT\\COL");
                break;
            }
            case 22: {
                Ciud = ("MOCOA\\PUTU\\COL");
                break;
            }
            case 23: {
                Ciud = ("ARMENIA_QUINDIO\\QUIN\\COL");
                break;
            }
            case 24: {
                Ciud = ("PEREIRA\\RISA\\COL");
                break;
            }
            case 25: {
                Ciud = ("BUCARAMANGA\\SANT\\COL");
                break;
            }
            case 26: {
                Ciud = ("IBAGUE\\TOLI\\COL");
                break;
            }
            case 27: {
                Ciud = ("CALI\\VALL\\COL");
                break;
            }
            case 28: {
                Ciud = ("MITU\\VAUP\\COL");
                break;
            }
            case 29: {
                Ciud = ("LETICIA\\AMAZ\\COL");
                break;
            }
            case 30: {
                Ciud = ("SAN ANDRES ARCHIPIELAGO DE SAN ANDRES , PROVIDENCIA Y SANTA CATALINA\\ARCH\\COL");
                break;
            }
            case 31: {
                Ciud = ("SINCELEJO\\SUCR\\COL");
                break;
            }
            case 32: {
                Ciud = ("PUERTO CARRENO\\VICH\\COL");
                break;
            }
        }
        return Ciud;
    }

    public static String CiudadAPP() {
        String Ciud = new String();
        int longitud = (int) (1 + (Math.random() * 2));
        switch (longitud) {
            case 1: {
                Ciud = ("MEDELLIN\\ANT\\COL");
                break;
            }
            case 2: {
                Ciud = ("BOGOTA\\CUND\\COL");
                break;
            }
        }
        return Ciud;
    }

    public static String Donde() {
        String Don = new String();
        int longitud = (int) (1 + (Math.random() * 4));
        switch (longitud){
            case 1: {
                Don = "CENTROS PENITENCIARIOS";
                break;
            }
            case 2: {
                Don = "ENTREGA EN DIRECCION";
                break;
            }
            case 3: {
                Don = "GUARNICION MILITAR";
                break;
            }
            case 4: {
                Don = "VEREDAS";
                break;
            }
        }
        return Don;
    }

    public void paquete() {
        int longitud = (int) (1 + (Math.random() * 4));
        switch (longitud){
            case 1: {
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                break;
            }
            case 2: {
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                break;
            }
            case 3: {
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                break;
            }
            case 4: {
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                break;
            }
        }
    }
}

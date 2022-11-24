package com.Inter.AdminRecogidas.utils;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.Random;

public class DataRandom {

    public static String NumeroCelular() {
        long cel = (long) (Math.random() * (99999999L - 10000000L)) + 10000000L;
        int cel2 = (int) (Math.random() * (2 - 0)) + 0;
        String NumCel = ("3" + cel2 + cel);
        return NumCel;
    }

    public static String Cedula() {
        long ced = 0;
        int longitud = (int) (Math.random()*(12 - 5) + 5);
        switch (longitud){
            case 5:{
                ced = (long) (Math.random() * (99999L - 10000L)) + 10000L;
                break;
            }
            case 6:{
                ced = (long) (Math.random() * (999999L - 100000L)) + 100000L;
                break;
            }
            case 7:{
                ced = (long) (Math.random() * (9999999L - 1000000L)) + 10000L;
                break;
            }
            case 8:{
                ced = (long) (Math.random() * (99999999L - 10000000L)) + 100000L;
                break;
            }
            case 9:{
                ced = (long) (Math.random() * (999999999L - 100000000L)) + 1000000L;
                break;
            }
            case 10:{
                ced = (long) (Math.random() * (9999999999L - 1000000000L)) + 10000000L;
                break;
            }
            case 11:{
                ced = (long) (Math.random() * (99999999999L - 10000000000L)) + 100000000L;
                break;
            }
            case 12:{
                ced = (long) (Math.random() * (999999999999L - 100000000000L)) + 1000000000L;
                break;
            }
        }
        String Ced = ("" + ced);
        return Ced;
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
        String Nom = ("ESNEYDE"+ letra1 + letra2 + letra3 +" GUTIERRE"+ letra3 + letra2 + letra1);
        return Nom;
    }

    public static String Ciudad() {
        String Ciud = new String();
        int longitud = (int) (Math.random() * (29 - 1) + 1);
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
        }
        return Ciud;
    }

    public static String CiudadAPP() {
        String Ciud = new String();
        int longitud = (int) (Math.random() * (3 - 1) + 1);
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
        int longitud = (int) (Math.random() * (4 - 1) + 1);
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

    public static String paquete() {
        String paq = new String();
        int longitud = (int) (Math.random() * (4 - 1) + 1);
        switch (longitud){
            case 1: {
                paq = "PAQUETE PEQUEÑO";
                break;
            }
            case 2: {
                paq = "SOBRE CARTA";
                break;
            }
            case 3: {
                paq = "SOBRE MANILA";
                break;
            }
            case 4: {
                paq = "TULA";
                break;
            }
        }
        return paq;
    }
}

package com.Inter.AdminRecogidas.utils;

import com.Inter.AdminRecogidas.pageObjects.PantallaconfirmacionPage;
import com.Inter.AdminRecogidas.pageObjects.PreenvioExitoso;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataCvs {
    static String CSV_RECO_PATH_OUT = "src/archivosCVS/TestDataRecogidasOut.csv";
    static String CSV_RECO_PATH = "src/archivosCVS/TestDataRecogidas.csv";

    static String CSV_PREE_PATH_OUT = "src/archivosCVS/TestDataPreenviosOut.csv";

    static String CSV_PREE_POS_OUT = "src/archivosCVS/DataPruebasPosOut.csv";
    static String CSV_PREE_AFECTACION_OUT = "src/archivosCVS/DataPruebasAfectacionOut.csv";
    static String CSV_PREE_PATH = "src/archivosCVS/TestDataPreenvios.csv";

    static String CSV_APP_PATH = "src/archivosCVS/DatosPreenvio.csv";
    private static CSVReader csvReader;
    //private static CSVParser csvReader;
    private static BufferedWriter cvsWriter;
    static String[] csvCell;

    static String cedula,celular,nombre,correo,ciudad,direccion,complemento,ciudaddes,destino,tipopq,contenido,
                   nombredes,cedulades,celulardes,direcciondes,correodes;
    static Integer n=0;

    public void Datos(String Dato)throws IOException, CsvValidationException {
        if (Dato.equals("Recogida")){
            CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
            csvReader = new CSVReaderBuilder(new FileReader(CSV_RECO_PATH))
                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build();
            while ((csvCell = csvReader.readNext()) != null){
                n++;
            }
        }
        if (Dato.equals("Preenvio")){
            CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
            csvReader = new CSVReaderBuilder(new FileReader(CSV_RECO_PATH))
                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build();
            while ((csvCell = csvReader.readNext()) != null){
                n++;
            }
        }
    }
    public static Integer CantidadDatos() throws CsvValidationException, IOException {
        Integer Datos = n;
        return Datos;
    }

    public void NumeroDato(Integer m,String Dato)throws IOException, CsvValidationException {
        if (Dato.equals("Recogida")){
            CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
            csvReader = new CSVReaderBuilder(new FileReader(CSV_RECO_PATH))
                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build();
            Integer i = 0;
            while (((csvCell = csvReader.readNext()) != null) && i <= m){
                cedula = csvCell[0];
                celular = csvCell[1];
                nombre = csvCell[2];
                correo = csvCell[3];
                ciudad = csvCell[4];
                direccion = csvCell[5];
                complemento = csvCell[6];
                i++;
            }
        }
        if (Dato.equals("Preenvio")){
            CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
            csvReader = new CSVReaderBuilder(new FileReader(CSV_PREE_PATH))
                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build();
            Integer i = 0;
            while (((csvCell = csvReader.readNext()) != null) && i <= m){
                cedula = csvCell[0];celular = csvCell[1];ciudaddes = csvCell[2];
                destino = csvCell[3];tipopq = csvCell[4];contenido = csvCell[5];nombredes = csvCell[6];
                i++;
            }
        }
    }

    public static String cedula2() {
        String cedula1 = cedula;
        return cedula1;
    }
    public static String celular2() {
        String celular1 = celular;
        return celular1;
    }
    public static String nombre2() {
        String nombre1 = nombre;
        return nombre1;
    }
    public static String correo2() {
        String correo1 = correo;
        return correo1;
    }

    public static String ciudad2() {
        String ciudad1 = ciudad;
        return ciudad1;
    }

    public static String direccion2() {
        String direccion1 = direccion;
        return direccion1;
    }

    public static String complemento2() {
        String complemento1 = complemento;
        return complemento1;
    }

    public static String ciudaddes2() {
        String ciudaddes1 = ciudaddes;
        return ciudaddes1;
    }

    public static String destino2() {
        String destino1 = destino;
        return destino1;
    }

    public static String tipopq2() {
        String tipopq1 = tipopq;
        return tipopq1;
    }

    public static String contenido2() {
        String contenido1 = contenido;
        return contenido1;
    }

    public static String nombredes2() {
        String nombredes1 = nombredes;
        return nombredes1;
    }

    public static String cedulades2() {
        String cedulades1 = cedulades;
        return cedulades1;
    }

    public static String celulardes2() {
        String celulardes1 = celulardes;
        return celulardes1;
    }

    public static String direcciondes2() {
        String direcciondes1 = direcciondes;
        return direcciondes1;
    }

    public static String correodes2() {
        String correodes1 = correodes;
        return correodes1;
    }
    public void CrearCsv(String Dato) throws IOException {
        if (Dato.equals("Recogida")){
            CSVWriter writer = new CSVWriter(new FileWriter(CSV_RECO_PATH_OUT),';',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            //fwrite.write('\ufeff');
            String[] headerRecord = {"DocumentoRemitente", "NombreRemitente","CelularRemitente","NumeroRecogida"};
            writer.writeNext(headerRecord);
            writer.writeAll(PantallaconfirmacionPage.outCsv());
            writer.close();
        }
        if (Dato.equals("Preenvio")){
            CSVWriter writer = new CSVWriter(new FileWriter(CSV_PREE_PATH_OUT),';',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            String[] headerRecord = {"DocumentoRemitente", "NombreRemitente","CelularRemitente","DocumentoDestinatario","NombreDestinatario",
                    "CelularDestinatario","NumeroRecogida","NumeroPreenvio"};
            writer.writeNext(headerRecord);
            writer.writeAll(PreenvioExitoso.outCsv());
            writer.close();
        }
        if (Dato.equals("POS")){
            CSVWriter writer = new CSVWriter(new FileWriter(CSV_PREE_POS_OUT),',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            String[] headerRecord = {"DocumentoRemitente","CelularRemitente","DocumentoDestinatario", "CelularDestinatario"
                    ,"TipoDePago","TipoServicio","NumeroPreenvio"};
            writer.writeNext(headerRecord);
            writer.writeAll(PreenvioExitoso.outCsv());
            writer.close();
            System.out.println("Se creo la Data");
        }
        if (Dato.equals("Afectacion")){
            CSVWriter writer = new CSVWriter(new FileWriter(CSV_PREE_AFECTACION_OUT),',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            String[] headerRecord = {"DocumentoRemitente","CelularRemitente","DocumentoDestinatario", "CelularDestinatario"
                    ,"TipoDePago","NumeroPreenvio"};
            writer.writeNext(headerRecord);
            writer.writeAll(PreenvioExitoso.outCsv());
            writer.close();
            System.out.println("Se creo la Data");
        }
        if (Dato.equals("APP")){
            CSVWriter writer = new CSVWriter(new FileWriter(CSV_APP_PATH),',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            String[] headerRecord = {"ID - Recogida"};
            writer.writeNext(headerRecord);
            writer.writeAll(PreenvioExitoso.outCsv());
            writer.close();
            System.out.println("Se creo la Data");
        }
    }
}

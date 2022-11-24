package com.Inter.AdminRecogidas.steps;

import com.Inter.AdminRecogidas.pageObjects.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;
import net.thucydides.core.annotations.Step;
import com.Inter.AdminRecogidas.utils.DataCvs;

import java.io.IOException;


public class CvsSteps {

    DatosPersonalesPage datosPersonalesPage = new DatosPersonalesPage();
    DataCvs dataCvs = new DataCvs();
    PantallaconfirmacionPage pantallaconfirmacionPage = new PantallaconfirmacionPage();
    DatosRecogidaPage datosRecogidaPage = new DatosRecogidaPage();

    CotizaciondeenviosPage cotizaciondeenviosPage = new CotizaciondeenviosPage();

    DatosDestinatario datosDestinatario = new DatosDestinatario();

    PreenvioExitoso preenvioExitoso = new PreenvioExitoso();
    PreenviosSteps preenviosSteps = new PreenviosSteps();

    @Step
    public void determinodata(String Dato) throws CsvValidationException, IOException {
        dataCvs.Datos(Dato);
        datosPersonalesPage.OpenAdmin();
    }

    @Step
    public void ncantidaddata(String Dato) throws CsvValidationException, IOException {
        Integer n = DataCvs.CantidadDatos();
        Integer m=0;
        if (Dato.equals("Recogida")){
            while (m<n){
                dataCvs.NumeroDato(m,Dato);
                datosPersonalesPage.DatosPersonalesCvs();
                datosRecogidaPage.DatosRecogidaCsv();
                pantallaconfirmacionPage.formularioexitosoCsv(Dato);
                m++;
                if (m<n){
                    datosPersonalesPage.OpenAdmin();
                }
            }
        }
        if (Dato.equals("Preenvio")){
            while (m<n){
                dataCvs.NumeroDato(m,Dato);
                datosPersonalesPage.DatosPersonalesCvs();
                datosRecogidaPage.DatosRecogidaCVS();
                pantallaconfirmacionPage.formularioexitosoCsv(Dato);
                cotizaciondeenviosPage.CotizatuenvioCsv();
                datosDestinatario.datoaDestinatarioCsv();
                preenvioExitoso.preenvioexitosoCvs();
                m++;
                if (m<n){
                    datosPersonalesPage.OpenAdmin();
                }
            }
        }
    }

    @Step
    public void CrearCvs(String Dato) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        dataCvs.CrearCsv(Dato);
    }

    @Step
    public void diferentespreenvios(){
        datosRecogidaPage.DatosRecogidaCVS();
    }
}

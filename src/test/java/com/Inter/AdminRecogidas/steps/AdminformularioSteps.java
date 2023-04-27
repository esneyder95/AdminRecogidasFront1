package com.Inter.AdminRecogidas.steps;

import com.Inter.AdminRecogidas.pageObjects.DatosPersonalesPage;
import com.Inter.AdminRecogidas.pageObjects.DatosRecogidaPage;
import com.Inter.AdminRecogidas.pageObjects.PantallaconfirmacionPage;
import com.opencsv.exceptions.CsvValidationException;
import net.thucydides.core.annotations.Step;
import java.io.IOException;

public class AdminformularioSteps {
    DatosPersonalesPage datosPersonalesPage = new DatosPersonalesPage();
    DatosRecogidaPage datosRecogidaPage = new DatosRecogidaPage();
    PantallaconfirmacionPage pantallaconfirmacionPage = new PantallaconfirmacionPage();


    @Step
    public void ingresalapaginaderecogidas() {
        datosPersonalesPage.OpenAdmin();
    }

    @Step
    public void ingresalosdatosdePersonales() {
        datosPersonalesPage.DatosPersonales();
    }

    @Step
    public void secargalapaginarecogidas() {
        datosRecogidaPage.SeCargaPagina();
    }

    @Step
    public void ingresalosdatosdeRecogida() {
        datosRecogidaPage.DatosRecogida();
    }

    @Step
    public void regresohomeexitoso() {
        datosPersonalesPage.regresohome();
    }

    @Step
    public void solicituddelarecogida() {
        pantallaconfirmacionPage.formularioexitoso();
    }

    @Step
    public void solicituddelarecogidanuevopreenvio() {
        pantallaconfirmacionPage.formularioexitosonuevoprenvio();
    }

    @Step
    public void ingresalosdatosdePersonalesF(String Cedula, String Celular) {
        datosPersonalesPage.DatosPersonalesF(Cedula, Celular);
    }

    @Step
    public void ingresalosdatosdePersonalesFR(String Cedula, String Celular) {
        datosPersonalesPage.DatosPersonalesPOS(Cedula,Celular);
    }

    @Step
    public void ingresalosdatosdePersonalesPOS(String Cedula, String Celular) {
        datosPersonalesPage.DatosPersonalesPOS(Cedula,Celular);
    }

    @Step
    public void ingresalosdatosdeRecogidaF() {
        datosRecogidaPage.DatosRecogidaf();
    }

    @Step
    public void ingresalosdatosdeAPP() {
        datosRecogidaPage.DatosRecogidaAPP();
    }

    @Step
    public void solicituddelarecogidaAPP() {
        pantallaconfirmacionPage.recogidaexitosaAPP();
    }

    @Step
    public void IngresoTusRecogidas(){
        datosRecogidaPage.IngresoTusRecogidas();
    }
    @Step
    public void TusRecogidas(){
        datosRecogidaPage.TusRecogidas();
    }
    @Step
    public void seleccionologo(){
        datosPersonalesPage.linkinterrapidisimo();
    }
    @Step
    public void linkinterexitoso(){
        datosPersonalesPage.linkexitosointer();
    }
    @Step
    public void seleccionopoliticadatos(){
        datosRecogidaPage.linkpoliticadatos();
    }
    @Step
    public void linkpoliticadatosexitoso(){
        datosRecogidaPage.linkexitosopoliticadatos();
    }

    @Step
    public void seleccionterminos(){
        datosRecogidaPage.linkterminos();
    }
    @Step
    public void linkterminosexitoso(){
        datosRecogidaPage.linkexitosoterminos();
    }

}

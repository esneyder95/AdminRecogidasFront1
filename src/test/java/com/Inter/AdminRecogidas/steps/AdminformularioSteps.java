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
    public void ingresalosdatosdePersonales() throws CsvValidationException, IOException {
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
    /*@Step
    public void Enviaelformulario(){
        datosRecogidaPage.EnviarFormulario();
    }*/
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
    public void ingresalosdatosdePersonalesFR() {
        datosPersonalesPage.DatosPersonalesPOS();
    }

    @Step
    public void ingresalosdatosdePersonalesPOS() {
        datosPersonalesPage.DatosPersonalesPOS();
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
}

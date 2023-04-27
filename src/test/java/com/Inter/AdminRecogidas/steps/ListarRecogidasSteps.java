package com.Inter.AdminRecogidas.steps;

import com.Inter.AdminRecogidas.pageObjects.ListadoTusRecogidas;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class ListarRecogidasSteps extends PageObject {

    ListadoTusRecogidas listadoTusRecogidas = new ListadoTusRecogidas();

    @Step
    public void BuscarIDrecogida() {
        listadoTusRecogidas.filtrarporId();
    }

    @Step
    public void filtradoIdexitoso() {
        listadoTusRecogidas.filtrarIdexitoso();
    }

    @Step
    public void filtrarEstado(String estado) {
        listadoTusRecogidas.filtrarestado(estado);
    }

    @Step
    public void filtrarEstadoexitoso(String estado) {
        listadoTusRecogidas.filtrarestadoexitoso(estado);
    }

    @Step
    public void cancelarrecogidalistado(){
        listadoTusRecogidas.cancelorecogidalis();
    }

}

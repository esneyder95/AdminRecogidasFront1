package com.Inter.AdminRecogidas.steps;

import com.Inter.AdminRecogidas.pageObjects.*;
import net.thucydides.core.annotations.Step;
import java.io.IOException;

public class PreenviosSteps {
    CotizaciondeenviosPage cotizaciondeenviosPage = new CotizaciondeenviosPage();
    DatosDestinatario datosDestinatario = new DatosDestinatario();
    PreenvioExitoso PreenvioExitoso = new PreenvioExitoso();
    ListadoTusRecogidas listadoTusRecogidas = new ListadoTusRecogidas();

    @Step
    public void opciondeAgregarenvios(){
        listadoTusRecogidas.AgregarPreenvio();
    }

    @Step
   public void informaciondecotizacion(String dato){
        if (dato.equals("carguedatos")){
            cotizaciondeenviosPage.Cotizatuenvio("carguedatos");
        }else {
            cotizaciondeenviosPage.Cotizatuenvio("");
        }
    }

    @Step
    public void regresopreenvio(){
        cotizaciondeenviosPage.RegresoCotizaEnvio();
    }
    @Step
    public void regresopreenviodestinatario(){
        datosDestinatario.regresodestinatario();
    }
    @Step
    public void regresoexitoso(){
        listadoTusRecogidas.regrezoExitoso();
    }

    @Step
   public void informaciondedestinatario(){
        datosDestinatario.datoaDestinatario();
    }
    @Step
    public void informaciondedestinatariocongeo(){
        datosDestinatario.datoaDestinatariocongeo();
    }
    @Step
    public void informaciondedestinatariosingeo(){
        datosDestinatario.datoDestinatariosingeo();
    }

    @Step
    public void SolicitudPrenvioExitosa(){
        PreenvioExitoso.preenvioexitoso();
    }

    @Step
    public void SolicitudNuevoPrenvioExitoso() throws IOException {
        PreenvioExitoso.preenvioAfectacion();
    }

    @Step
    public void SolicitudPrenvioExitoso() throws IOException {
        PreenvioExitoso.preenvioexitosonuevo();
    }

    @Step
    public void cotizaEnviocontado(){
        cotizaciondeenviosPage.CotizatuenvioAfectacion("Contado");
        datosDestinatario.datosDestinatarioafectacion("Contado");
    }

    @Step
    public void cotizaEnvioPagoEnCasa(){
        cotizaciondeenviosPage.CotizatuenvioAfectacion("PagoEnCasa");
        datosDestinatario.datosDestinatarioafectacion("PagoEnCasa");
    }

    @Step
    public void cotizaEnvioAlCrobro(){
        cotizaciondeenviosPage.CotizatuenvioAfectacion("AlCobro");
        datosDestinatario.datosDestinatarioafectacion("AlCrobro");
    }

    @Step
    public void cotizaEnvioConvenio(){
        cotizaciondeenviosPage.CotizatuenvioAfectacion("Convenio");
        datosDestinatario.datosDestinatarioafectacion("Convenio");
    }
    @Step
    public void envioexitosoafectacionPOS() throws IOException {
        PreenvioExitoso.preenvioAfectacionPOS();
    }

    @Step
    public void carguedatadestinatario(){
        datosDestinatario.cargueDataDestinatario();
    }

    @Step
    public void cargueexitosodestinatario(){
        datosDestinatario.cargueexitosodestinatario();
    }

    @Step
    public void actualizarCuenta(){
        cotizaciondeenviosPage.actualizarCuenta();
    }

    @Step
    public void cotizaPagoEnCasa(){
        cotizaciondeenviosPage.pagoencasaactulizocuenta();
    }

    @Step
    public void actualizacuentaexitoso(){
        cotizaciondeenviosPage.cargueexitosoactulizarcuenta();
    }

    @Step
    public void cotizapreenvioAPP(Integer i, String Cedula){
        switch (i){
            case 0: {
                cotizaciondeenviosPage.CotizatuenvioAPP("Contado",Cedula);
                break;
            }
            case 1: {
                cotizaciondeenviosPage.CotizatuenvioAPP("PagoEnCasa",Cedula);
                break;
            }
            case 2: {
                cotizaciondeenviosPage.CotizatuenvioAPP("AlCobro",Cedula);
                break;
            }
            case 3: {
                cotizaciondeenviosPage.CotizatuenvioAPP("Convenio",Cedula);
                break;
            }
        }
    }

    @Step
    public void envioexitosoAPP(String cedula, String celular, String finalizar, String estadoConvenio) throws IOException {
        PreenvioExitoso.preenviosAPP(cedula,celular,finalizar,estadoConvenio);
    }

    @Step
    public void destinatarioAPP(){
        datosDestinatario.datosDestinatarioafectacion("Convenio");
    }
}

package com.Inter.AdminRecogidas.steps;

import com.Inter.AdminRecogidas.pageObjects.DatosRecogidaPage;
import com.Inter.AdminRecogidas.pageObjects.ListadoTusRecogidas;
import com.Inter.AdminRecogidas.pageObjects.PantallaAsociarRecogidas;
import com.Inter.AdminRecogidas.pageObjects.PantallaEditarRecogidasPage;
import com.opencsv.exceptions.CsvValidationException;
import net.thucydides.core.annotations.Step;

import java.io.IOException;

public class EditarRecogidasSteps {

    ListadoTusRecogidas listadoTusRecogidas = new ListadoTusRecogidas();

    PantallaEditarRecogidasPage pantallaEditarRecogidasPage = new PantallaEditarRecogidasPage();

    DatosRecogidaPage datosRecogidaPage = new DatosRecogidaPage();

    PantallaAsociarRecogidas pantallaAsociarRecogidas = new PantallaAsociarRecogidas();

    @Step
    public void editarrecogida() {
        listadoTusRecogidas.EditarRecogida();
    }

    @Step
    public void cancelarrecogida() {
        pantallaEditarRecogidasPage.CancelarRecogida();
    }

    @Step
    public void notificacion() {
        listadoTusRecogidas.MensajeNotificacion();
    }

    @Step
    public void editardatosrecogida(){
        pantallaEditarRecogidasPage.EditarRecogida();
        datosRecogidaPage.EditarDatosRecogida();
    }

    @Step
    public void agregarpreenvio(String preenvio){
        if (preenvio.equals("listado")){
            listadoTusRecogidas.AgregarPreenvio();
        }
        if (preenvio.equals("recogida")){
            pantallaEditarRecogidasPage.AgregarPreenvio();
        }
    }

    @Step
    public void borrarpreenvio(){
        pantallaEditarRecogidasPage.BorrarPreenvio();
    }

    @Step
    public void desasociarpreenvio(){
        pantallaEditarRecogidasPage.DesasociarPreenvio();
    }

    @Step
    public void asociarpreenvio(){
        pantallaAsociarRecogidas.AsociarPreenvio();
    }

    @Step
    public void nuevarecogida(){
        datosRecogidaPage.nuevarecogida();
    }
    @Step
    public void regresarrecogida(){
        datosRecogidaPage.regresarnuevarecogida();
    }

    @Step
    public void regresarrecogidahome(){
        datosRecogidaPage.regresarhome();
    }
}

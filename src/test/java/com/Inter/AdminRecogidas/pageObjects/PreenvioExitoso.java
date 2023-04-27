package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.DataCvs;
import com.Inter.AdminRecogidas.utils.InteractorTime;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PreenvioExitoso extends PageObject {

    DataCvs dataCvs = new DataCvs();
    InteractorTime interactorTime = new InteractorTime();
    public By numerodePreenvio = By.id("IdPreenvio");
    public By cerrar = By.xpath("//div[@class='created-preshipping modal-container container']/div[1]/div[1]/img");
    public By agregarOtroPreenvio = By.id("AgregarPreenvio");
    public By cargando = By.id("cargando");
    WebDriverWait tiempo = new WebDriverWait(getDriver(),30);
    static List<String[]> OustCsv = new ArrayList<String[]>();

    public void preenvioexitoso() {
        try {
            tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
        }catch (Exception e){
            throw new RuntimeException("Error de cargue de agregar envio");
        }
        String texto = getDriver().findElement(numerodePreenvio).getText();
        Long numeropreenvio = Long.parseLong(texto);
        System.out.println("Numero de preenvio: " + numeropreenvio);
        interactorTime.esperaMilis(1000);
        getDriver().findElement(cerrar).click();
        interactorTime.esperaMilis(1000);
        System.out.println("Preenvio exitoso");
    }

    public void preenvioexitosoCvs() {
        try {
            tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
        }catch (Exception e){
            throw new RuntimeException("Error de cargue de agregar envio");
        }
        String texto = getDriver().findElement(numerodePreenvio).getText();
        Long numeropreenvio = Long.parseLong(texto);
        System.out.println("Numero de preenvio: " + numeropreenvio);
        interactorTime.esperaMilis(1000);
        getDriver().findElement(cerrar).click();
        String[] data = new String[]{DataCvs.cedula2(),DataCvs.nombre2(),DataCvs.celular2(),DataCvs.cedulades2(),DataCvs.nombredes2(),
                DataCvs.celulardes2(),"ID - " + PantallaconfirmacionPage.NuRecogida(),texto};
        OustCsv.add(data);
        OustCsv.forEach(System.out::println);
        getDriver().quit();
    }

    public void preenvioAfectacionPOS() throws IOException {
        try {
            tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
        }catch (Exception e){
            throw new RuntimeException("Error de cargue de agregar envio");
        }
        interactorTime.esperaMilis(1000);
        String texto = getDriver().findElement(numerodePreenvio).getText();
        Long numeropreenvio = Long.parseLong(texto);
        System.out.println("Numero de preenvio: " + numeropreenvio);
        interactorTime.esperaMilis(1000);
        getDriver().findElement(cerrar).click();
        String[] data = new String[]{"1024567308","3005761988",DatosDestinatario.cedulaDes,DatosDestinatario.celularDes,
                DatosDestinatario.tipoenvio,CotizaciondeenviosPage.tiposervicio,texto};
        OustCsv.add(data);
        dataCvs.CrearCsv("POS");
    }

    public void preenvioAfectacion() throws IOException {
        try {
            tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
        }catch (Exception e){
            throw new RuntimeException("Error de cargue de agregar envio");
        }
        interactorTime.esperaMilis(1000);
        String texto = getDriver().findElement(numerodePreenvio).getText();
        Long numeropreenvio = Long.parseLong(texto);
        System.out.println("Numero de preenvio: " + numeropreenvio);
        String[] data = new String[]{"1024567308","3005761988",DatosDestinatario.cedulaDes,DatosDestinatario.celularDes,
                DatosDestinatario.tipoenvio,texto};
        OustCsv.add(data);
        dataCvs.CrearCsv("Afectacion");
    }

    public void preenvioexitosonuevo() throws IOException {
        try {
            tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
        }catch (Exception e){
            throw new RuntimeException("Error de cargue de agregar envio");
        }
        interactorTime.esperaMilis(1000);
        String texto = getDriver().findElement(numerodePreenvio).getText();
        Long numeropreenvio = Long.parseLong(texto);
        System.out.println("Numero de preenvio: " + numeropreenvio);
        getDriver().findElement(agregarOtroPreenvio).click();
    }

    public void preenviosAPP(String cedula, String celular, String finalizar, String estadoConvenio) throws IOException {
        try {
            tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
        }catch (Exception e){
            throw new RuntimeException("Error de cargue de agregar envio");
        }
        interactorTime.esperaMilis(1000);
        String texto = getDriver().findElement(numerodePreenvio).getText();
        Long numeropreenvio = Long.parseLong(texto);
        System.out.println("Numero de preenvio: " + numeropreenvio);
        interactorTime.esperaMilis(1000);
        getDriver().findElement(cerrar).click();
        if(finalizar.equals("yes")){
            String[] data = new String[]{"Id - " + PantallaconfirmacionPage.Nrecogida};
            OustCsv.add(data);
        }
    }

    public static ArrayList<String[]> outCsv(){
        return (ArrayList<String[]>) OustCsv;
    }
}

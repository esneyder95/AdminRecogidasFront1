package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.DataCvs;
import com.Inter.AdminRecogidas.utils.InteractorTime;
import com.Inter.AdminRecogidas.utils.ServiciosRandom;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PreenvioExitoso extends PageObject {

    DataCvs dataCvs = new DataCvs();
    InteractorTime interactorTime = new InteractorTime();

    public By numerodePreenvio = By.id("IdPreenvio");

    public By cerrar = By.xpath("//div[@class='created-preshipping modal-container container']/div[1]/div[1]/img");

    public By agregarOtroPreenvio = By.id("AgregarPreenvio");
    static List<String[]> OustCsv = new ArrayList<String[]>();

    public void preenvioexitoso() {
        try {
            String texto = getDriver().findElement(numerodePreenvio).getText();
            Long numeropreenvio = Long.parseLong(texto);
            System.out.println("Numero de preenvio: " + numeropreenvio);
            interactorTime.esperaMilis(3000);
            getDriver().findElement(cerrar).click();
            interactorTime.esperaMilis(5000);
            System.out.println("Preenvio exitoso");
        }catch (Exception e){
            throw new RuntimeException("No se cargo popup de preenvio exitoso");
        }
    }

    public void preenvioexitosoCvs() {
        String texto = getDriver().findElement(numerodePreenvio).getText();
        Long numeropreenvio = Long.parseLong(texto);
        System.out.println("Numero de preenvio: " + numeropreenvio);
        interactorTime.esperaMilis(5000);
        getDriver().findElement(cerrar).click();
        String[] data = new String[]{DataCvs.cedula2(),DataCvs.nombre2(),DataCvs.celular2(),DataCvs.cedulades2(),DataCvs.nombredes2(),
                DataCvs.celulardes2(),"ID - " + PantallaconfirmacionPage.NuRecogida(),texto};
        OustCsv.add(data);
        OustCsv.forEach(System.out::println);
        getDriver().quit();
    }

    public void preenvioAfectacionPOS() throws IOException {
        interactorTime.esperaMilis(10000);
        String texto = getDriver().findElement(numerodePreenvio).getText();
        Long numeropreenvio = Long.parseLong(texto);
        System.out.println("Numero de preenvio: " + numeropreenvio);
        interactorTime.esperaMilis(5000);
        getDriver().findElement(cerrar).click();
        String[] data = new String[]{"1024567308","3005761988",DatosDestinatario.cedulaDes,DatosDestinatario.celularDes,
                DatosDestinatario.tipoenvio,CotizaciondeenviosPage.tiposervicio,texto};
        OustCsv.add(data);
        dataCvs.CrearCsv("POS");
    }

    public void preenvioAfectacion() throws IOException {
        interactorTime.esperaMilis(10000);
        String texto = getDriver().findElement(numerodePreenvio).getText();
        Long numeropreenvio = Long.parseLong(texto);
        System.out.println("Numero de preenvio: " + numeropreenvio);
        String[] data = new String[]{"1024567308","3005761988",DatosDestinatario.cedulaDes,DatosDestinatario.celularDes,
                DatosDestinatario.tipoenvio,texto};
        OustCsv.add(data);
        dataCvs.CrearCsv("Afectacion");
    }

    public void preenviosAPP(String cedula, String celular, String finalizar, String estadoConvenio) throws IOException {
        String texto = getDriver().findElement(numerodePreenvio).getText();
        Long numeropreenvio = Long.parseLong(texto);
        System.out.println("Numero de preenvio: " + numeropreenvio);
        interactorTime.esperaMilis(5000);
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

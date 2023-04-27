package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.DataCvs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.Inter.AdminRecogidas.utils.InteractorTime;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class PantallaconfirmacionPage extends PageObject {

    static List<String[]> OustCsv = new ArrayList<String[]>();
    static String Nrecogida;
    public By numerodeRecogida = By.id("NuevaRecogida");
    public By agregarPreenvio = By.xpath("//a[@class='btn-default']");
    public By cerrar = By.xpath("//div[@class='top-section']/div[1]/a[1]/img");
    public By cargando = By.id("cargando");
    WebDriverWait tiempo = new WebDriverWait(getDriver(),30);

    public void formularioexitoso() {
        try {
            tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
        }catch (Exception e){
            throw new RuntimeException("Error de cargue popup nueva recogida");
        }
        String texto = getDriver().findElement(numerodeRecogida).getText();
        Integer numeroradicado = Integer.parseInt(texto);
        System.out.println("Numero de Recogida: " + numeroradicado);
        getDriver().findElement(cerrar).click();
    }
    public void formularioexitosonuevoprenvio() {
        try {
            tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
        }catch (Exception e){
            throw new RuntimeException("Error de cargue popup nuevo preenvio");
        }
        WebElement TxtBoxContent = getDriver().findElement(numerodeRecogida);
        String texto = TxtBoxContent.getText();
        Integer numeroradicado = Integer.parseInt(texto);
        System.out.println("Numero de radicado: " + numeroradicado);
        getDriver().findElement(agregarPreenvio).click();
    }
    public void formularioexitosoCsv(String Dato) {
        try {
            tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
        }catch (Exception e){
            throw new RuntimeException("Error de cargue popup nueva recogida");
        }
        WebElement TxtBoxContent = getDriver().findElement(numerodeRecogida);
        String texto = TxtBoxContent.getText();
        Integer numeroradicado = Integer.parseInt(texto);
        System.out.println("Numero de radicado: " + numeroradicado);
        if (Dato.equals("Recogida")){
            String[] data = new String[]{DataCvs.cedula2(),DataCvs.nombre2(),DataCvs.celular2(),texto};
            OustCsv.add(data);
            OustCsv.forEach(System.out::println);
            getDriver().quit();
        }else {
            Nrecogida = texto;
            getDriver().findElement(agregarPreenvio).click();
        }
    }

    public void recogidaexitosaAPP() {
        try {
            tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
        }catch (Exception e){
            throw new RuntimeException("Error de cargue popup nueva recogida");
        }
        WebElement TxtBoxContent = getDriver().findElement(numerodeRecogida);
        String texto = TxtBoxContent.getText();
        Integer numeroradicado = Integer.parseInt(texto);
        System.out.println("Numero de Recogida: " + numeroradicado);
        Nrecogida = texto;
        getDriver().findElement(cerrar).click();
    }

    public static ArrayList<String[]> outCsv(){
        return (ArrayList<String[]>) OustCsv;
    }

    public static String NuRecogida(){
        String NumRecogida = Nrecogida;
        return NumRecogida;
    }
}

package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.DataCvs;
//import org.jruby.RubyProcess;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.Inter.AdminRecogidas.utils.InteractorTime;
import net.serenitybdd.core.pages.PageObject;
import java.util.ArrayList;
import java.util.List;

public class PantallaconfirmacionPage extends PageObject {
    InteractorTime interactorTime = new InteractorTime();

    //static List<String> OutCsv = new ArrayList<String>();
    static List<String[]> OustCsv = new ArrayList<String[]>();
    static String Nrecogida;

    public By numerodeRecogida = By.id("NuevaRecogida");
    public By agregarPreenvio = By.xpath("//a[@class='btn-default']");
    public By cerrar = By.xpath("//div[@class='top-section']/div[1]/img");


    public void formularioexitoso() {
        try{
            WebElement TxtBoxContent = getDriver().findElement(numerodeRecogida);
            String texto = TxtBoxContent.getText();
            Integer numeroradicado = Integer.parseInt(texto);
            System.out.println("Numero de Recogida: " + numeroradicado);
            getDriver().findElement(cerrar).click();
            interactorTime.esperaMilis(5000);
        }catch (Exception e){
            throw new RuntimeException("No se cargo popup de verificación de recogida");
        }
    }
    public void formularioexitosonuevoprenvio() {
        try{
            WebElement TxtBoxContent = getDriver().findElement(numerodeRecogida);
            String texto = TxtBoxContent.getText();
            Integer numeroradicado = Integer.parseInt(texto);
            System.out.println("Numero de radicado: " + numeroradicado);
            getDriver().findElement(agregarPreenvio).click();
            interactorTime.esperaMilis(10000);
        }catch (Exception e) {
            throw new RuntimeException("No se cargó pagina de confirmacion de recogida");
        }
    }
    public void formularioexitosoCsv(String Dato) {
        try{
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
        }catch (Exception e){
            System.out.println("No se encontró N de recogida");
            String[] data = new String[]{DataCvs.cedula2(),DataCvs.nombre2(),"Error en la ejecucion"};
            OustCsv.add(data);
            OustCsv.forEach(System.out::println);
            getDriver().quit();
        }
    }

    public void recogidaexitosaAPP() {
        try{
            WebElement TxtBoxContent = getDriver().findElement(numerodeRecogida);
            String texto = TxtBoxContent.getText();
            Integer numeroradicado = Integer.parseInt(texto);
            System.out.println("Numero de Recogida: " + numeroradicado);
            Nrecogida = texto;
            getDriver().findElement(cerrar).click();
            interactorTime.esperaMilis(5000);
        }catch (Exception e){
            throw new RuntimeException("No se cargo popup de verificación de recogida");
        }
    }

    public static ArrayList<String[]> outCsv(){
        return (ArrayList<String[]>) OustCsv;
    }

    public static String NuRecogida(){
        String NumRecogida = Nrecogida;
        return NumRecogida;
    }
}

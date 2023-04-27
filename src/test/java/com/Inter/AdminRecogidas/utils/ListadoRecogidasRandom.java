package com.Inter.AdminRecogidas.utils;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ListadoRecogidasRandom extends PageObject {

    InteractorTime interactorTime = new InteractorTime();
    public By recogida1 = By.xpath("//div[@name='registros']/ul[1]/li[1]");
    public By recogida2 = By.xpath("//div[@name='registros']/ul[2]/li[1]");
    public By recogida3 = By.xpath("//div[@name='registros']/ul[3]/li[1]");
    public By recogida4 = By.xpath("//div[@name='registros']/ul[4]/li[1]");
    public By recogida5 = By.xpath("//div[@name='registros']/ul[5]/li[1]");
    public By recogida6 = By.xpath("//div[@name='registros']/ul[6]/li[1]");
    public By recogida7 = By.xpath("//div[@name='registros']/ul[7]/li[1]");
    public By recogida8 = By.xpath("//div[@name='registros']/ul[8]/li[1]");
    public By recogida9 = By.xpath("//div[@name='registros']/ul[9]/li[1]");
    public By recogida10 = By.xpath("//div[@name='registros']/ul[10]/li[1]");
    public By paginacion = By.xpath("//div[@name='paginador']/div/p[2]");
    public By Btnpaginacion = By.xpath("//div[@name='paginador']/div/a[2]");
    static String Idrecogida = "";

    public void contarrecogidas(){
        int Npagina = 0;
        try {
            String[] parts = getDriver().findElement(paginacion).getText().split(" ");
            String Npoaginastr = parts[1];
            Npagina = Integer.parseInt(Npoaginastr);
            int lpagina = (int) (1 + (Math.random() * Npagina));
            switch (lpagina){
                case 1: {
                    interactorTime.esperaMilis(1000);
                    break;
                }
                case 2: {
                    getDriver().findElement(Btnpaginacion).click();
                    interactorTime.esperaMilis(1000);
                    break;
                }
                case 3: {
                    getDriver().findElement(Btnpaginacion).click();
                    interactorTime.esperaMilis(1000);
                    getDriver().findElement(Btnpaginacion).click();
                    interactorTime.esperaMilis(1000);
                    break;
                }
                case 4: {
                    getDriver().findElement(Btnpaginacion).click();
                    interactorTime.esperaMilis(1000);
                    getDriver().findElement(Btnpaginacion).click();
                    interactorTime.esperaMilis(1000);
                    getDriver().findElement(Btnpaginacion).click();
                    interactorTime.esperaMilis(1000);
                    break;
                }
                default: {
                    getDriver().findElement(Btnpaginacion).click();
                    interactorTime.esperaMilis(1000);
                    getDriver().findElement(Btnpaginacion).click();
                    interactorTime.esperaMilis(1000);
                    getDriver().findElement(Btnpaginacion).click();
                    interactorTime.esperaMilis(1000);
                    getDriver().findElement(Btnpaginacion).click();
                    interactorTime.esperaMilis(1000);
                    break;
                }
            }
        }catch (NoSuchElementException exception){
            System.out.println("Esta lista no necesita paginacion");
        }
        int i = 0;
        try {
            getDriver().findElement(recogida1).isDisplayed();
            i++;
            getDriver().findElement(recogida2).isDisplayed();
            i++;
            getDriver().findElement(recogida3).isDisplayed();
            i++;
            getDriver().findElement(recogida4).isDisplayed();
            i++;
            getDriver().findElement(recogida5).isDisplayed();
            i++;
            getDriver().findElement(recogida6).isDisplayed();
            i++;
            getDriver().findElement(recogida7).isDisplayed();
            i++;
            getDriver().findElement(recogida8).isDisplayed();
            i++;
            getDriver().findElement(recogida9).isDisplayed();
            i++;
            getDriver().findElement(recogida10).isDisplayed();
            i++;
        }catch (NoSuchElementException exception){
            System.out.println("Se encontraron " + i + " recogidas");
        }
        int longitud = (int) (1 + (Math.random() * i));
        switch (longitud){
            case 1: {
                WebElement textoIdrecogida = getDriver().findElement(By.xpath("//div[@name='registros']/ul[1]/li[1]"));
                Idrecogida = textoIdrecogida.getText();
                break;
            }
            case 2: {
                WebElement textoIdrecogida = getDriver().findElement(By.xpath("//div[@name='registros']/ul[2]/li[1]"));
                Idrecogida = textoIdrecogida.getText();
                break;
            }
            case 3: {
                WebElement textoIdrecogida = getDriver().findElement(By.xpath("//div[@name='registros']/ul[3]/li[1]"));
                Idrecogida = textoIdrecogida.getText();
                break;
            }
            case 4: {
                WebElement textoIdrecogida = getDriver().findElement(By.xpath("//div[@name='registros']/ul[4]/li[1]"));
                Idrecogida = textoIdrecogida.getText();
                break;
            }
            case 5: {
                WebElement textoIdrecogida = getDriver().findElement(By.xpath("//div[@name='registros']/ul[5]/li[1]"));
                Idrecogida = textoIdrecogida.getText();
                break;
            }
            case 6: {
                WebElement textoIdrecogida = getDriver().findElement(By.xpath("//div[@name='registros']/ul[6]/li[1]"));
                Idrecogida = textoIdrecogida.getText();
                break;
            }
            case 7: {
                WebElement textoIdrecogida = getDriver().findElement(By.xpath("//div[@name='registros']/ul[7]/li[1]"));
                Idrecogida = textoIdrecogida.getText();
                break;
            }
            case 8: {
                WebElement textoIdrecogida = getDriver().findElement(By.xpath("//div[@name='registros']/ul[8]/li[1]"));
                Idrecogida = textoIdrecogida.getText();
                break;
            }
            case 9: {
                WebElement textoIdrecogida = getDriver().findElement(By.xpath("//div[@name='registros']/ul[9]/li[1]"));
                Idrecogida = textoIdrecogida.getText();
                break;
            }
            case 10: {
                WebElement textoIdrecogida = getDriver().findElement(By.xpath("//div[@name='registros']/ul[10]/li[1]"));
                Idrecogida = textoIdrecogida.getText();
                break;
            }
        }
    }

    public static String IdlistadoRecogida(){
        return Idrecogida;
    }

}

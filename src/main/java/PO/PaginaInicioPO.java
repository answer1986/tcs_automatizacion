package PO;

import io.github.sukgu.Shadow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaInicioPO extends UtilPage {
    public PaginaInicioPO (WebDriver driver){
        super(driver);
    }
    Shadow shadow = new Shadow(driver);
    /**poUp**/
    @FindBy (id = "onesignal-slidedown-cancel-button") WebElement btnNoGracias;
    /****/
    @FindBy (xpath = "(//div[contains(@class,'link-to-application')])[1]") WebElement reservaTuVuelo;
    @FindBy (id ="compra-select-origin") WebElement ciudadOrigen;
    @FindBy (id ="ui-id-1") WebElement primeraCiudadSalida;
    @FindBy (id = "compra-select-destination") WebElement ciudadDestino;
    @FindBy (id ="ui-id-2") WebElement primeraCiudadDestino;
    @FindBy (xpath = "//button[contains(text(),'Busca tu vuelo')]") WebElement btnBuscatuVuelo;

    /**Fecha**/
    @FindBy (xpath = "(//div[contains(@class,'flight-date-group')]//fieldset//label[contains(text(),'')])[2]") WebElement tipoVuelo;
    @FindBy (xpath = "(//input[contains(@inputmode,'numeric')])[1]") WebElement fechaIda;
    @FindBy (xpath = "//div[contains(@class,'ui-datepicker-group ui-datepicker-group-first')]//td[contains(@data-event,'click')]//a[contains(text(),'12')]") WebElement diaIda;
    @FindBy (xpath = "(//input[contains(@inputmode,'numeric')])[2]") WebElement fechaVuelta;
    @FindBy (xpath = "//div[contains(@class,'ui-datepicker-group ui-datepicker-group-last')]//td[contains(@data-event,'click')]//a[contains(text(),'20')]") WebElement diaVuelta;

    public void ingreso(String url){
        driver.get(url);
        try {
            waitFor(8);//espera de 8 segundos
            WebElement btnNoGracias = shadow.findElement("button[id='onesignal-slidedown-cancel-button']");
            btnNoGracias.click();
            if (isVisible(reservaTuVuelo)) {
                Log("La pagina se carga de forma exitosa");
            } else {
                Log("Se produjo un erro");
                driver.close();
            }
        }catch (Exception e){
            System.out.println("El error es  : " + e);

        }
    }
    public void ingresoOrigen(String CO){
        waitForElementToAppear(ciudadOrigen);
        if (isVisible(ciudadOrigen)){
            ciudadOrigen.click();
            ciudadOrigen.sendKeys(CO);
            waitFor(2);
            String ciudad = primeraCiudadSalida.getText();
            Log(ciudad);
            Log("Seleccionamos la primera cidad " + ciudad);
            primeraCiudadSalida.click();

        }

    }
    public void ingresoDestino (String CD) {
        waitForElementToAppear(ciudadDestino);
        if (isVisible(ciudadDestino)) {
            ciudadDestino.click();
            ciudadDestino.sendKeys(CD);
            waitFor(2);
            String ciudad = primeraCiudadDestino.getText();
            Log("Seleccionamos la primera cidad destino " + ciudad);
            primeraCiudadDestino.click();

        }
    }

    public void fechaIda(){
        fechaIda.click();
        waitFor(1);
        waitForElementToAppear(diaIda);
        if (isVisible(diaIda)){
            diaIda.click();
        }else{}


    }
    public void fechavuelta(){
        fechaVuelta.click();
        waitFor(2);
        diaVuelta.click();

    }
    public void btnCont(){
        waitFor(2);
        btnBuscatuVuelo.click();

    }
}

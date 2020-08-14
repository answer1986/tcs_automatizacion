package PO;

import io.github.sukgu.Shadow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SegundapagePO extends UtilPage {
    public SegundapagePO (WebDriver driver){
        super(driver);
    }
    Shadow shadow = new Shadow(driver);
    @FindBy (xpath = "//span[contains(@class,'close')]")
    WebElement closMen;
    @FindBy (xpath = "//tbody//td//button[contains(@class,'price-matrix-cell')]") WebElement Precios;
    @FindBy (xpath = "//button//span[contains(text(),'Confirmar fecha')]") WebElement btnConfirmarFecha;
    @FindBy (xpath = "//div[contains(@class,'flight-summary-schedule')]") WebElement btnhoras;
    @FindBy (xpath = "//div//thead//tr//th[contains(@class,'fare-LIGHT selected')]") WebElement btnLight;
    @FindBy (xpath = "//button[contains(text(),'Continuar')]") WebElement btnContinuar;
    @FindBy (xpath = "//button[contains(text(),'Confirmar')]") WebElement btnConfirmar;
    @FindBy (xpath = "//section[contains(@class,'step-bar')]") WebElement terceraPeage;

    public void precios() throws Exception {
        waitFor(40);

        waitFor(5);
        Precios.click();
        CapturaImagen(driver, "Error carga imagenes");
        btnConfirmarFecha.click();
        waitFor(1);
        btnhoras.click();
        waitFor(1);
        btnLight.click();
        btnContinuar.click();
        waitFor(5);
        btnhoras.click();
        waitFor(1);
        btnConfirmar.click();



    }
    public void confirmacionPage(){
        waitFor(5);
        Log(terceraPeage.getText());
        driver.quit();
    }

}

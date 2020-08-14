import Utils.DatosSistemaTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static Utils.testMethods.takeSnapShot;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class F10_DCP0001 {

    String log4jConfPath = "./src/test/resources/log4j.properties";
    WebDriver driver;

    @BeforeAll
    public void SetUp() {
        PropertyConfigurator.configure(log4jConfPath);
        System.setProperty("java.net.useSystemProxies", "true");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://google.cl");
    }

    @AfterAll
    public void tear(){
        driver.close();
    }

    @AfterEach
    public void afterEach(TestInfo testinfo) throws Exception {
        takeSnapShot(this.driver, this.getClass().getName()+"-"+testinfo.getDisplayName());
    }

    @Test
    @Order(1)
    public void Paso1() {
        System.out.println("paso 1");
    }

    @Test
    @Order(2)
    public void Paso2() {
        System.out.println("paso 2");
    }

    @Test
    @Order(3)
    public void Paso3(){
        System.out.println("paso 3");
    }

    @Test
    @Order(4)
    public void Paso4(){
        System.out.println("paso 4");
    }
}

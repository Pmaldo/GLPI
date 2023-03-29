
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class Test_LoginGlpi {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeClass
    public static void setupWebdriverChromeDriver() {
        // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        // for Firefox
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver.exe");
    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLoginGlpi() {
        driver.get("http://epsiprojet.infinityfreeapp.com/glpi_10_0_6/index.php");
 //       driver.manage().window().setSize(new Dimension(961, 803));
 //        driver.findElement(By.name("fieldb64102e9683764")).sendKeys("Grazerty22!");

        driver.findElement(By.id("login_name")).sendKeys("epsiprojet");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Grazerty22!");
        driver.findElement(By.name("submit")).click();

        /*
        // Autre méthode pour la gestion login/passwd :
        WebElement loginBox = driver.findElement(By.id("login_name"));
        WebElement passwordBox = driver.findElement(By.cssSelector("input[type='password']"));

        loginBox.sendKeys("FrLe");
        passwordBox.sendKeys("FrLe01$");
        */

        // Pour afficher un message d'erreur explicite si erreur dans l'URL :
        assertEquals(
                "Validate end URL",
        //        "http://epsiprojet.infinityfreeapp.com/glpi_10_0_6/front/central.php",
				"http://epsiprojet.infinityfreeapp.com/glpi_10_0_6/index.php"
                driver.getCurrentUrl()
        );

       /*
       // Ce code fonctionne mais ne donne pas l'erreur s'il y en a une :
        assertThat(
                "Validate end URL",
                driver.getCurrentUrl().equals("http://epsiprojet.infinityfreeapp.com/glpi_10_0_6/front/central.php")
        );
        */
    }
}

package com.example.epsiprojet;

import com.example.epsiprojet.TestingUtils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TestImplementation {
    private WebDriver driver;
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
        System.setProperty(
                "webdriver.gecko.driver",
                System.getProperty("user.dir") + "/src/test/resources/geckodriver.exe"
        );
    }

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        WebDriverRunner.setWebDriver(driver);
        open("http://epsiprojet.infinityfreeapp.com/glpi_10_0_6/");
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void canReachLoginPage() {
        $("form[action='/glpi_10_0_6/front/login.php']").shouldBe(visible);
    }

    @Test
    public void successfulLogin() {
        TestingUtils.logInProcedure(driver);
        TestingUtils.pause(1);
        assertEquals(
            "http://epsiprojet.infinityfreeapp.com/glpi_10_0_6/front/central.php",
            driver.getCurrentUrl(),
            "Dashboard should be reached"
        );
    }


    /*
    @Test
    public void navigationToAllTools() {
        mainPage.seeDeveloperToolsButton.click();
        mainPage.findYourToolsButton.click();

        $("#products-page").shouldBe(visible);

        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
    }
    */
}

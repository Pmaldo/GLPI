package com.example.epsiprojet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class TestingUtils {
    public static void logInProcedure(WebDriver driver) {
        WebElement loginBox = driver.findElement(By.id("login_name"));
        WebElement passwordBox = driver.findElement(By.cssSelector("input[type='password']"));

        loginBox.sendKeys("epsiprojet");
        passwordBox.sendKeys("Grazerty22!");

        driver.findElement(By.name("submit")).click();
    }

    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

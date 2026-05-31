package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class App {
    public static void main(String[] args) {
        System.out.println("--- Task 1: Password Generator ---");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get("https://www.calculator.net/password-generator.html");
            WebElement pwdElement = driver.findElement(By.id("password"));
            System.out.println("Generated Password: " + pwdElement.getAttribute("value"));
        } catch (Exception e) {
            System.out.println("Error in Task 1: " + e.toString());
        } finally {
            driver.quit();
        }

        System.out.println("\n--- Task 2: IP Address ---");
        Task2.getIpAddress();

        System.out.println("\n--- Task 3: Weather Forecast ---");
        Task3.getWeatherForecast();
    }
}

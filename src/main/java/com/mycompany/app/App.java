package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class App {
    public static void main(String[] args) {
        System.out.println("--- Task 1: Password Generator (Selenium) ---");
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-allow-origins=*");

            WebDriver driver = new ChromeDriver(options);
            try {
                driver.get("https://www.calculator.net/password-generator.html");
                Thread.sleep(3000);
                WebElement pwdElement = driver.findElement(By.id("password"));
                String password = pwdElement.getAttribute("value");
                System.out.println("Generated Password: " + password);
            } finally {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Task 1 skipped (Selenium not available): " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Task 2: IP Address ---");
        Task2.run();

        System.out.println();
        System.out.println("--- Task 3: Weather Forecast ---");
        Task3.run();
    }
}

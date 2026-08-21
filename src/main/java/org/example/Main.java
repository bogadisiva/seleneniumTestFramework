package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        // Must match this exact key string literal
//        System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

//        WebDriver driver = new ChromeDriver();
//        driver.get("https://google.com");

        // Set the path using the Service builder
//        ChromeDriverService service = new ChromeDriverService.Builder()
//                .usingDriverExecutable(new File("C:/path/to/chromedriver.exe"))
//                .build();
//
//        WebDriver driver = new ChromeDriver(service);
//        driver.get("https://google.com");

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://talentcentral-dev-v2.altimetrik.com/");
        driver.quit();




    }
}
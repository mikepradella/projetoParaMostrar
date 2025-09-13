package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        // Configura automaticamente o ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Cria uma instância do navegador
        WebDriver driver = new ChromeDriver();

        // Maximiza a janela
        driver.manage().window().maximize();

        // Abre o site do Santander
        driver.get("https://demo.nopcommerce.com//");




        // Localiza o campo pelo ID e envia texto
        WebElement campoBusca = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));
        campoBusca.click();


        WebElement desktop = driver.findElement(By.cssSelector("#main > div > div.center-2 > div > div.page-body > div.category-grid.sub-category-grid > div > div:nth-child(1) > div > div > a > img"));
        desktop.click();



        // Exibe o título da página
        System.out.println("Título da página: " + driver.getTitle());




        // Fecha o navegador
         driver.quit();
    }
}
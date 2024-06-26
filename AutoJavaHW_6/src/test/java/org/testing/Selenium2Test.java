package org.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Selenium2Test {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testPageElements() {
        driver.get("https://quotes.toscrape.com/");

        List<WebElement> firstQuoteTags = driver.findElements(By.cssSelector(".quote .tags .tag"));
        assertFalse(firstQuoteTags.isEmpty(), "Теги першої цитати мають бути присутні на сторінці");

        WebElement nextButton = driver.findElement(By.cssSelector(".next a"));
        assertNotNull(nextButton, "Кнопка 'Next' має бути присутня на сторінці");

        List<WebElement> quotes = driver.findElements(By.className("quote"));
        assertFalse(quotes.isEmpty(), "Цитати мають бути присутні на сторінці");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}


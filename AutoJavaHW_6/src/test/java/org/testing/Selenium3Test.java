package org.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Selenium3Test {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testSecondQuoteElements() {
        driver.get("https://quotes.toscrape.com/");

        WebElement secondQuote = driver.findElements(By.cssSelector(".quote .text")).get(1);
        assertNotNull(secondQuote, "Друга цитата має бути присутня на сторінці");
        assertEquals("“It is our choices, Harry, that show what we truly are, far more than our abilities.”", secondQuote.getText());

        WebElement secondAuthor = driver.findElements(By.cssSelector(".quote .author")).get(1);
        assertNotNull(secondAuthor, "Автор другої цитати має бути присутній на сторінці");
        assertEquals("J.K. Rowling", secondAuthor.getText());

        List<WebElement> secondQuoteTags = driver.findElements(By.cssSelector(".quote")).get(1).findElements(By.cssSelector(".tags .tag"));
        assertFalse(secondQuoteTags.isEmpty(), "Теги другої цитати мають бути присутні на сторінці");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}


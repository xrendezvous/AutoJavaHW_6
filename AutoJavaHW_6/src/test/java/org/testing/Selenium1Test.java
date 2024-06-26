package org.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Selenium1Test {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testPageElements() {
        driver.get("https://quotes.toscrape.com/");

        WebElement nextButton = driver.findElement(By.cssSelector(".next a"));
        assertThat(nextButton).isNotNull();

        WebElement firstQuote = driver.findElement(By.cssSelector(".quote .text"));
        assertThat(firstQuote).isNotNull();
        assertThat(firstQuote.getText()).isEqualTo("“The world as we have created it is a process of our thinking. It cannot be changed without changing our thinking.”");

        WebElement firstAuthor = driver.findElement(By.cssSelector(".quote .author"));
        assertThat(firstAuthor).isNotNull();
        assertThat(firstAuthor.getText()).isEqualTo("Albert Einstein");

        WebElement topTenTagsHeader = driver.findElement(By.cssSelector("h2"));
        assertThat(topTenTagsHeader).isNotNull();
        assertThat(topTenTagsHeader.getText()).isEqualTo("Top Ten tags");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}



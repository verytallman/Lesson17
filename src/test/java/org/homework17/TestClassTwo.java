package org.homework17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClassTwo extends BaseTest{

    @Test
    public void SearchForMatrixMovie() {
        driver.get("https://rezka.ag/");
        WebElement search = driver.findElement(new By.ByXPath("//input[@id='search-field']"));
        search.sendKeys("Матрица");
        search.sendKeys(Keys.RETURN);
        Assert.assertEquals("Поиск по сайту",driver.getTitle());
        WebElement chooseFilm = driver.findElement(new By.ByXPath(
                "//body/div[@id='wrapper']/div[@id='main']/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/i[1]"));
        chooseFilm.click();
        Assert.assertEquals("https://rezka.ag/films/fiction/981-matrica-1999.html",driver.getCurrentUrl());
    }

    @Test
    public void WatchATrailer() throws InterruptedException {
        driver.get("https://rezka.ag/films/fiction/981-matrica-1999.html");
        WebElement watchTrailer = driver.findElement
                (new By.ByXPath("//body/div[@id='wrapper']/div[@id='main']/div[4]/div[1]/div[2]/div[1]/div[3]/div[1]/a[1]"));
        watchTrailer.click();
        Assert.assertEquals("Смотреть фильм Матрица онлайн бесплатно в хорошем качестве",driver.getTitle());
        Thread.sleep(10000);
    }
}

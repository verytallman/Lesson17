package org.homework17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClassOne extends BaseTest{

    @Test
    public void gameSearch(){
        driver.get("https://steampowered.com/");
        WebElement searchField = driver.findElement(new By.ByXPath("//input[@id='store_nav_search_term']"));
        searchField.click();
        searchField.sendKeys("Red Dead Redemption 2");
        searchField.sendKeys(Keys.RETURN);
        Assert.assertEquals("Поиск Steam",driver.getTitle());
        WebElement price = driver.findElement(new By.ByXPath("//strike[contains(text(),'899₴')]"));
        price.click();
        Assert.assertEquals("Сэкономьте 50% при покупке Red Dead Redemption 2 в Steam",driver.getTitle());
    }

    @Test
    public void purchaseForYourself(){
        driver.get("https://store.steampowered.com/app/1174180/Red_Dead_Redemption_2/");
        WebElement buyButton = driver.findElement(new By.ByXPath("//a[@id='btn_add_to_cart_402134']"));
        buyButton.click();
        WebElement buyForYourself = driver.findElement(new By.ByXPath("//a[@id='btn_purchase_self']"));
        buyForYourself.click();
        Assert.assertEquals("Войти",driver.getTitle());
    }
}

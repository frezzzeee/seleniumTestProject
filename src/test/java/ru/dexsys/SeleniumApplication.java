package ru.dexsys;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.main;

public class SeleniumApplication {
    //Тестируется добавление в корзину Процессора AMD Athlon X4 840 OEM со страницы товара
    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver.exe");
        WebDriverManager.chromedriver().setup();

    }

    @Test
    public void TitleTest() {
        WebDriver driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.webDriver.get("https://technopoint.ru/");
        mainPage.clickToPcComponents();
        mainPage.clickToNBasic();
        mainPage.clickToProcessors();
        //Сохраняем имя выбранного товара
        String name = mainPage.gettingProduct();
        //Кликаем на выбранный товар
        mainPage.clickToAmd();
        //Жмем кнопку купить
        mainPage.clickToBuy();
        //Переходим в корзину
        mainPage.clickToCart();
        //Выбирем имя товара в корзине
        String compareName = mainPage.gettingProductName();
        //Сравниваем имена товаров в корзине и сохраненное ранее
        Assert.assertEquals(name, compareName);
        mainPage.webDriver.close();
    }

    //Тестируется добавление в корзину Процессора AMD Athlon X4 840 OEM со страницы списка товаров
    @Test
    public void ItemListTest() {
        start();
        /*System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver.exe");
        WebDriverManager.chromedriver().setup();*/
        WebDriver driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.webDriver.get("https://technopoint.ru/");
        mainPage.clickToPcComponents();
        mainPage.clickToNBasic();
        mainPage.clickToProcessors();
        //Сохраняем имя выбранного товара
        String name = mainPage.gettingProduct();
        //Жмем кнопку купить
        mainPage.clickToBuyListButton();
        //Переходим в корзину
        mainPage.clickToCart();
        //Выбирем имя товара в корзине
        String compareName = mainPage.gettingProductName();
        //Сравниваем имена товаров в корзине и сохраненное ранее
        Assert.assertEquals(name, compareName);
        mainPage.webDriver.close();
    }


    /*
     @Test
    public void TitleTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver.exe");
        chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://market.yandex.ru/product--smartfon-samsung-galaxy-m20-32gb/428087007");
        WebElement aim = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div/div/div[2]/div/a/span[1]"));
        WebElement tovar = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div/div/div[1]/div[1]/div/h1"));
        String name = tovar.getText();
        aim.click();
        WebElement reserved = driver.findElement(By.xpath("/html/body/div[1]/div[1]/noindex/div/div/div[2]/div/div[2]/div[1]/a[1]"));
        driver.get("https://market.yandex.ru/my/wishlist?track=head");
        WebElement nameCompare = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div/div[3]/div/div/div/div[3]/div/div[1]/div/h3/a/span"));
        Assert.assertEquals(nameCompare, name);
        System.out.println(nameCompare);
        driver.close();
    }
    */

   /*@Test
    public void Test() {
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.webDriver.get("http://www.guru99.com/live-testing-project.html");
        Assert.assertEquals(mainPage.webDriver.getTitle(), "Live Manual Testing Project: Online Software Testing Practice");
        WebDriverWait webDriverWait = mainPage.webDriverWait;
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("div-gpt-ad-1565016699961-0")));
        mainPage.webDriver.close();
    }*/
}
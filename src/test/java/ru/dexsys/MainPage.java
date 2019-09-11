package ru.dexsys;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    public MainPage(WebDriver driver) {
        webDriver = driver;
        webDriverWait = new WebDriverWait(webDriver, 100);
        PageFactory.initElements(webDriver, this);
    }

    // Комплектующие для ПК
    @FindBy (xpath = "//*[@id=\"menu-catalog\"]/li[3]/a")
        private WebElement comp;
        public void clickToPcComponents() {
            comp.click();
        }
    // Основные комлектующие
    @FindBy (xpath = "/html/body/div[1]/main/div[3]/a[1]")
        private WebElement basic;
        public void clickToNBasic() {
            basic.click();
        }
        //Процессоры
    @FindBy (xpath = "/html/body/div[1]/main/div[3]/a[1]")
        private WebElement processors;
        public void clickToProcessors() {
            processors.click();
        }
        //Процессор AMD Athlon X4 840 OEM
    @FindBy (xpath = "//*[@id=\"catalog-items-page\"]/div[5]/div[2]/div[1]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div/div[2]/div[1]/a")
        private WebElement amd;
        public void clickToAmd() {
            amd.click();
        }
        public String gettingProduct () {
            return amd.getText();
        }
        //Процессор AMD A6-9500 OEM
    @FindBy (xpath = "//*[@id=\"catalog-items-page\"]/div[5]/div[2]/div[1]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div/div[2]/div[1]/a")
        private WebElement amdFail;
        public String gettingProductFail () {
            return amdFail.getText();
        }
        //Кнопка Купить на странице товара
    @FindBy (className = "btn-cart")
    private WebElement buy;
        public WebElement getBuyButton () {
            buy.toString();
            return buy;
        }
        public void clickToBuy() {
        buy.click();
    }
    //Кнопка Корзина
    @FindBy (xpath = "//*[@id=\"header-search\"]/div/div[2]/a[3]")
    private WebElement cart;
        public void clickToCart() {
            cart.click();
    }
    //Имя товара в корзине
    @FindBy (xpath = "/html/body/div[1]/main/div[2]/div[2]/div/div/div[1]/div/div/div/div[2]/div[1]/a")
        private WebElement compareName;
        public String gettingProductName() {
            return compareName.getText();
    }
    @FindBy (xpath = "//*[@id=\"catalog-items-page\"]/div[5]/div[2]/div[1]/div[1]/div[2]/div/div[1]/div/div[1]/div[3]/div[2]/button")
    private WebElement buyButton;
    public void clickToBuyListButton() {
        buyButton.click();
    }
}



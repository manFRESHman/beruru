package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class BeruTests {
    @BeforeMethod
    public void setUp(){
        open("http://beru.ru");
        Configuration.timeout = 8000;
    }

    @AfterMethod
    public void tearDown(){
        $(By.xpath("//*[@title='Мой профиль']")).hover();
        $(By.xpath("//*[@class='header2-user-menu']//*[text() ='Выход']")).shouldBe(Condition.visible).click();
        close();
    }

    @Test
    public void loginTest(){
        StartPage startPage = new StartPage();
        startPage.closePopUp();
        startPage.clickLoginButton();
        Login login = new Login();
        login.enterLogin();
        login.enterPassword();
        startPage.checkMyProfile();
        sleep(3000);
    }

    @Parameters({ "suite-param" })
    @Test
    public void regionTest(@Optional("Хвалынск") String regionName){
        StartPage startPage = new StartPage();
        startPage.closePopUp();
        startPage.regionClick();
        startPage.regionChoose(regionName);
        startPage.regionConfirm();
        startPage.clickLoginButton();
        Login login = new Login();
        login.enterLogin();
        login.enterPassword();
        startPage.Optionsclick();
        startPage.regionCheck();
    }

    @Test
    public void toothbrushTest(){
        StartPage startPage = new StartPage();
        startPage.closePopUp();
        startPage.clickLoginButton();
        Login login = new Login();
        login.enterLogin();
        login.enterPassword();
        startPage.searchToothbrush();
        SearchResults searchResults = new SearchResults();
        searchResults.setLowPrice();
        searchResults.setHighPrice();
        searchResults.showAll();
        searchResults.buy();
        searchResults.toCart();
        Cart cart = new Cart();
        cart.cheskPriceCalculation();
        cart.set10items();
        cart.checkFreeDelivery();
        cart.cheskPriceCalculation();
        cart.deleteToothbrush();
    }
}
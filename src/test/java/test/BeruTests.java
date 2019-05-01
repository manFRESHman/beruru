package test;

//import org.junit.Assert;
//import org.junit.Test;

import org.testng.annotations.Test;
import org.testng.Assert;

import org.openqa.selenium.By;

import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class BeruTests {
    @Test
    public void loginTest(){
        open("http://beru.ru");
        StartPage startPage = new StartPage();
        startPage.closePopUp();
        startPage.clickLoginButton();
        Login login = new Login();
        login.enterLogin();
        login.enterPassword();
        startPage.checkMyProfile();
        sleep(3000);
    }

    String regionName = "Хвалынск";

    @Test
    public void RegionTest(){
        open("http://beru.ru");
        StartPage startPage = new StartPage();
        startPage.closePopUp();
        startPage.regionClick();
        startPage.regionChoose(regionName);
        startPage.regionConfirm();
        startPage.clickLoginButton();
        Login login = new Login();
        login.enterLogin();
        login.enterPassword();
        startPage.regionCheck();
        sleep(3000);
    }

    @Test
    public void ToothbrushTest(){
        open("http://beru.ru");
        StartPage startPage = new StartPage();
        startPage.closePopUp();
        startPage.regionClick();
        startPage.regionChoose(regionName);
        startPage.regionConfirm();
        startPage.clickLoginButton();
        Login login = new Login();
        login.enterLogin();
        login.enterPassword();
        SearchResults searchResults = new SearchResults();
        searchResults.setLowPrice();
        searchResults.setHighPrice();
        searchResults.checkPriceChanges();
        searchResults.buy();
        searchResults.toCart();
        Cart cart = new Cart();
        cart.cheskPriceCalculation();
        cart.set10items();
        cart.checkFreeDelivery();
        cart.cheskPriceCalculation();
    }
}
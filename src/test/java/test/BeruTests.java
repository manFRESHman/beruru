package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;
import org.testng.Assert;

import java.io.File;
//import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.io.IOException;
import java.io.IOException;
//import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import com.codeborne.selenide.testng.ScreenShooter;

@Listeners({TestListener.class})
public class BeruTests {
    @BeforeMethod
    public void setUp() throws Exception {
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
        ScreenShooter.captureSuccessfulTests = true;
        addListener(new EventListener());
        open("http://beru.ru");
        Configuration.timeout = 4000;
    }

    @AfterMethod
    public void tearDown(){
        $(By.xpath("//*[@title='Мой профиль']")).hover();
        $(By.xpath("//*[@class='header2-user-menu']//*[text() ='Выход']")).shouldBe(Condition.visible).click();
        close();
    }

    @DataProvider(name = "region")
    public Object[][] createData(){
        return new Object[][] { { "Хвалынск" }, { "Саратов" } };
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
    }

    @Test(dataProvider = "region")
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
        cart.cheskPriceCalculationBefore();
        cart.set10items();
        cart.checkFreeDelivery();
        cart.cheskPriceCalculationAfter();
        cart.deleteToothbrush();
    }
}
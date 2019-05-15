package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.WebDriverRunner.addListener;

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
    public void regionTest(String regionName){
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

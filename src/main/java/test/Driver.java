package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class Driver {
    private static EventFiringWebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

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
}

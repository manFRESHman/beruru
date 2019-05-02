package test;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;


public class StartPage {
    @Step("Close pop-up")
    public void closePopUp() {
        $(By.xpath("/html")).pressEscape();
    }

    @Step("Click Log-in button")
    public void clickLoginButton() {
        $(By.xpath("//*[text()='Войти в аккаунт']")).shouldBe(Condition.visible).click();
    }

    @Step("Check 'My Profile' button")
    public void checkMyProfile(){
        $(By.xpath("//*[@title='Мой профиль']")).exists();
    }

    @Step("Click region button")
    public void regionClick(){
        $(By.xpath("//*[text()='Регион: ']")).click();
    }


    @Step("Region choose")
    public void regionChoose(String regionName){
        $(By.xpath("//input[@class='input__control']")).setValue(regionName);
        $(By.xpath("//div[@class='region-suggest__list-item suggestick-list__item suggest2-item suggest2-item_type_text']")).click();
    }

    @Step("Region confirm")
    public void regionConfirm(){
        $(By.xpath("//span[text()='Продолжить с новым регионом']/..")).click();
    }

    @Step("Check 'My Profile' button")
    public void Optionsclick(){
        $(By.xpath("//*[@title='Мой профиль']")).hover();
        $(By.xpath("//*[@class='header2-user-menu']//*[text() ='Настройки']")).shouldBe(Condition.visible).click();
    }

    @Step("Check region change")
    public void regionCheck(){
        String city1 = $(By.xpath("//*[text()='Регион: ']/span/span")).shouldBe(Condition.exist).getText();
        String city2 = $(By.xpath("//*[@id='region']/div/div/h2/span/span")).shouldBe(Condition.exist).getText();
        Assert.assertEquals(city1, city2);
    }

    @Step("Search Toothbrushes")
    public void searchToothbrush(){
        $(By.xpath("//input[@id = 'header-search']")).shouldBe(Condition.visible).setValue("электрические зубные щетки");
        $(By.xpath("//span[@class = 'search2__button']")).click();
    }
}

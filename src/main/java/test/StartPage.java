package test;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;


public class StartPage {
    public void closePopUp() {
        $(By.xpath("/html")).pressEscape();
    }

    public void clickLoginButton() {
        $(By.xpath("//*[text()='Войти в аккаунт']")).shouldBe(Condition.visible).click();
    }

    public void checkMyProfile(){
        $(By.xpath("//*[@title='Мой профиль']")).exists();
    }

    public void regionClick(){
        $(By.xpath("//*[text()='Регион: ']")).click();
    }

    public void regionChoose(String regionName){
        $(By.xpath("//input[@class='input__control']")).setValue(regionName);
        $(By.xpath("//div[@class='region-suggest__list-item suggestick-list__item suggest2-item suggest2-item_type_text']")).click();
    }

    public void regionConfirm(){
        $(By.xpath("//span[text()='Продолжить с новым регионом']/..")).click();
    }

    public void Optionsclick(){
        $(By.xpath("//*[@title='Мой профиль']")).hover();
        $(By.xpath("//*[@class='header2-user-menu']//*[text() ='Настройки']")).shouldBe(Condition.visible).click();
    }

    public void regionCheck(){
        String city1 = $(By.xpath("//*[text()='Регион: ']/span/span")).shouldBe(Condition.exist).getText();
        String city2 = $(By.xpath("//*[@id='region']/div/div/h2/span/span")).shouldBe(Condition.exist).getText();
        Assert.assertEquals(city1, city2);
    }

    public void searchToothbrush(){
        $(By.xpath("//input[@id = 'header-search']")).shouldBe(Condition.visible).setValue("электрические зубные щетки");
        $(By.xpath("//span[@class = 'search2__button']")).click();
    }
}

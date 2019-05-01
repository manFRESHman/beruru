package test;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class StartPage {
    public void closePopUp() {
        $(By.xpath("/html")).pressEscape();
    }

    public void clickLoginButton() {
        $(By.xpath("//*[text()='Войти в аккаунт']")).click();
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
        $(By.xpath("//*[text() ='Настройки']")).click();
    }

    public void regionCheck(){
        String city1 = $(By.xpath("//*[text()='Регион: ']/span/span")).getText();
//        System.out.println("City1 = " + city1);
//        sleep(500);
//        String city2;
//            if ($(By.className("settings-list_type_address")).exists())
//                city2 = "YES";
//            else
//                city2 = "NO";
//        System.out.println("City2 = " + city2);
        String city2 = $(By.className("settings-list_type_address")).getText();
    }

    public void searchToothbrush(){
        $(By.xpath("//input[@id = 'header-search']")).setValue("электрические зубные щетки");
        $(By.xpath("//span[@class = 'search2__button']")).click();
    }
}

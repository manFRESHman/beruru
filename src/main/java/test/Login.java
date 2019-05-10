package test;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class Login {
    SelenideElement loginbtn = $(By.className("passp-sign-in-button"));

    @Step("Enter login")
    public void enterLogin() {
        $(By.xpath("//*[@name='login']")).setValue("beru.ru.test");
        loginbtn.click();
    }

    @Step("Enter password")
    public void enterPassword(){
        $(By.xpath("//*[@name='passwd']")).setValue("beru.ru");
        loginbtn.click();
    }
}

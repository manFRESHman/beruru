package test;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class Login {
    @Step("Enter login")
    public void enterLogin() {
        //open("http://beru.ru");
        $(By.xpath("//*[@name='login']")).setValue("beru.ru.test");
        $(By.className("passp-sign-in-button")).click();
    }

    @Step("Enter password")
    public void enterPassword(){
        $(By.xpath("//*[@name='passwd']")).setValue("beru.ru");
        $(By.className("passp-sign-in-button")).click();
    }
}

package test;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class Login {
    public void enterLogin() {
        //open("http://beru.ru");
        $(By.xpath("//*[@name='login']")).setValue("beru.ru.test");
        $(By.className("passp-sign-in-button")).click();
    }

    public void enterPassword(){
        $(By.xpath("//*[@name='passwd']")).setValue("beru.ru");
        $(By.className("passp-sign-in-button")).click();
    }
}

package test;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class MyTest1 {
    @Test
    public void func(){
        open("http://beru.ru");
        sleep(2000);
        $(By.xpath("/html")).pressEscape();
        $(By.xpath("//*[text()='Войти в аккаунт']")).click();
        $(By.xpath("//*[@name='login']")).setValue("beru.ru.test");
        $(By.className("passp-sign-in-button")).click();
        $(By.xpath("//*[@name='passwd']")).setValue("beru.ru");
        $(By.className("passp-sign-in-button")).click();
        $(By.xpath("//*[@title='Мой профиль']")).exists();
        $(By.xpath("//*[@title='Мой профиль']")).click();
        sleep(1000000000);
    }
}

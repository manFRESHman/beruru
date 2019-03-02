package test;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class MyTest1 {
    @Test
    public void func(){

        open("http://google.com");
        $(By.name("q")).setValue("Selenide").pressEnter();
    }
}

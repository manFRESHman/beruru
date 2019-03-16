package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class MyTest1 {
    @Test
    public void func(){
//        open("http://beru.ru");
//        $(By.xpath("/html")).pressEscape();
//        $(By.xpath("//*[text()='Войти в аккаунт']")).click();
//        $(By.xpath("//*[@name='login']")).setValue("beru.ru.test");
//        $(By.className("passp-sign-in-button")).click();
//        $(By.xpath("//*[@name='passwd']")).setValue("beru.ru");
//        $(By.className("passp-sign-in-button")).click();
//        $(By.xpath("//*[@title='Мой профиль']")).exists();


//        open("http://beru.ru");
//        $(By.xpath("/html")).pressEscape();
//        $(By.xpath("//*[text()='Регион: ']")).click();
//        $(By.xpath("//input[@class='input__control']")).setValue("Хвалынск");
//        $(By.xpath("//div[@class='region-suggest__list-item suggestick-list__item suggest2-item suggest2-item_type_text']")).click();
//        $(By.xpath("//span[text()='Продолжить с новым регионом']/..")).click();
//        sleep(500);
//        $(By.xpath("//*[text()='Войти в аккаунт']")).click();
//        $(By.xpath("//*[@name='login']")).setValue("beru.ru.test");
//        $(By.className("passp-sign-in-button")).click();
//        $(By.xpath("//*[@name='passwd']")).setValue("beru.ru");
//        $(By.className("passp-sign-in-button")).click();
//        sleep(500);
//        $(By.xpath("//*[text() ='Настройки']")).click();
//        sleep(500);
//        String city1 = $(By.xpath("//*[text()='Регион: ']/span/span")).getText();
//        System.out.println("City1 = " + city1);
//        sleep(500);
//        String city2;
//            if ($(By.className("settings-list_type_address")).exists())
//                city2 = "YES";
//            else
//                city2 = "NO";
//        System.out.println("City2 = " + city2);


//        open("http://beru.ru");
//        $(By.xpath("/html")).pressEscape();
//        sleep(500);
//        $(By.xpath("//*[text()='Войти в аккаунт']")).click();
//        $(By.xpath("//*[@name='login']")).setValue("beru.ru.test");
//        $(By.className("passp-sign-in-button")).click();
//        $(By.xpath("//*[@name='passwd']")).setValue("beru.ru");
//        $(By.className("passp-sign-in-button")).click();
//        sleep(500);
//        $(By.xpath("//input[@id = 'header-search']")).setValue("электрические зубные щетки");
//        $(By.xpath("//span[@class = 'search2__button']")).click();
//        $(By.xpath("//input[@name = 'Цена от']")).setValue("999");
//        $(By.xpath("//input[@name = 'Цена до']")).setValue("1999");
//        List<String> s = $$(By.xpath("//*[contains(@class,'grid-snippet_react')]")).texts();
//        for(int i = 0; i < s.size(); i++){
//            //String ss = s.get(i).replace(" ", "");
//            int a = s.get(i).indexOf('\n') + 1;
//            int b = s.get(i).indexOf('\u20BD');
//            if(a > b)
//                a = 0;
//            int tst = Integer.parseInt(s.get(i).substring(a, b).replace(" ", ""));
//            if(tst > 1999 || tst < 999)
//                Assert.fail("Price criteria is not working");
//        }
//        $(By.xpath("//*[contains(@class,'grid-snippet_react')][" + /*(s.size() - 1)*/ 2 + "]//button")).click();
//        sleep(500);
//        $(By.xpath("//span[text()='В корзине']")).click();
//        sleep(1000);
//        String t = $(By.xpath("//div[@data-auto='total-items']/span[@data-auto='value']")).text();
//        int items = Integer.parseInt(t.substring(0, t.indexOf('₽')).replace(" ", ""));
//        t = $(By.xpath("//div[@data-auto='total-delivery']/span[@data-auto='value']")).text();
//        int delivery = Integer.parseInt(t.substring(0, t.indexOf('₽')).replace(" ", ""));
//        int discount = 0;
//        if($(By.xpath("//div[@data-auto='total-discount']/span[2]")).exists()) {
//            t = $(By.xpath("//div[@data-auto='total-discount']/span[@data-52906e8d='true']")).text();
//            discount = Integer.parseInt(t.substring(1, t.indexOf('₽')).replace(" ", ""));
//        }
//        t = $(By.xpath("//div[@data-auto='total-price']/span[@class='_1oBlNqVHPq']")).text();
//        int price = Integer.parseInt(t.substring(0, t.indexOf('₽')).replace(" ", ""));
//        if(items + delivery - discount != price)
//            Assert.fail("Price calculation error");
//
//        $(By.xpath("//input[@type='phone']")).setValue("0");
//        sleep(1000);
//        t = $(By.xpath("//div[@data-auto='total-items']/span[@data-auto='value']")).text();
//        items = Integer.parseInt(t.substring(0, t.indexOf('₽')).replace(" ", ""));
//        t = $(By.xpath("//div[@data-auto='total-delivery']/span[@data-auto='value']")).text();
//        if(!(Objects.equals(t, "бесплатно")))
//            Assert.fail("Delivery should be free");
//        discount = 0;
//        if($(By.xpath("//div[@data-auto='total-discount']/span[2]")).exists()) {
//            t = $(By.xpath("//div[@data-auto='total-discount']/span[@data-52906e8d='true']")).text();
//            discount = Integer.parseInt(t.substring(1, t.indexOf('₽')).replace(" ", ""));
//        }
//        t = $(By.xpath("//div[@data-auto='total-price']/span[@class='_1oBlNqVHPq']")).text();
//        price = Integer.parseInt(t.substring(0, t.indexOf('₽')).replace(" ", ""));
//        if(items - discount != price)
//            Assert.fail("Price calculation error");
        //sleep(1000000000);
    }
}
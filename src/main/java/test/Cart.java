package test;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import org.testng.Assert;

public class Cart {
        int items;
        int delivery;
        int discount;
        int price;

        Cart(){
                String t = $(By.xpath("//div[@data-auto='total-delivery']/span[@data-auto='value']")).shouldBe(Condition.visible).text();
                delivery = Integer.parseInt(t.substring(0, t.indexOf('₽')).replace(" ", ""));
                culcValues();
        }

        public void culcValues(){
                String t = $(By.xpath("//div[@data-auto='total-items']/span[@data-auto='value']")).shouldBe(Condition.visible).text();
                items = Integer.parseInt(t.substring(0, t.indexOf('₽')).replace(" ", ""));
                t = $(By.xpath("//div[@data-auto='total-delivery']/span[@data-auto='value']")).text();
                discount = 0;
                if($(By.xpath("//div[@data-auto='total-discount']/span[2]")).exists()) {
                        t = $(By.xpath("//div[@data-auto='total-discount']/span[2]")).text();
                        discount = Integer.parseInt(t.substring(1, t.indexOf('₽')).replace(" ", ""));
                }
                t = $(By.xpath("//div[@data-auto='total-price']/span[@class='_1oBlNqVHPq']")).text();
                price = Integer.parseInt(t.substring(0, t.indexOf('₽')).replace(" ", ""));
        }

        public void cheskPriceCalculation(){
                if(items + delivery - discount != price)
                        Assert.fail("Price calculation error");
        }

        public void set10items(){
                $(By.xpath("//input[@value='1']")).setValue("0");
        }

        public void checkFreeDelivery(){
                sleep(2000);
                delivery = 0;
                culcValues();
                String t = $(By.xpath("//div[@data-auto='total-items']/span[@data-auto='value']")).shouldBe(Condition.visible).text();
                items = Integer.parseInt(t.substring(0, t.indexOf('₽')).replace(" ", ""));
                t = $(By.xpath("//div[@data-auto='total-delivery']/span[@data-auto='value']")).text();
                Assert.assertEquals(t, "бесплатно");
        }

        public void deleteToothbrush(){
                $(By.xpath("//*[@class='_3x8CI4SPmj']")).click();
        }
}

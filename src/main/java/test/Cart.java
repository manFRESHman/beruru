package test;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import org.testng.Assert;

public class Cart {

        String t = $(By.xpath("//div[@data-auto='total-items']/span[@data-auto='value']")).text();
        int items = Integer.parseInt(t.substring(0, t.indexOf('₽')).replace(" ", ""));
        t = $(By.xpath("//div[@data-auto='total-delivery']/span[@data-auto='value']")).text();
        int delivery = Integer.parseInt(t.substring(0, t.indexOf('₽')).replace(" ", ""));
        int discount = 0;
        if($(By.xpath("//div[@data-auto='total-discount']/span[2]")).exists()) {
            t = $(By.xpath("//div[@data-auto='total-discount']/span[@data-52906e8d='true']")).text();
            discount = Integer.parseInt(t.substring(1, t.indexOf('₽')).replace(" ", ""));
        }
        t = $(By.xpath("//div[@data-auto='total-price']/span[@class='_1oBlNqVHPq']")).text();
        int price = Integer.parseInt(t.substring(0, t.indexOf('₽')).replace(" ", ""));


        public void cheskPriceCalculation(){
                if(items + delivery - discount != price)
                        Assert.fail("Price calculation error");
        }

        public void set10items(){
                $(By.xpath("//input[@type='phone']")).setValue("0");
        }

        public void checkFreeDelivery(){
                discount = 0;
                t = $(By.xpath("//div[@data-auto='total-items']/span[@data-auto='value']")).text();
                items = Integer.parseInt(t.substring(0, t.indexOf('₽')).replace(" ", ""));
                t = $(By.xpath("//div[@data-auto='total-delivery']/span[@data-auto='value']")).text();
                if(!(Objects.equals(t, "бесплатно")))
                        Assert.fail("Delivery should be free");
        }
}

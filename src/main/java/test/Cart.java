package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import org.testng.Assert;

public class Cart {
        SelenideElement items = $(By.xpath("//div[@data-auto='total-items']/span[@data-auto='value']"));
        SelenideElement delivery = $(By.xpath("//div[@data-auto='total-delivery']/span[@data-auto='value']"));
        SelenideElement discount = $(By.xpath("//div[@data-auto='total-discount']/span[2]"));
        SelenideElement price = $(By.xpath("//div[@data-auto='total-price']/span[@class='_1oBlNqVHPq']"));

        @Step("Check price calculation correctness")
        public void cheskPriceCalculationBefore(){
                int discountVal = 0;
                if(discount.exists()) {
                        discountVal = Integer.parseInt(discount.shouldBe(Condition.visible).text().replaceAll("\\D",""));
                }
                Assert.assertEquals(
                        Integer.parseInt(items.shouldBe(Condition.visible).text().replaceAll("\\D","")) +
                                Integer.parseInt(delivery.shouldBe(Condition.visible).text().replaceAll("\\D","")) -
                                discountVal,
                        Integer.parseInt(price.shouldBe(Condition.visible).text().replaceAll("\\D",""))
                );
        }

        @Step("Check price calculation correctness")
        public void cheskPriceCalculationAfter(){
                int discountVal = 0;
                if(discount.exists()) {
                        discountVal = Integer.parseInt(discount.shouldBe(Condition.visible).text().replaceAll("\\D",""));
                }
                Assert.assertEquals(
                        Integer.parseInt(items.shouldBe(Condition.visible).text().replaceAll("\\D","")) -
                                discountVal,
                        Integer.parseInt(price.shouldBe(Condition.visible).text().replaceAll("\\D",""))
                );
        }

        @Step("Set number of items to 10")
        public void set10items(){
                $(By.xpath("//input[@value='1']")).setValue("0");
        }

        @Step("Check free delivery")
        public void checkFreeDelivery(){
                sleep(2000);
                //$(By.xpath("//*[contains(text(),'товара') | contains(text(),'товаров')]")).shouldBe(Condition.exist);
                Assert.assertEquals(delivery.should(Condition.exist).text(), "бесплатно");
        }

        @Step("Clear the cart")
        public void deleteToothbrush(){
                $(By.xpath("//*[@class='_3x8CI4SPmj']")).click();
        }
}

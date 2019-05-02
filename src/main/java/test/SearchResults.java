package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.json.JSONObject;

public class SearchResults {

    public void setLowPrice(){
        $(By.xpath("//input[@name = 'Цена от']")).shouldBe(Condition.visible).setValue("999");
    }

    public void setHighPrice(){
        $(By.xpath("//input[@name = 'Цена до']")).shouldBe(Condition.visible).setValue("1999");
    }

    public void showAll(){
        //boolean b = $(By.xpath("//span[text()='saffsa']")).waitUntil(Condition.exist, 1000).exists();
        SelenideElement f = $(By.xpath("//span[@class='button2__text' and text()='Вперёд']/.."));
        while(f.isDisplayed()){
            f.click();
            sleep(2000);
            checkPriceChanges();
        }
    }

    public void checkPriceChanges(){
        List<SelenideElement> s = $$(By.xpath("//*[contains(@class,'grid-snippet_react')]"));
        for(int i = 0; i < s.size(); i++){
            JSONObject obj = new JSONObject(s.get(i).getAttribute("data-bem"));
            int price = obj.getJSONObject("grid-snippet").getInt("price");
            Assert.assertTrue(price >= 999 && price <= 1999);
        }
    }

    public void buy(){
        sleep(2000);
        List<SelenideElement> s = $$(By.xpath("//span[text() = 'В корзину']/.."));
        s.get(s.size() - 2).shouldBe(Condition.visible).click();
    }

    public void toCart(){
        $(By.xpath("//span[text()='В корзине']")).shouldBe(Condition.visible).click();
    }
}

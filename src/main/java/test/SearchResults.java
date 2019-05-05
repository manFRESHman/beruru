package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.json.JSONObject;

public class SearchResults {

    @Step("Set low price")
    public void setLowPrice(){
        $(By.xpath("//input[@name = 'Цена от']")).shouldBe(Condition.visible).setValue("999");
    }

    @Step("Set high price")
    public void setHighPrice(){
        $(By.xpath("//input[@name = 'Цена до']")).shouldBe(Condition.visible).setValue("1999");
    }

    @Step("Show all goods")
    public void showAll(){
        SelenideElement f = $(By.xpath("//span[@class='button2__text' and text()='Вперёд']/.."));
        while(f.isDisplayed()){
            f.click();
            sleep(2000);
            checkPriceChanges();
        }
    }

    @Step("Check price changes")
    public void checkPriceChanges(){
        $(By.xpath("//*[contains(@class,'grid-snippet_react')]")).shouldBe(Condition.visible);
        List<SelenideElement> s = $$(By.xpath("//*[contains(@class,'grid-snippet_react')]"));
        for(int i = 0; i < s.size(); i++){
            JSONObject obj = new JSONObject(s.get(i).getAttribute("data-bem"));
            int price = obj.getJSONObject("grid-snippet").getInt("price");
            Assert.assertTrue(price >= 999 && price <= 1999);
        }
    }

    @Step("Buy Toothbrush")
    public void buy(){
        $(By.xpath("//span[text() = 'В корзину']/..")).shouldBe(Condition.visible);
        List<SelenideElement> s = $$(By.xpath("//span[text() = 'В корзину']/.."));
        s.get(s.size() - 2).shouldBe(Condition.visible).click();
    }

    @Step("Add to cart")
    public void toCart(){
        $(By.xpath("//span[text()='В корзине']")).shouldBe(Condition.visible).click();
    }
}

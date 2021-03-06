package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

import org.testng.Assert;
import org.json.JSONObject;

public class SearchResults {
    By priceData = By.xpath("//*[contains(@class,'grid-snippet_react')]");
    By items = By.xpath("//span[text() = 'В корзину']/..");

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
            do{
                sleep(50);
            } while($(By.xpath("//*[@class='spin2 spin2_size_m i-bem spin2_js_inited spin2_progress_yes']")).isDisplayed());
            checkPriceChanges();
        }
    }

    @Step("Check price changes")
    public void checkPriceChanges(){
        $(priceData).shouldBe(Condition.visible);
        List<SelenideElement> s = $$(priceData);
        for(int i = 0; i < s.size(); i++){
            JSONObject obj = new JSONObject(s.get(i).getAttribute("data-bem"));
            int price = obj.getJSONObject("grid-snippet").getInt("price");
            Assert.assertTrue(price >= 999 && price <= 1999);
        }
    }

    @Step("Buy Toothbrush")
    public void buy(){
        $(items).shouldBe(Condition.visible);
        List<SelenideElement> s = $$(items);
        s.get(s.size() - 2).shouldBe(Condition.visible).click();
    }

    @Step("Add to cart")
    public void toCart(){
        $(By.xpath("//span[text()='В корзине']")).shouldBe(Condition.visible).click();
    }
}

package test;

import org.openqa.selenium.By;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;
import org.testng.Assert;

public class SearchResults {

    public void setLowPrice(){
        $(By.xpath("//input[@name = 'Цена от']")).setValue("999");
    }

    public void setHighPrice(){
        $(By.xpath("//input[@name = 'Цена до']")).setValue("1999");
    }

    public void checkPriceChanges(){
        List<String> s = $$(By.xpath("//*[contains(@class,'grid-snippet_react')]")).texts();
        for(int i = 0; i < s.size(); i++){
            //String ss = s.get(i).replace(" ", "");
            int a = s.get(i).indexOf('\n') + 1;
            int b = s.get(i).indexOf('\u20BD');
            if(a > b)
                a = 0;
            int tst = Integer.parseInt(s.get(i).substring(a, b).replace(" ", ""));
            Assert.assertTrue(tst >= 999 && tst <= 1999);
        }
    }

    public void buy(){
        $(By.xpath("//*[contains(@class,'grid-snippet_react')][" + /*(s.size() - 1)*/ 2 + "]//button")).click();
    }

    public void toCart(){
        $(By.xpath("//span[text()='В корзине']")).click();
    }
}

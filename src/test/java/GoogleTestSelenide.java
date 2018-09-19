import org.openqa.selenium.By;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class GoogleTestSelenide {

        @Test
        public void login() {
            open("https://www.google.com/");
            $(By.name("q")).setValue("Hello world").pressEnter();
            $$(By.className("g")).shouldHave(CollectionCondition.size(10));
            $(By.className("g")).shouldHave(Condition.text("Hello world! — Вікіпедія"));
        }
}

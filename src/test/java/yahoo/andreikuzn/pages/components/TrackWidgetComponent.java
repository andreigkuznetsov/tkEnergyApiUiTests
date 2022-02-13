package yahoo.andreikuzn.pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TrackWidgetComponent {

    public void checkTrackingWidget(String billNumber, String currentStatus) {

        $x("/html/body/div[3]/div[2]/main/div[1]/div[2]/ul/li[2]/a").click();
        $x("//*[@id=\"etcTrackingWidget_1_2\"]/form/div/div[1]/div/input").setValue(billNumber);
        $x("//*[@id=\"etcTrackingWidget_1_2\"]/form/div/div[2]/div/button").click();
        $("div.col-lg-9").shouldHave(text("Отслеживание груза"));
        $("#yaShare").scrollIntoView(true);
        $("div.etc-tracking-result").$(byText(currentStatus))
                .shouldBe(Condition.visible);

    }
}

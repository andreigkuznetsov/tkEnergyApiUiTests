package tests.pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TrackWidgetComponent {
    public void checkTrackingWidget(String billNumber, String currentStatus) {
        $x("/html/body/div[3]/div[2]/main/div[1]/div[2]/ul/li[2]/a").click();
        $("#etcTrackingWidget_1_2 form div div.col-lg-10.col-xs-12 div input").setValue(billNumber);
        $("#etcTrackingWidget_1_2 form div div.col-lg-2.col-md-3.col-xs-12 div button").click();
        $("div.col-lg-9").shouldHave(text("Отслеживание груза"));
        $("#yaShare").scrollIntoView(true);
        $("div.etc-tracking-result").$(byText(currentStatus))
                .shouldBe(Condition.visible);
    }
}



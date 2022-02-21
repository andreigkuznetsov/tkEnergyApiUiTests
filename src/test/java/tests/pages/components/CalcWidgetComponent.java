package tests.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalcWidgetComponent {
    public void checkCalcWidget(String cityFrom, String cityTo, String weight, String cargoVolume) {
        $("#etcCalculatorWidget_1_2 form div div:nth-child(1) div input").setValue(cityFrom);
        $("#etcCalculatorWidget_1_2 form div div:nth-child(2) div input").setValue(cityTo);
        $("#etcCalculatorWidget_1_2 form div div:nth-child(3) div input").setValue(weight);
        $("#etcCalculatorWidget_1_2 form div div:nth-child(4) div input").setValue(cargoVolume);
        $("#etcCalculatorWidget_1_2 form div div.col-lg-2.col-md-3.col-xs-12 div button").click();
        $("div.col-lg-9").shouldHave(text("Онлайн калькулятор"));
        $("#submitButton").scrollIntoView(true);
        $("div.etc-calculator-result").$(byText("Стоимость перевозки:"))
                .parent().shouldBe(visible);
    }
}





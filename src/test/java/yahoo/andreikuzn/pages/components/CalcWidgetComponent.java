package yahoo.andreikuzn.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CalcWidgetComponent {

    public void checkCalcWidget(String cityFrom, String cityTo, String weight, String cargoVolume, String cost) {

        $x("//*[@id=\"etcCalculatorWidget_1_2\"]/form/div/div[1]/div/input").setValue(cityFrom);
        $x("//*[@id=\"etcCalculatorWidget_1_2\"]/form/div/div[2]/div/input").setValue(cityTo);
        $x("//*[@id=\"etcCalculatorWidget_1_2\"]/form/div/div[3]/div/input").setValue(weight);
        $x("//*[@id=\"etcCalculatorWidget_1_2\"]/form/div/div[4]/div/input").setValue(cargoVolume);
        $x("//*[@id=\"etcCalculatorWidget_1_2\"]/form/div/div[5]/div/button").click();
        $("div.col-lg-9").shouldHave(text("Онлайн калькулятор"));
        $("#submitButton").scrollIntoView(true);
        $("div.etc-calculator-result").$(byText("Стоимость перевозки:"))
                .parent().shouldHave(text(cost));
    }

}

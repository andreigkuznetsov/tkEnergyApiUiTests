package tests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AboutCompanySteps {
    private final String INFOPORTALTEXT = "Информационный портал",
            VACANCIESTEXT = "Вакансии",
            DOCSECTIONSTEXT = "Документы",
            FAQTITLE = "Вопрос-ответ",
            FAQTEXT = "Часто задаваемые вопросы",
            RULESSECTIONTEXT = "Правила";

    private final SelenideElement mainWebPageArea = $(".etc-main");

    public static ElementsCollection
            infoPortalContentArea = $$("div.grid"),
            vacanciesContentArea = $$("#jobs"),
            docsContentArea = $$("#documents"),
            rulesContentArea = $$("div.etc-blog-post");

    @Step("Открываем страницу \"Информационный портал\" раздела \"О компании\"")
    public AboutCompanySteps openInfoPortalPage() {
        mainWebPageArea.$(byText(INFOPORTALTEXT)).click();
        return this;
    }

    @Step("Проверяем, что открылась страница \"Информационный портал\"")
    public AboutCompanySteps checkInfoPortalPage() {
        mainWebPageArea.shouldHave(text(INFOPORTALTEXT));
        return this;
    }

    @Step("Проверяем наличие контента на странице \"Информационный портал\"")
    public AboutCompanySteps checkInfoPortalPageContent() {
        infoPortalContentArea.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Открываем страницу \"Вакансии\" раздела \"О компании\"")
    public AboutCompanySteps openVacanciesPage() {
        mainWebPageArea.$(byText(VACANCIESTEXT)).click();
        return this;
    }

    @Step("Проверяем, что открылась страница \"Вакансии\"")
    public AboutCompanySteps checkVacanciesPage() {
        mainWebPageArea.shouldHave(text(VACANCIESTEXT));
        return this;
    }

    @Step("Проверяем наличие контента на странице \"Вакансии\"")
    public AboutCompanySteps checkVacanciesPageContent() {
        vacanciesContentArea.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Открываем страницу \"Документы\" раздела \"О компании\"")
    public AboutCompanySteps openDocsPage() {
        mainWebPageArea.$(byText(DOCSECTIONSTEXT)).click();
        return this;
    }

    @Step("Проверяем, что открылась страница \"Документы\"")
    public AboutCompanySteps checkDocsPage() {
        mainWebPageArea.shouldHave(text(DOCSECTIONSTEXT));
        return this;
    }

    @Step("Проверяем наличие контента на странице \"Документы\"")
    public AboutCompanySteps checkDocsPageContent() {
        docsContentArea.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Открываем страницу \"Вопрос-ответ\" раздела \"О компании\"")
    public AboutCompanySteps openFaqPage() {
        mainWebPageArea.$(byText(FAQTITLE)).click();
        return this;
    }

    @Step("Проверяем, что открылась страница \"Вопрос-ответ\"")
    public AboutCompanySteps checkFaqPage() {
        mainWebPageArea.shouldHave(text(FAQTEXT));
        return this;
    }

    @Step("Открываем страницу \"Правила\" раздела \"О компании\"")
    public AboutCompanySteps openRulesPage() {
        mainWebPageArea.$(byText(RULESSECTIONTEXT)).click();
        return this;
    }

    @Step("Проверяем, что открылась страница \"Правила\"")
    public AboutCompanySteps checkRulesPage() {
        mainWebPageArea.shouldHave(text(RULESSECTIONTEXT));
        return this;
    }
    
    @Step("Проверяем наличие контента на странице \"Правила\"")
    public AboutCompanySteps checkRulesPageContent() {
        rulesContentArea.shouldHave(sizeGreaterThan(0));
        return this;
    }
}

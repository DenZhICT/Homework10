package firstTestWithAllure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем страиницу GitHub")
    public WebSteps openPage() {
        open("/");
        return this;
    }

    @Step("Ищем репозиторий {repo}")
    public WebSteps findRepository(String repo) {
        $("[data-test-selector=nav-search-input]").setValue(repo).pressEnter();
        return this;

    }

    @Step("Переходим на сайт репозитория {repo}")
    public WebSteps clickOnRepositoryLink() {
        $("ul.repo-list li a").click();
        return this;
    }

    @Step("Переходим в раздел Issue")
    public WebSteps goToIssue() {
        $("#issues-tab").click();
        return this;
    }

    @Step("Проверяем наличие текста {checkText}")
    public WebSteps checkNameOfIssue(String checkText) {
        $("#issue_2").shouldHave(text(checkText));
        return this;
    }
}

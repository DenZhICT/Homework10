package firstTestWithAllure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class IssueTest extends TestBase {
    private String repo = "qa-guru/knowledge-base";
    private String checkText = "Need to change from 'JUnit' to 'Selenide'";

    @DisplayName("Тест на проверку названия Issue в репозитории qa-guru/knowledge-base через чистый Selenide")
    @Test
    void selenideIssueTest() {
        // Открываем страиницу GitHub
        open("/");
        // Ищем репозиторий "qa-guru/knowledge-base"
        $("[data-test-selector=nav-search-input]").setValue(repo).pressEnter();
        // Переходим на сайт репозитория "qa-guru/knowledge-base"
        $("ul.repo-list li a").click();
        // Переходим в раздел Issue
        $("#issues-tab").click();
        // Проверяем наличие текста "Need to change from 'JUnit' to 'Selenide'"
        $("#issue_2").shouldHave(text(checkText));
    }

    @DisplayName("Тест на проверку названия Issue в репозитории qa-guru/knowledge-base через лямбда шаги")
    @Test
    void lambdaIssueTest() {
        step("Открываем страиницу GitHub", () -> {
            open("/");
        });
        step("Ищем репозиторий " + repo, () -> {
            $("[data-test-selector=nav-search-input]").setValue(repo).pressEnter();
        });
        step("Переходим на сайт репозитория " + repo, () -> {
            $("ul.repo-list li a").click();
        });
        step("Переходим в раздел Issue", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие текста " + checkText, () -> {
            $("#issue_2").shouldHave(text(checkText));
        });
    }

    @DisplayName("Тест на проверку названия Issue в репозитории qa-guru/knowledge-base через аннотации @Step")
    @Test
    void StepIssueTest() {
        WebSteps step = new WebSteps();
        step
                .openPage()
                .findRepository(repo)
                .clickOnRepositoryLink()
                .goToIssue()
                .checkNameOfIssue(checkText);
    }
}

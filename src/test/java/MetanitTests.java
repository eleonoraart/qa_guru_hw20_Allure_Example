import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MetanitTests extends TestBase{

    String menu = "Java SE Android Java EE Базы данных в Java JavaFX";
    @DisplayName("Проверка отображения описания раздела Java")
    @Test
    void checkOpenPageAboutJava(){
        step("Открываем главную страницу metanit.com", () -> {
            open("/");
        });
        step("Кликаем на плиточку с названием Java", () -> {
            $("a[href$='/java/']").click();
        });

        step("Проверяем описание раздела", () -> {
            $(".outercontainer p").shouldHave(text("Данный раздел посвящен языку программирования Java"));
        });
    }

    @DisplayName("Проверка списка пунктов меню в разделе Java")
    @Test
    void checkJavaMenuList(){
        step("Переходим в раздел Java", () -> {
            open("/java/");
        });

        step("Проверяем список доступных пунктов в левом меню", () -> {
            $(".navmenu").shouldHave(text(menu));
        });
    }
}

package DAO.Controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Точно так же, как в приложении JSP, контроллер будет обрабатывать навигацию между различными представлениями.
 * Далее мы внедрим минималистичный контроллер. Он перейдет с начальной страницы на страницу списка дел:
 * Навигация основана на возвращаемом имени. Таким образом, loadTodoPage отправит нас на страницу todo.xhtml, которую мы внедрим следующим образом.
 */

@Scope(value = "session")
@Component(value = "jsfController")
public class JSFController {

    public String loadTodoPage() {
        checkPermission();
        return "/todo.xhtml";
    }

    private void checkPermission() {
        // Details omitted
    }
}

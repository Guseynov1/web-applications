package DAO.ServiceLayer;

import DAO.DAO;
import DAO.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Основная цель уровня DAO - обрабатывать детали механизма сохранения, в то время как уровень сервиса находится поверх него для обработки бизнес-требований.
 * Обратите внимание, что на интерфейс DAO будут ссылаться из сервиса:
 */

/**
 * Здесь служба представляет собой именованный компонент. Мы будем использовать это имя для ссылки на компонент из контекста JSF.
 * Этот класс также имеет область действия сеанса (session), которая будет удовлетворительной для этого простого приложения.
 * Поскольку встроенные области Spring имеют модель, отличную от JSF, стоит рассмотреть возможность определения пользовательской области.
 */

@Scope(value = "session")
@Component(value = "todoService")
public class TodoService {

    @Autowired
    private DAO<Todo> todoDAO;
    private Todo todo = new Todo();

    public void save() {
        todoDAO.save(todo);
        todo = new Todo();
    }

    public Collection<Todo> getAllTodo() {
        return todoDAO.getAll();
    }

    private void validate(Todo todo){
        // Details omitted
    }

    public int saveTodo(Todo todo) {
        validate(todo);
        return todoDAO.save(todo);
    }

    public Todo getTodo() {
        return todo;
    }
}

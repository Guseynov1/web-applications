package DAO;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Прелесть этого шаблона в том, что мы можем предоставить новую реализацию этого интерфейса в любое время.
 * Следовательно, мы можем изменить уровень сохраняемости, не затрагивая остальную часть кода.
 * Для нашего примера мы будем использовать класс хранения в памяти:
 */

@Component
public class TodoDAO implements DAO<Todo> {
    private final List<Todo> todoList = new ArrayList<>();

    @Override
    public Optional<Todo> get(int id) {
        return Optional.ofNullable(todoList.get(id));
    }

    @Override
    public Collection<Todo> getAll() {
        return todoList.stream().filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public void delete(Todo todo) {
        todoList.set(todo.getId(), null);

    }

    @Override
    public void update(Todo todo) {
        todoList.set(todo.getId(), todo);

    }

    @Override
    public int save(Todo todo) {
        todoList.add(todo);
        int index = todoList.size() - 1;
        todo.setId(index);
        return index;
    }
}

package DAO;

import java.util.Collection;
import java.util.Optional;

// DAO -> Todo -> TodoDAO
// TODO: DAO отвечает за 2 концепции:
//  1. Инкапсуляция деталей уровня сохраняемости
//  2. Предоставление интерфейса CRUD для одной сущности
public interface DAO<T> {
    Optional<T> get(int id);
    Collection<T> getAll();
    int save(T t);
    void update(T t);
    void delete(T t);
}

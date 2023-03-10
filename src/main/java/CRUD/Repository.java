package CRUD;

import org.springframework.stereotype.Indexed;

// TODO: 06.02.2023 Start: -> CrudRepository -> Treadmill (тут создаем наш репозиторий) -> TreadmillRepository -> Application
// Интерфейс репозитория не имеет методов, т.к. его назначение - быть интерфейсом маркера
@Indexed // Это указывает на то, что все потомки этого интерфейса должны рассматриваться как кандидаты для компонентов репозитория.
public interface Repository<T, ID> {
    // T - тип объекта
    // ID - уникальный тип идентификатора объекта
}

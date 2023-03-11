package CRUD;

// Чтобы создать наш репозиторий, нам нужно расширить CrudRepository и указать тип объекта (Treadmill) и тип ID объекта (String) следующим образом:
public interface TreadmillRepository extends CrudRepository<Treadmill, String> {

}

/**
 * Это все. Здесь, мы используем String code свойства в качестве ID (обычно Long),
 * особенно если вы собираетесь использовать реляционную БД и последовательные номера в качестве ID.
 * Spring создает необходимые реализации для всех методов CRUD, представленных в классе CrudRepository.
 */
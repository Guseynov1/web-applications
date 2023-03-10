package com.example.web.business.persistence;

import com.example.web.business.businesslayer.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Далее мы можем создать уровень сохраняемости, который будет взаимодействовать с нашим уровнем БД.
 * Мы реализуем наш уровень сохраняемости, используя @Repository, в частности, CrudRepository.
 * Это позволит нам создавать базовые CRUD-запросы для нашей базы данных.
 */

// Если мы хотим добавить конкретные методы, мы можем реализовать их в объявлении UserRepository.
// В этом примере мы реализовали один пользовательский метод, называемый findUserById.
// Этот метод позволит нам запросить нашу БД h2, ища пользователя на основе его ID.
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserById(Long id);
}

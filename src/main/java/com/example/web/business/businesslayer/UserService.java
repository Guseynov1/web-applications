package com.example.web.business.businesslayer;

import com.example.web.business.persistence.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Прямо сейчас служба просто вызывает объект UserRepository с любыми требуемыми параметрами.
 * Расширить это, чтобы реализовать бизнес-логику для проверки наших запросов перед их отправкой.
 * Одним из примеров бизнес-логики является служба, определяющая, какие операции допустимы для хранилища.
 * Поскольку это реализуется в настоящее время, мы определили только методы save и findUserById.
 * Это означает, что единственными запросами, допустимыми для БД, являются те, которые добавляют новые User объекты или запрашивают существующие по ID.
 */

/**
 * Любой запрос, поступающий на уровень сохраняемости, должен проходить через бизнес-уровень.
 * Обычно это реализуется с помощью сервиса. Эта служба действует как посредник между бизнес-уровнями и уровнями сохраняемости.
 * Идея заключается в том, что служба применит бизнес-правила, затем перенаправит запрос на уровень сохраняемости, чтобы при необходимости манипулировать БД.
 */

// В нашем примере у нас есть два метода, которые были бы полезны в нашем сервисе.
// Первый - save, встроенный метод, предоставляемым CrudRepository, используемым для сохранения предоставленного объекта в БД.
// Второй - это метод findUserById - используется для поиска User объекта по его ID. Пример сервиса для нашего репозитория:

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }
    public User save(User toSave) {
        return userRepository.save(toSave);
    }

}
package com.example.web.business.presentation;

import com.example.web.business.businesslayer.User;
import com.example.web.business.businesslayer.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Наш последний уровень - уровень презентации - предоставит конечному пользователю возможность взаимодействовать с приложением.
 * В этом примере мы используем RESTful API для обеспечения взаимодействия с пользователем.
 * Мы будем использовать пользовательский сервис для отправки запросов в БД для извлечения и изменения данных.
 * Ниже реализуем простые GET и POST для извлечения и добавления пользовательских объектов в наш API.
 */

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userService.save(new User(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName()));
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        return userService.findUserById(id);
    }
}

// TODO: 09.02.2023 Итоговая схема, показывающая, как каждый компонент вписывается в многоуровневую архитектуру приложения:
//  Presentation Layer:          UserController
//  Business Layer:              User, UserService
//  Persistence Layer:           UserRepository
//  Database Layer:              h2 database
//  * В большом приложении контроллер может иметь ссылки на несколько сервисов, а сервис - на несколько репозиториев
//  *** Уровень представления: обрабатывает интерфейс, который отображается пользователю.
//  *** Бизнес-уровень: реализует правила для решения проблемы, для решения которой было разработано ваше приложение.
//  *** Уровень сохраняемости: содержит логику, связанную с хранением БД, и обрабатывает преобразование объектов в форматы БД.
//  *** Уровень базы данных: содержит фактическую систему хранения БД, обрабатывает таблицы, индексы и любые другие операции, связанные с БД.


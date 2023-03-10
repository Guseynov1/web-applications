package com.example.web.RESTget;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: Реализуем базовый контроллер на основе REST для извлечения данных с помощью запросов GET.

/**
 * Веб-приложения взаимодействуют с сервером через API — различные методы, которые могут быть обработаны с помощью запросов HTTP (протокол передачи гипертекста).
 * Контроллер - это часть приложения, которое обрабатывает эти методы API.
 */
@RestController // заставляет класс предоставлять точные конечные точки (запрошенный URL) для доступа к методам REST.
public class TaskController {

    private final List<Task> tasks = List.of( // final - чтобы устранить любые проблемы, связанные с потоками
            new Task(1, "task1", "I gonna fuck you, bitch!", false),
            new Task(2, "task2", "Are you kidding me?", true)
    );

    @GetMapping("/tasks/{id}") // указывает, какой URL-путь должен быть связан с запросом GET
    public ResponseEntity<Task> getTask(@PathVariable int id) { // сообщить Spring, что мы ожидаем параметр id.
        return new ResponseEntity<>(tasks.get(id - 1), HttpStatus.ACCEPTED); // list indices start from 0
    }

}

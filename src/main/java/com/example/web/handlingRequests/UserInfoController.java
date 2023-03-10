package com.example.web.handlingRequests;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO: 08.02.2023 Используем @RequestBody для приема данных JSON через @RestController.
//  Эта аннотация может отправлять данные определенного формата, включая JSON, в теле запроса.
//  После этих шагов ваш метод сможет прочитать переданное тело запроса в любом требуемом формате.

@RestController
public class UserInfoController {

    // Теперь давайте создадим простой POST-запрос, который принимает JSON-представление объекта userInfo.
    // Запрос POST вернет имя учетной записи пользователя и статус учетной записи:

    @PostMapping("/user")
    public static String userStatus(@RequestBody UserInfo user) {
        if (user.isEnabled())
            return String.format("Hello! %s. Your account is enabled.", user.getName());
        else
            return String.format("Hello! Nice to see you, %s! Your account is disabled", user.getName());
    }

    // Можно отправить несколько объектов JSON в одном запросе, используя список объектов в нашем @RequestBody.
    // Таким образом, JSON, который мы отправляем на сервер, теперь должен представлять собой список объектов JSON.
    @PostMapping("/user")
    public String userStatus(@RequestBody List<UserInfo> userList) {
        return String.format("Added %d users", userList.size());
    }

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_XML_VALUE) // используем XML для передачи объектов
    public String userStatuz(@RequestBody UserInfo user) {
        return String.format("Added User %s", user);
    }
    /**
     * Используя аргумент consumes, можно настроить данные, которые отправляются в POST-запрос.
     * Когда аргумент consumes добавляется к отображению, нам также нужно пометить аргумент path аргументом с value.
     * Это позволяет Spring различать аргументы. Если аргумент consumes не указан, по умолчанию это будет JSON.
     * Существует много других значений MediaType - TEXT_PLAIN можно использовать для обычного текста, TEXT_HTML - для форматов HTML.
     */
}
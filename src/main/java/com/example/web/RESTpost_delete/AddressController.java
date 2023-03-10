package com.example.web.RESTpost_delete;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// TODO: Чтобы добавить человека в адресную книгу, пользователю необходимо отправить данные на сервер, в то время как сервер должен где-то их хранить.
//  Чтобы сделать это возможным, реализуйте @PostMapping в @RestController.

/**
 * Совет: использовать потокобезопасный объект для работы с данными в @RestController.
 * Контроллер может получать несколько запросов одновременно, и запросы обрабатываются разными потоками.
 * Если объект не является потокобезопасным, множественные запросы могут привести к потере данных
 * и другим неожиданным ошибкам при обработке данных с помощью запросов POST или DELETE.
 */

@Data
@RestController
public class AddressController {
    // хотим сохранить сопоставления людей с адресами - поэтому Map
    private static ConcurrentMap<String, String> addressBook = new ConcurrentHashMap<>(); // ConcurrentMap - потокобезопасный

    // Когда мы предоставляем параметр через параметры запроса, нам нужно задать имя и значение.
    // Имя параметра должно совпадать с именем @RequestParam, а значение должно быть того же типа, что и переменная @RequestParam
    // пример того, как @RequestParam можно использовать с @PostMapping для добавления данных в адресную книгу:
    // В этом @PostMapping мы ожидаем два @RequestParam с запросом. Когда пользователи отправляют запрос POST по пути /addresses,
    // они предоставляют два параметра в теле запроса. Когда запрос отправляется, имя и адрес добавляются в ConcurrentHashMap.
    @PostMapping("/addresses")
    public static void postAddress(@RequestParam String name, @RequestParam String address) { // RequestParam - отправляем данные с POST-запросом
        addressBook.put(name, address);
    }

    // Чтобы проверить, была ли публикация успешной реализуем запрос GET, который возвращает запрошенный адрес на основе предоставленного имени:
    @GetMapping("/addresses/{name}")
    public String getAddress(@PathVariable String name) {
        return addressBook.get(name);
    }

    @DeleteMapping("/addresses")
    public String removeAddress(@RequestParam String name) {
        addressBook.remove(name);
        return name + " removed from address book!";
    }
}

/**
 * @RequestParam - это переменная, предоставляемая пользователем в параметрах запроса.
 * Он используется при обработке запросов POST. @RequestParam может быть предоставлен двумя способами:
 * --- В разделе параметров запроса REST. В Postman его можно найти в разделе Params, помеченном как Query Params;
 * --- В URL-адресе, в следующем формате: localhost:<port>/<ApiPath>?<Param>=<value>&<Param>=<value>.
 */
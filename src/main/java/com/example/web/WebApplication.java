package com.example.web;

import com.example.web.handlingRequests.UserInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static com.example.web.RESTpost_delete.AddressController.postAddress;
import static com.example.web.handlingRequests.UserInfoController.userStatus;

// TODO: 04.02.2023 Чтобы завершить работу приложения, мы создадим простой HTML-файл в папке, отвечающей за статическое содержимое, а затем откроем его через веб-браузер.
// static - папка, в которую мы можем поместить любой статический контент (изображения, таблицы стилей, JavaScript и так далее),
// который мы хотим предоставить браузеру. Изначально он пуст. Если мы поместим туда HTML-файл с именем index.html он будет доступен по корневому URL-адресу.
// Теперь, если мы снова запустим приложение и направим наш веб-браузер на http://localhost:8080 /, мы увидим нашу веб-страницу.
// Кроме того, мы можем получить доступ к файлу по его имени: http://localhost:8080/index.html .
// Отныне доступ к веб-приложению можно получить из http://localhost:9090/myBitch URL-адрес.
@SpringBootApplication
public class WebApplication {
	public static void main(String[] args) {

		SpringApplication.run(WebApplication.class, args);
		postAddress("Bob", "Label St.");
		userStatus(new UserInfo(1, "Bob", "888-111", true));

	}

}


/**
 * Контекстный путь (Context Path) - это префикс URL-адреса, по которому мы можем получить доступ к приложению.
 * Он также известен как подпуть или подкаталог. Как мы можем видеть, контекстный путь по умолчанию пуст (запустили приложение без кода, просто разместив зависимость ... starter-web в pom).
 * Это означает, что доступ к веб-приложению можно получить из http://localhost:8080 / URL.
 * Приложения часто размещаются где-то еще, кроме контекстного пути по умолчанию.
 * Например, контекстный путь, такой как blog, означает, что к приложению можно получить доступ через URL, такой как http://localhost:8080/blog.
 * Контекстный путь также может быть вложенным: blog/v1.
 */
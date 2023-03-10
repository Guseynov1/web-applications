package applicationContext;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Person -> Config -> App -> anotherWay: Book - Movie -> Start -> Runner
 */

// Допустим, мы хотим сохранить объекты типа Person в нашем контейнере.
// Итак, прежде всего, давайте создадим класс Person:
@Getter
@AllArgsConstructor
public class Person {
    private String name;
}

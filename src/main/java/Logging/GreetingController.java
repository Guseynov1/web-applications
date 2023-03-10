package Logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Одним из важных соображений, которые следует учитывать при настройке ведения журнала, является то, как обращаться с несколькими компонентами приложения.
 * Предположим, мы хотим добавить второй компонент с именем GreetingController к нашему предыдущему коду.
 * Мы можем настроить объект Logger для этого класса аналогично классу LoggingController, однако,
 * чтобы заставить журнал отображать нужный нам класс, мы предоставляем ему GreetingController.class в качестве аргумента. Вот полный код для компонента:
 */

@Component
public class GreetingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

    public void greetUser(String greeting) {

        if (greeting.isEmpty()) {
            LOGGER.error("Provided empty greeting!");
            throw new IllegalArgumentException();
        }

        System.out.println(greeting);
        LOGGER.info("Greeting successfully sent!");
    }
}


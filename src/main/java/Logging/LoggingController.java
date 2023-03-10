package Logging;

import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс ведения журнала для нашего приложения.
 * Чтобы сделать это, мы создадим новый компонент, который обрабатывает процесс ведения журнала.
 * Чтобы использовать эти компоненты в нашем приложении, мы импортируем их из slf4j (Компонент logback доступен через внешний интерфейс, называемый slf4j).
 * Импортируемые компоненты slf4j, а именно Logger и LoggerFactory, позволяют нам создавать объекты для взаимодействия с Logback.
 * Первый компонент, который у нас есть, - это объект под названием Logger.
 */

@Component
public class LoggingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingController.class);

    public void log() {
        LOGGER.info("This is an INFO level log message!");
    }
}

/** 12:05:30.102 [main] INFO com.example.demo.LoggingController - This is an INFO level log message!
 * Перед сообщением журнала есть информация, указывающая используемый уровень журнала.
 * Еще одной интересной особенностью сообщения журнала является тот факт, что оно показывает компонент, который напечатал сообщение журнала,
 * в данном случае LoggingController.
 * Это возможно, потому что, когда мы создавали наш объект Logger, мы дали ему ссылку на класс, для которого мы ведем журнал, LoggingController.class
 */
package applicationContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Start { // или это все должно быть в App?

    // В Spring Boot метод SpringApplication.run() берет на себя создание контекста на основе найденных компонентов
    public static void main(String[] args) {
        // Во время выполнения метода run создается контекст приложения. Мы можем получить контекст и посмотреть, какие определения компонентов он содержит:
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        // В выходных данных вы можете увидеть массив имен компонентов, используемых в приложении.
        // Даже если мы не создавали наши собственные компоненты, мы увидим множество внутренних компонентов, созданных Spring Boot для поддержания работы приложения.
        /**
         * Другой способ получить доступ к ApplicationContext - использовать аннотацию @Autowired.
         * Просто вставьте контекст, созданный в методе SpringApplication.run(...), в другой компонент. Это позволяет нам получить контекст в любом месте приложения.
         */
        // Давайте получим все имена компонентов из ApplicationContext внутри класса Runner:
    }
}

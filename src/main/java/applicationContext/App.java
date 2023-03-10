package applicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Теперь пришло время создать контекст приложения на основе этого класса конфигурации
 * и получить из него все имена компонентов (только строковые имена, а не объекты).
 */
public class App {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);
        context.getBean("personMary", Person.class); // returns a Person object
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        // Now our context knows about the new beans: book and movie.

    }
}

/**
 * При запуске среди ряда внутренних компонентов (необходимых для работы приложения Spring), вы можете увидеть имена созданных нами компонентов: config и personMary.
 * [..., ..., config, personMary]
 // Давайте получим наш компонент (весь объект) из контейнера с помощью класса Person: -> 15
 */
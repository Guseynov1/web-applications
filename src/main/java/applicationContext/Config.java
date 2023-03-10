package applicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// Application Context создается на основе класса конфигурации
// Нам нужен класс конфигурации, который описывает, какие объекты (beans) будут созданы внутри контейнера IoC:

/**
 * Мы стремимся поместить эти компоненты (Book, Movie) в тот же контекст приложения, который основан на классе Config.
 * Для того чтобы класс конфигурации знал о существовании классов @Component,
 * используется аннотация @ComponentScan. Мы помещаем эту аннотацию над именем класса конфигурации
 */

@ComponentScan
@Configuration
public class Config {
    @Bean
    public Person person() {
        return new Person("Mary");
    }

}

/**
 --- Here is what we "say" to our Application Context: ---
 * "Create a Person object with the property name = Mary";
 * "Call the created bean person";
 * "Place the bean into the IoC container".
 */
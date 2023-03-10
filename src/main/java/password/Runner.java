package password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;


// Компонент, который отвечает за взаимодействие с вводом-выводом: Чтобы достичь этого, component должен реализовать интерфейс CommandLineRunner
// и переопределить метод run. Это всего лишь эквивалент метода main в консольных приложениях.
// Вы можете написать там любой фрагмент кода, и он будет выполнен сразу после запуска приложения Spring.

@Component
// Когда Spring Boot запускает приложение, оно ищет все классы с аннотациями @Component и создает объекты этих классов (конструктор по умолчанию), которые затем будут ожидать в контейнере.
public class Runner implements CommandLineRunner {

    /**
     * Все бобы, созданные автоматически для компонентов, могут быть вставлены (injected) друг в друга с помощью аннотации @Autowired.
     * Механизм внедрения зависимостей работает точно так же, как вы видели с @Bean-аннотированными методами.
     * Поскольку они оба являются компонентами Spring, наши ранее объявленные классы PasswordGenerator и Runner могут использовать механизм внедрения зависимостей.
     * В качестве примера мы приведем модифицированную версию компонента Runner, которая содержит компонент autowired bean компонента PasswordGenerator.
     */
    ApplicationContext applicationContext;
    private final PasswordGenerator generator;

    // Здесь мы используем аннотацию @Autowired, чтобы сообщить Spring Boot, что нам нужен объект PasswordGenerator из контейнера.
    // Мы помещаем объект в контейнер с помощью @Component, а затем переносим его в другой объект с помощью @Autowired над его конструктором.

    // Если мы не хотим добавлять PasswordGenerator в конструктор другого компонента, мы можем просто поместить @Autowired в поле вместо этого.
    // Однако рекомендуется использовать инъекцию конструктора вместо инъекции поля.
    // Внедрение конструктора позволяет четко идентифицировать зависимости, помогает обеспечить потокобезопасность и упрощает тестирование кода.
    // Когда вы используете внедрение конструктора, аннотацию @Autowired можно опустить, но она обязательна при использовании внедрения поля, в противном случае ваши поля будут равны нулю
    @Autowired
    public Runner(PasswordGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run(String... args) {
        System.out.println("A short password: " + generator.generate(5));
        System.out.println("A long password: " + generator.generate(10));

        Arrays.toString(applicationContext.getBeanDefinitionNames());
    }
}

// Не нужно использовать CommandLineRunner в каждом приложении Spring,
// но этот компонент может быть использован в качестве временного решения при отладке или изучении новых возможностей фреймворка.
package lifecycle;

// TODO: 03.02.2023 Самый простой способ настроить процессы инициализации и уничтожения - добавить аннотации @PostConstruct и @PreDestroy к методам класса, управляемого контейнером.

// 1. Вот пример с методами init и destroy, аннотированными @PostConstruct и @PreDestroy.
// Если мы запустим приложение, содержащее этот компонент, Spring вызовет аннотированные методы только один раз.
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
class TechLibrary {
    private final List<String> bookTitles = Collections.synchronizedList(new ArrayList<>());

    @PostConstruct
    public void init() {
        bookTitles.add("Clean Code");
        bookTitles.add("The Art of Computer Programming");
        bookTitles.add("Introduction to Algorithms");
        System.out.println("The library has been initialized: " + bookTitles);
    }

    @PreDestroy
    public void destroy() {
        bookTitles.clear();
        System.out.println("The library has been cleaned: " + bookTitles);
    }

    // output
    // The library has been initialized: [Clean Code, The Art of Computer Programming, Introduction to Algorithms]
    // 2022-04-22 12:08:06.515  INFO Started HsSpringApplication in 0.382 seconds (JVM running for 5.698)
    // The library has been cleaned: []
}


/** 2.
 * В качестве альтернативы мы все еще можем добавить аннотации @PostConstruct и @PreDestroy к методам
 * init и destroy вместо указания атрибутов аннотации @Bean, даже если мы используем метод с аннотацией @Bean.
 */
@Configuration
class Config { // или можно так, но с @Bean (@PostConstruct и @PreDestroy не будет)

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public TechLibrary library() {
        return new TechLibrary();
    }
}

// Продвинутая концепция: - позволяет изменять новые экземпляры компонента по своему усмотрению.
// 3. Вы можете инициализировать bean-компоненты с помощью интерфейса BeanPostProcessor, который позволяет изменять экземпляры bean на заказ.
// Используя Post-processor, можно выполнить любую пользовательскую операцию до или сразу после инициализации компонента и даже вернуть измененный компонент.
// Пример Post-processor, который печатает только имя обработанного компонента:
@Component
class PostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Before initialization: " + beanName);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("After initialization: " + beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    // output
    // Длинный список компонентов в вашем приложении на разных этапах их жизненного цикла.
}

/**
 * Важно, чтобы BeanPostProcessor выполнялся для каждого компонента, определенного в контексте Spring, включая компоненты, созданные фреймворком.
 * В то же время можно предотвратить изменение некоторых компонентов, написав определенное условие.
 */

// TODO: 03.02.2023 постпроцессоры используются для обработки нескольких компонентов одним и тем же способом.
//  Процессоры обычно не привязаны к бизнес-логике и предоставляют некоторый инфраструктурный код, который изменяет или оборачивает компоненты.
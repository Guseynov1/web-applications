package Logging;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Этот класс включает в себя различные типы ошибок, чтобы продемонстрировать, как они выглядят в журнале.
 * Чтобы вызвать случай ошибки для этого класса, нам просто нужно запустить метод greetUser с пустой строкой в качестве аргумента.
 * Например, приведенный ниже код показывает один из способов, которым мы могли бы вызвать ошибку с помощью компонента CommandLineRunner.
 */

@AllArgsConstructor
@Component
public class Runner implements CommandLineRunner {
    private final LoggingController log;
    private final GreetingController greet;

    @Override
    public void run(String... args) throws InterruptedException {
        this.log.log();
        this.greet.greetUser("");
    }
}

// Когда это будет выполнено, в журнале будет отображено следующее.
/**
 * 13:32:33.640 [main] INFO com.example.demo.LoggingController - This is an INFO level log message!
 * 13:32:33.640 [main] ERROR com.example.demo.GreetingController - Provided empty greeting!
 * Exception in thread "main" java.lang.IllegalArgumentException
 * 	at com.example.demo.GreetingController.greetUser(GreetingController.java:19)
 * 	at com.example.demo.DemoApplication.main(DemoApplication.java:19)
 */

// Здесь следует отметить, что двум сообщениям журнала были присвоены два разных уровня: первый - ИНФОРМАЦИЯ, а второй - ОШИБКА.
// Второе, что следует отметить, это то, что для каждого сообщения журнала класс, который записал в журнал, отличается.
// Это позволяет нам точно знать, какой класс написал каждое сообщение журнала, что облегчает понимание и отладку кода.


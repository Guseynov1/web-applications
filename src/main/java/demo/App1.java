package demo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class App1 {

    public static void main(String[] args) {
        SpringApplication.run(App1.class, args);
    }

    @Bean
    public Customer customer(@Autowired String address) {
        return new Customer("Ben Miller", address);
    }

    @Bean
    public Customer temporary(@Autowired Customer customer) {
        System.out.println(customer);
        return customer;
    }

    @Configuration
    public class Addresses {
        @Bean
        public String address1() {
            return "Green Street, 102";
        }
        @Bean
        public String address2() {
            return "Apple Street, 15";
        }

        /**
         * Как мы упоминали ранее, местоположение точки инъекции определяется типом боба
         * @Qualifier - позволяет нам указать имя компонента, который нам нужно использовать (есть несколько компонентов одного типа и мы хотим использовать определенный из них)
         */
        @Bean
        public Customer customer(@Qualifier("address2") String address) { // указываем имя компонента, который нам нужно использовать для создания customer.
            return new Customer("Ben Miller", address);
        }

        @Bean
        public Customer temporary(@Autowired Customer customer) {
            // Customer{name='Ben Miller', address='Apple Street, 15'}
            System.out.println(customer);
            return customer;
        }
    }

    @AllArgsConstructor
    class Customer {
        private final String name;
        private final String address;

        @Override
        public String toString() {
            return "Customer{" + "name='" + name + '\'' + ", address='" + address + '\'' + '}';
        }
    }

}

/**
 * должны ли вы всегда использовать только бобы в Spring и забыть о стандартных объектах? Ответ - нет.
 * Вы все еще можете использовать стандартные объекты, создавая их вручную в соответствии с подходом ООП:
 * String address = "Green Street, 102";
 * Customer customer = new Customer("Ben Miller", address);
 * В реальных приложениях бобы обычно используются для формирования основы вашего приложения и разделения его по слоям и файлам конфигурации,
 * но большинство объектов домена (таких как учащиеся, учетные записи, курсы и т.д.) являются стандартными объектами.
 */




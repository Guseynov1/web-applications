package demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public Customer customer(@Autowired String greenStreet) {
        return new Customer("Ben Miller", greenStreet);
    }

    // Spring DI вводит компонент address в этот метод, и этот компонент может быть использован для создания нового объекта класса Customer.
    // Инъекция работает, потому что тип нужного нам компонента совпадает с типом компонента, созданного ранее(34), и Spring Container может вводить этот компонент.
    // Даже если бы у аргумента было другое имя (например, addr), этот код работал бы так, как ожидалось.

    // Аннотация @Autowired не всегда требуется для внедрения компонента. Spring в любом случае введет соответствующий компонент,
    // если метод имеет аннотацию @Bean (или некоторые другие). (можем опустить аннотацию и использовать конструктор.
    // Это возможно, потому что Spring IoC знает все components и может вводить их по типу, когда это необходимо)

    // временный компонент, в зависимости от Customer для распечатки авто подключаемого компонента
    // (чтобы удостовериться что оба метода (обычный и с помощью DI) вызваны и компоненты успешно созданы)
    @Bean
    public Customer temporary(@Autowired Customer customer) {
        System.out.println(customer);
        return customer;
    }

    // TODO: start
    @Configuration
    public class Addresses {
        @Bean("greenStreet")
        public String address() {
            return "Green Street, 102";
        }

		@Bean
		public String address1() {
			return "Apple Street, 15";
		}
        // создан только для печати информации во время запуска приложения.
		@Bean
		public Customer customer(@Qualifier("address1") String address) {
			return new Customer("Ben Miller", address);
		}

		@Bean
		public Customer temporary(@Autowired Customer customer) {
			// Customer{name='Ben Miller', address='Apple Street, 15'}
			System.out.println(customer);
			return customer;
		}
    }

    /**
     * @Autowired - помечает конструктор/поле/метод, как подлежащие инъекции с помощью Spring DI
     */ // этот класс включает в себя address, который мы собираемся получить из предыдущего компонента (greenStreet)
    @AllArgsConstructor
    @Getter
    class Customer {
        private final String name;
        private final String address;

        @Override
        public String toString() {
            return "Customer{" + "name='" + name + '\'' + ", address='" + address + '\'' + '}';
        }
    }
}

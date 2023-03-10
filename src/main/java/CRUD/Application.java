package CRUD;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Optional;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @RequiredArgsConstructor
    @Component
    public class Runner implements CommandLineRunner {
        private final TreadmillRepository repository;
        private void search() { // CREATE
            long count = repository.count(); // TODO: 1. Метод для чтения данных из БД
            if (count > 0) {
                System.out.printf("DataBase has %d treadmills", count);
            } else System.out.println("DataBase is empty");
        }
        ////////////////////////////////////////
        // TODO: 2. Метод для чтения данных из БД
        // 4. Теперь давайте обсудим еще два метода: findById и findAll. Методы existsById и findAllById аналогичны методу findById.
        // Единственное отличие заключается в том, что метод existsById возвращает логический флаг, который указывает, присутствует ли объект с запрошенным идентификатором в БД.
        // Метод findAllById позволяет запрашивать сразу несколько объектов по их идентификатору.

        /**
         * Метод findById возвращает Optional объект, который требует от вас выполнения дополнительных действий для доступа к реальному объекту.
         * Но если есть вероятность получения null объекта, вы должны обработать его в любом случае, либо с помощью Optional, либо с помощью ручной проверки "if not null".
         */
        // Кроме того, нам нужен метод для представления сущности в виде строки:
        private String createTreadmillView(Treadmill treadmill) { // READ
            return "Treadmill(code: %s, model: %s)".formatted(treadmill.getCode(), treadmill.getModel());
        }

        /** todo DELETE
         * CrudRepository предоставляет пять методов удаления. Мы собираемся рассмотреть методы deleteById и delete(entity).
         * Эти методы работают аналогично только для набора объектов одновременно. Метод deleteAll очищает все ваши объекты.
         */
        // Покажем как это работает методом:
        private void printAllTreadmills() { // DELETE
            Iterable<Treadmill> treadmills = repository.findAll();
            for (Treadmill treadmill : treadmills) {
                System.out.println(createTreadmillView(treadmill));
            }
        }


        @Override
        public void run(String... args) {
            // 2. Чтобы создать сущность в БД, нужно создать новый объект и передать его методу save.
            // Мы можем проверить нашу БД до и после вызова метода save следующим образом:
            System.out.println("Before save:");
            search();
            System.out.println("Saving...");
            repository.save(new Treadmill("aaa", "Yamaguchi runway"));
            repository.save(new Treadmill("bbb", "Yamaguchi runway pro-x"));
            repository.save(new Treadmill("ccc", "Yamaguchi max"));
            System.out.println("After save:");
            search();
            ////////////////////////////////////////
            // Метод 2.
            System.out.println("Looking for the treadmill with code='bbb'... ");
            Optional<Treadmill> treadmill = repository.findById("bbb");
            String result = treadmill.map(this::createTreadmillView).orElse("Not found");
            System.out.println(result);
            // TODO: 3. Метод для чтения данных из БД. Если вы хотите получить все объекты из БД,
            //  интерфейс CrudRepository предоставляет вам метод findAll. Это даже проще, чем findById:
//            Iterable<Treadmill> treadmills = repository.findAll();
//            for (Treadmill treadmill : treadmills) {
//                System.out.println(createTreadmillView(treadmill));
//            }
            // TODO: UPDATE
            // Eсли в БД есть объект с тем же идентификатором, save методы действуют как update методы.
            Optional<Treadmill> existedTreadmill = repository.findById("aaa");
            String existed = existedTreadmill.map(this::createTreadmillView).orElse("Not found");
            System.out.println("Before update: " + existed);
            System.out.println("Updating...");
            existedTreadmill.ifPresent(treadMill -> {
                treadMill.setModel("Yamaguchi runway-x");
                repository.save(treadMill);
            });
            Optional<Treadmill> updatedTreadmill = repository.findById("aaa");
            String updated = updatedTreadmill.map(this::createTreadmillView).orElse("Not found");
            System.out.println("After update: " + updated);
            /////////////////////////////
            // DELETE. Три типа беговых дорожек - это очень много. Мы решили удалить беговую дорожку "Yamaguchi max" из нашего списка. Он имеет code="ccc":
            System.out.println("Before delete: ");
            printAllTreadmills();

            System.out.println("Deleting...");
            repository.deleteById("ccc");

            System.out.println("After delete: ");
            printAllTreadmills();

            /**
             * Фитнес-центр - это не новая идея. У нас есть идея получше: теперь мы откроем коворкинг-центр,
             * оснащенный регулируемыми по высоте столами и компактными беговыми дорожками "Yamaguchi runway-x". Итак, нам нужно удалить "Yamaguchi runway pro-x":
             */
            System.out.println("Before delete: ");
            printAllTreadmills();
            System.out.println("Deleting...");
            Optional<Treadmill> proXTreadmill = repository.findById("bbb");
            proXTreadmill.ifPresent(
                    repository::delete // treadmiLL -> { repository.delete(treadmiLL); }
            );
            System.out.println("After delete: ");
            printAllTreadmills();
        }

    }


}
package hibernate;

// есть также способ выполнять настройку без использования XML, а с аннотациями - но только частично
// от файла сопоставления можно избавиться с помощью аннотаций, но конфигурационный все еще необходим.
// Аннотация - мощный способ определения взаимосвязи между объектом и реляционной моделью.
// если выбрать этот способ, то и класс POJO должен быть везде изменен на FlightAnother

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FLIGHT")
@Getter @Setter
@NoArgsConstructor
public class FlightAnother {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "flight_number")
    private String flightNumber;
    @Column(name = "departure")
    private String departure;
    @Column(name = "arrival")
    private String arrival;
    @Column(name = "date")
    private String flightDate;
    @Column(name = "fare")
    private int fare;

    public FlightAnother(String flightNumber, String departure, String arrival, String date, int fare) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.flightDate = date;
        this.fare = fare;
    }

}

/**
 * @Entity сообщает Hibernate, что этот класс — компонент сущности, и его объекты должны быть постоянными.
 * @Table применяется для указания имени создаваемой таблицы в базе данных.
 * @Id используется для определения первичного ключа. Можно также добавить совместно несколько полей, чтобы создать составной ключ.
 * @GeneratedValue определяет стратегию инкремента в поле. Это необязательный параметр — если он не определен с помощью @Id, применяется стратегия по умолчанию.
 * @Column определяет, как поле сопоставляется со столбцом в таблице.
 * Аннотация принимает такие атрибуты, как имя столбца, определение столбца, возможность принимать null-значение, уникальность и т. д.
 * В отличие от XML-файлов, здесь не нужно указывать тип, поскольку он берется непосредственно из поля.
 */

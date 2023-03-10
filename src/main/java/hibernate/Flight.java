package hibernate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// класс POJO, объекты которого будут сохраняться в таблице FLIGHT
@Getter @Setter
@NoArgsConstructor
public class Flight {
    private int id;
    private String flightNumber;
    private String departure;
    private String arrival;
    private String flightDate;
    private int fare;

    public Flight(String flightNumber, String departure, String arrival, String date, int fare) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.flightDate = date;
        this.fare = fare;
    }

}

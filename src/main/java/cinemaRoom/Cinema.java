package cinemaRoom;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class Cinema {
    private int rows;
    private int columns;
    List<Seat> available;

    public Cinema(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.available = new ArrayList<>();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                Seat seat = new Seat(i, j);
                available.add(seat);
            }
        }
    }
}

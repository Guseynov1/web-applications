package CRUD;

import lombok.AllArgsConstructor;
import lombok.Data;

// Объявление сущности может варьироваться в зависимости от используемой вами фактической БД.
// В зависимости от вашей целевой БД вы должны выбрать @Entity, @Document, @KeySpace или какую-либо другую аннотацию.
@Data
@AllArgsConstructor
public class Treadmill {
    private String code;
    private String model;
}
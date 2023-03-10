package CRUD;

import lombok.AllArgsConstructor;
import lombok.Data;

// Почему нет никаких аннотаций (тем не менее они должны быть) - Причина в том, что объявление сущности
// может варьироваться в зависимости от используемой вами фактической БД (тип и есть сущность).
// В зависимости от вашей целевой БД вы должны выбрать @Entity, @Document, @KeySpace или какую-либо другую аннотацию.
@Data
@AllArgsConstructor
public class Treadmill {
    private String code;
    private String model;
}
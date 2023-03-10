package DTO;

import java.time.LocalDate;

/**
 * These two lines of code provide:
 * private final field for each property
 * getter for each field
 * public constructor with all arguments
 * equals
 * hashCode
 * toString
 */
public record UserDTOR (int id, String username, LocalDate dateOfBirth) {
}

// TODO: 16.02.2023 Нет прямого ответа на то, что лучше использовать, Java record или Lombok.
//  Lombok обладает некоторыми особенностями Java records. С помощью Lombok вы можете настроить определенные уровни доступа к конструкторам или полям.
//  Он может реализовать шаблон builder, который может быть предпочтительнее, когда у нас много полей.
//  Тем не менее, вы можете захотеть использовать Java records для простых и неизменяемых объектов.

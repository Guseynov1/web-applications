package DTO;

// TODO: 16.02.2023 DTO pattern implementation has three core items:
//  * Domain object
//  * DTO object
//  * Mapper
//  User -> UserDTO -> UserService

// TODO: 16.02.2023 Насчет Lombok - вы должны быть осторожны с объектами JPA, потому что @EqualsAndHashCode может нарушить использование HashSet и HashMap.
//  Таким образом, использование Lombok довольно противоречиво и обычно зависит от соглашений команды. UserDTOR - DTO в виде record

/**
 * Отделение бизнес-логики от уровня связи;
 * Скрытие ненужных данных или защита конфиденциальной информации;
 * Избегание многократных обращений к удаленному серверу;
 * Предотвращение сбоев API во время обновления модели приложения.
 */

// mapper - функция, принимающая DTO в качестве входных данных и создает объект домена в качестве выходных данных и наоборот
// можем написать его вручную или взять из библиотеки auto-mapper

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Предположим, у нас есть доменный объект:
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String email;
    private LocalDate accountCreatedAt;

    // Имеет смысл реализовать методы преобразования на бизнес-уровне вашего приложения, поскольку они могут содержать некоторую логику.
    // Чтобы преобразовать UserDTO в User, вам необходимо получить некоторую дополнительную информацию:
    User convertDTOToUser(UserDTO dto) {
        User user = new User(dto.getId(), dto.getName(), dto.getEmail(), null);
        user.setAccountCreatedAt(LocalDate.now());
        return user;
    }



}

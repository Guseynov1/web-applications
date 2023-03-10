package com.example.web.business.businesslayer;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: 09.02.2023  Предположим, мы хотели создать приложение, которое хранит пользователей в БД и извлекает их из нее.
//  Мы хотели бы, чтобы пользователи могли получать доступ к приложению через конечные точки REST, и мы будем хранить данные внутри базы данных h2.
//  База данных h2 будет представлять уровень базы данных нашего приложения.
//  * для создания изоляции в приложении каждый код слоя храним в разных пакетах: классы: User -> UserRepository -> UserService -> UserController
//  Конфигурация, показывающая, как мы будем настраивать нашу БД:
/**
 * # Setup for the H2 console, used for viewing data in the database
 * spring.h2.console.enabled=true
 * spring.h2.console.path=/h2
 * spring.h2.console.username=sa
 *
 * # H2 data source setup
 * spring.datasource.url=jdbc:h2:file:~/test
 * spring.datasource.username=sa
 * spring.datasource.password=
 *
 * # Automatically update tables when persistence objects have changed
 * spring.jpa.hibernate.ddl-auto=update
 */

/**
 * Чтобы сохранить данные в нашей БД, нам нужно будет реализовать объект, представляющий сохраненные данные.
 * Для этого мы реализуем наш пользовательский объект на бизнес-уровне приложения.
 * Наша пользовательская реализация будет включать аннотации @Table и @Column, чтобы они хранились в базе данных.
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
}
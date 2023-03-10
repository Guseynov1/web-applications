package DAO;

import lombok.Getter;
import lombok.Setter;

// класс домена
@Getter @Setter
public class Todo {
    private int id;
    private String message;
    private int priority;
}

package com.example.web.RESTget;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private int id;
    private String name;
    private String description;
    private boolean completed;
}
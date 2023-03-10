package com.example.web.handlingRequests;

import lombok.*;

// Сначала мы создадим объект для представления данных JSON, которые будут отправлены в приложение. UserInfo -> UserInfoController
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private int id;
    private String name;
    private String phone;
    private boolean enabled;
}
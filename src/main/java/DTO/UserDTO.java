package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Дату создания учетной записи (accountCreatedAt) вы узнаете на стороне сервера, а клиентскому приложению эта информация не нужна.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String name;
    private String email;

    // ручной mapper (просто нужно создать новый объект и настроить его поля в соответствии с объектом домена)
    UserDTO convertUserToDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }


}

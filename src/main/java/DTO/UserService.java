package DTO;

import com.example.web.business.persistence.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;
    ModelMapper modelMapper;


    // после добавления зависимости для auto-mapper можно объявить mapper из библиотеки как компонент Spring, чтобы внедрить его в наш сервис:
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    // затем добавить mapper в конструктор Сервиса

    // mapper готов и теперь можем с его помощью реализовать наши 2 метода
    UserDTO convertUserToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    User convertDTOToUser(UserDTO dto) {
        User user = modelMapper.map(dto, User.class);
        user.setAccountCreatedAt(LocalDate.now());
        return user;
    }

    /**
     * Ваш DTO должен иметь пустой конструктор, геттеры и сеттеры для каждого поля, чтобы все работало нормально.
     * Все преобразование происходит автоматически без какой-либо конкретной настройки, поскольку все обязательные поля в UserDTO имеют одинаковое имя в классе User.
     * В более сложном случае вы всегда можете настроить экземпляр ModelMapper.
     */
}

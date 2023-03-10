package password;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO: Еще один объект, управляемый контейнером, помимо бобов - component - это особый вид класса (аннотация уровня класса),
//  который может быть автоматически определен Spring IoC и использован для внедрения зависимостей.
//  Компоненты в основном используются для:
//  * обеспечения высокого уровня развязки между различными частями приложения;
//  * распределения обязанностей между классами более эффективным способом.

/**
 * Spring IoC автоматически идентифицирует все классы, аннотированные с его помощью, и создает соответствующие управляемые компоненты.
 * По умолчанию для каждого bean существует только один component.
 * Обычно component имеет один или несколько нестатических методов, которые могут быть вызваны извне component.
 * Однако в некоторых ситуациях существуют компоненты без public методов.
 */

// Password, который создает компонент, содержащий информацию об алфавите, который мы хотели бы использовать:

@Configuration
public class Password {
    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMERIC = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*_=+-/";

    @Bean
    public PasswordAlphabet allCharacters() {
        return new PasswordAlphabet(ALPHA + NUMERIC + SPECIAL_CHARS);
    }

    record PasswordAlphabet(String characters) {
    }
}

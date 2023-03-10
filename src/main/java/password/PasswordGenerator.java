package password;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;

// Новая версия компонента PasswordGenerator, который применяет конфигурацию (Password) к процессу генерации пароля

public class PasswordGenerator {

    private static final Random random = new Random();
    private final Password.PasswordAlphabet alphabet;

    public PasswordGenerator(@Autowired Password.PasswordAlphabet alphabet) {
        this.alphabet = alphabet;
    }

    public String generate(int length) {
        String allCharacters = alphabet.characters(); // получите символы из компонента
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allCharacters.length());
            result.append(allCharacters.charAt(index));
        }
        return result.toString();
    }
}

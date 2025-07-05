package devtool;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordUtility {

    private final PasswordEncoder passwordEncoder;

    public PasswordUtility(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Test
    public void stringEncode() {

        String encodedPassword = passwordEncoder.encode("Password");
        System.out.print(encodedPassword);
    }
}

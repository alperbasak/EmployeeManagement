import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class PasswordEncrypter {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("12345"));
    }
}

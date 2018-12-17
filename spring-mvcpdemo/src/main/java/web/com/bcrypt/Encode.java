package web.com.bcrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encode {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "233333";

        String encodedPwd = encoder.encode(password);
        System.out.println(encodedPwd);
    }
}

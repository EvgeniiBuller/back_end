package de.ait.userapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class UserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
        /*
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded1 = encoder.encode("qwerty");
        System.out.println(encoded1);
        System.out.println(encoder.matches("qwerty1", encoded1));
        System.out.println(encoder.encode("qwerty"));

         */
    }

}
